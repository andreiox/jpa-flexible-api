package control;

import java.util.List;

import entity.FParameter;
import entity.FQueryBuilder;

public class FlexibleQueryController {

	private static final String SELECT_SINTAXE = "SELECT [[ATTRIBUTES]] from [[CLASS]] x WHERE [[WHERE_CLAUSE]]";

	public static <T> List<T> doQuery(FQueryBuilder fqb) {

		String jpql = buildJpql(fqb);

		return null;
	}

	private static String buildJpql(FQueryBuilder fqb) {

		StringBuilder sb = new StringBuilder(SELECT_SINTAXE);
		String attributes = generateAttributeClause(fqb.getAttributes());
		String classSimpleName = fqb.getEntityClass().getSimpleName();
		String whereClause = generateWhereClause(fqb.getParameters());

		return null;
	}

	@SuppressWarnings("rawtypes")
	private static String generateWhereClause(List<FParameter> parameters) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (FParameter param : parameters) {
			sb.append("x.");
			sb.append(param.getAtribute());
			sb.append(" ");
			sb.append(param.getOperator().getJpqlOperator());
			sb.append(" ");
			sb.append(":param");
			sb.append(count);

			/**
			 * FIXME Missing the logical connector
			 * 
			 */

			count++;
		}

		return sb.toString();
	}

	private static String generateAttributeClause(String[] attributes) {
		int size = attributes.length;
		if (size == 0)
			return "x";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append("x.");
			sb.append(attributes[i]);

			if (i != size - 1)
				sb.append(", ");
		}

		return sb.toString();
	}

}
