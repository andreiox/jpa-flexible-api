package control;

import java.util.List;

import entity.FParameter;
import entity.FQueryBuilder;
import exception.JPQLBuilderException;

public class JPQLBuilderController {

	public static String buildJpql(FQueryBuilder fqb) throws JPQLBuilderException {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(generateAttributeClause(fqb.getAttributes()));
		sb.append(" FROM ");
		sb.append(getEntityClassSimpleName(fqb.getEntityClass()));
		sb.append(" x WHERE ");
		sb.append(generateWhereClause(fqb.getParameters()));

		return new String(sb);
	}

	@SuppressWarnings("rawtypes")
	private static String getEntityClassSimpleName(Class entityClass) throws JPQLBuilderException {

		if (entityClass == null)
			throw new JPQLBuilderException("Entity Class cannot be null.");

		return entityClass.getSimpleName();
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

	@SuppressWarnings("rawtypes")
	private static String generateWhereClause(List<FParameter> parameters) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("1=1");

		if (parameters != null) {
			for (FParameter param : parameters) {
				sb.append(" AND ");
				sb.append("x.");
				sb.append(param.getAtribute());
				if (param.getValue() == null) {
					sb.append(" is null");
				} else {
					sb.append(" ");
					sb.append(param.getOperator().getJpqlOperator());
					sb.append(" ");
					sb.append(":param");
					sb.append(count++);
				}
			}
		}

		return sb.toString();
	}
}
