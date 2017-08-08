package com.andreiox.flexible.control;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class ReflectionController {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static List castListObjectArrayIntoEntityClass(FQueryBuilder fqb, List<Object[]> ListObjectArray)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException,
			SecurityException {

		List list = new ArrayList<>();
		for (Object[] o : ListObjectArray)
			list.add(castOneObjectArrayIntoEntityClass(o, fqb.getEntityClass(), fqb.getAttributes()));

		return list;
	}

	private static Object castOneObjectArrayIntoEntityClass(Object[] objectArray, Class<?> entityClass, String[] attributes)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException,
			SecurityException {

		Object entityObject = null;
		entityObject = Class.forName(entityClass.getName()).newInstance();
		for (int i = 0; i < attributes.length; i++) {
			Field field = entityObject.getClass().getDeclaredField(attributes[i]);
			boolean accessibility = field.isAccessible();
			field.setAccessible(true);
			field.set(entityObject, objectArray[i]);
			field.setAccessible(accessibility);
		}

		return entityObject;
	}
}
