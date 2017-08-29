package com.andreiox.flexible.control;

import java.util.List;

import javax.persistence.Query;

import com.andreiox.flexible.entity.FParameter;
import com.andreiox.flexible.exception.JPQLBuilderException;
import com.andreiox.flexible.model.IOperator;

class FlexibleQueryController {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static <T> List<T> doQuery(FQueryBuilder builder) throws Exception {
		checkIfEssentialInformationIsProvided(builder);

		Query q = createQuery(builder);
		List result = null;
		List aux = q.getResultList();

		if (builder.getAttributes().length > 1)
			result = ReflectionController.castListObjectArrayIntoEntityClass(builder, (List<Object[]>) aux);
		else
			result = aux;

		return result;
	}

	private static void checkIfEssentialInformationIsProvided(FQueryBuilder builder) throws JPQLBuilderException {
		if (builder.getEntityManager() == null)
			throw new JPQLBuilderException("You must provide an EntityManager");

		else if (builder.getEntityClass() == null)
			throw new JPQLBuilderException("You must provide the Entity Class");
	}

	private static Query createQuery(FQueryBuilder builder) throws JPQLBuilderException {

		String jpql = JPQLBuilderController.buildJpql(builder);
		Query q = builder.getEntityManager().createQuery(jpql);
		setQueryParameters(q, builder.getParameters());
		q.setFirstResult(builder.getFirstResult());
		q.setMaxResults(builder.getMaxResults());

		return q;
	}

	private static void setQueryParameters(Query q, List<FParameter> parameters) {
		for (int i = 0; i < parameters.size(); i++) {
			FParameter param = parameters.get(i);
			IOperator operator = param.getOperator();
			operator.setQueryParameter(q, i, param.getValue(), param.getValue2());
		}
	}

}
