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
		List list = q.getResultList();

		return list;
	}

	private static Query createQuery(FQueryBuilder fqb) throws JPQLBuilderException {
		String jpql = JPQLBuilderController.buildJpql(fqb);
		Query q = fqb.getEntityManager().createQuery(jpql);
		setQueryParameters(q, fqb.getParameters());

		return q;
	}

	@SuppressWarnings("rawtypes")
	private static void setQueryParameters(Query q, List<FParameter> parameters) {
		int count = 0;
		for (FParameter param : parameters) {
			if (param.getValue() != null)
				q.setParameter(MessageFormat.format("param{0}", (count++)), param.getValue());
		}
	}

}
