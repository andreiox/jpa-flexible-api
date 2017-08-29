package com.andreiox.flexible.control;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class ReflectionController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static List castListObjectArrayIntoEntityClass(FQueryBuilder builder, List<Object[]> listObjectArray)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException,
			SecurityException {

		List list = new ArrayList<>();
		for (Object[] o : listObjectArray)
			list.add(castOneObjectArrayIntoEntityClass(o, builder.getEntityClass(), builder.getAttributes()));

		return list;
	}

	private static Object castOneObjectArrayIntoEntityClass(Object[] objectArray, Class<?> entityClass, String[] attributes)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException,
			SecurityException {

		Object entityObject = getNewInstanceFromClass(entityClass);
		entityObject = setAttributesValues(objectArray, attributes, entityObject);

		return entityObject;
	}

	private static Object getNewInstanceFromClass(Class<?> entityClass) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException {

		return Class.forName(entityClass.getName()).newInstance();
	}

	private static Object setAttributesValues(Object[] objectArray, String[] attributes, Object entityObject)
			throws NoSuchFieldException, IllegalAccessException {

		for (int i = 0; i < attributes.length; i++)
			setValueOfOneAttribute(entityObject, objectArray[i], attributes[i]);

		return entityObject;
	}

	private static void setValueOfOneAttribute(Object entityObject, Object value, String attribute) throws NoSuchFieldException,
			IllegalAccessException {

		Field field = entityObject.getClass().getDeclaredField(attribute);
		boolean accessibility = field.isAccessible();
		field.setAccessible(true);
		field.set(entityObject, value);
		field.setAccessible(accessibility);
	}

}
