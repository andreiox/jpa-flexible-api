package control;

import java.text.MessageFormat;
import java.util.List;

import javax.persistence.Query;

import entity.FParameter;
import entity.FQueryBuilder;
import exception.JPQLBuilderException;

public class FlexibleQueryController {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> List<T> doQuery(FQueryBuilder fqb) throws Exception {
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
		if (fqb.getMaxResults() != 0)
			q.setMaxResults(fqb.getMaxResults());

		return q;
	}

	private static void setQueryParameters(Query q, List<FParameter> parameters) {
		int count = 0;
		for (FParameter param : parameters) {
			if (param.getValue() != null)
				q.setParameter(MessageFormat.format("param{0}", (count++)), param.getValue());
		}
	}

}
