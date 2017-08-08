package com.andreiox.flexible.control;

import java.util.List;

import javax.persistence.Query;

import com.andreiox.flexible.entity.FOperator;
import com.andreiox.flexible.entity.FParameter;
import com.andreiox.flexible.exception.JPQLBuilderException;

class FlexibleQueryController {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static <T> List<T> doQuery(FQueryBuilder fqb) throws Exception {
		Query q = createQuery(fqb);
		List result = null;
		List aux = q.getResultList();

		if (fqb.getAttributes().length < 2)
			result = aux;
		else
			result = ReflectionController.castListObjectArrayIntoEntityClass(fqb, (List<Object[]>) aux);

		return result;
	}

	private static Query createQuery(FQueryBuilder fqb) throws JPQLBuilderException {
		if (fqb.getEntityManager() == null)
			throw new JPQLBuilderException("You must provide an EntityManager");

		String jpql = JPQLBuilderController.buildJpql(fqb);
		Query q = fqb.getEntityManager().createQuery(jpql);
		setQueryParameters(q, fqb.getParameters());
		q.setFirstResult(fqb.getFirstResult());
		q.setMaxResults(fqb.getMaxResults());

		return q;
	}

	private static void setQueryParameters(Query q, List<FParameter> parameters) {
		for (int i = 0; i < parameters.size(); i++) {
			FParameter param = parameters.get(i);
			FOperator operator = param.getOperator();

			if (operator == FOperator.IS_NULL || operator == FOperator.IS_NOT_NULL)
				continue;

			else if (operator == FOperator.ENDS_WITH || operator == FOperator.DOESNT_END_WITH)
				q.setParameter(String.format("param{0}", i), String.format("{0}%", param.getValue()));

			else if (operator == FOperator.STARTS_WITH || operator == FOperator.DOESNT_START_WITH)
				q.setParameter(String.format("param{0}", i), String.format("%{0}", param.getValue()));

			else if (operator == FOperator.CONTAIN || operator == FOperator.DONT_CONTAIN)
				q.setParameter(String.format("param{0}", i), String.format("%{0}%", param.getValue()));

			else if (operator == FOperator.BETWEEN) {
				q.setParameter(String.format("param0{0}", i), param.getValue());
				q.setParameter(String.format("param1{0}", i), param.getValue2());
			}

			else
				q.setParameter(String.format("param{0}", i), param.getValue());
		}
	}

}
