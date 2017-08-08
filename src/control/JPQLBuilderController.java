package control;

import java.util.List;

import entity.FOperator;
import entity.FOrderBy;
import entity.FParameter;
import exception.JPQLBuilderException;

class JPQLBuilderController {

	static String buildJpql(FQueryBuilder fqb) throws JPQLBuilderException {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(generateAttributeClause(fqb.getAttributes()));
		sb.append(" FROM ");
		sb.append(getEntityClassSimpleName(fqb.getEntityClass()));
		sb.append(" x");
		sb.append(generateWhereClause(fqb.getParameters()));
		sb.append(generateGroupBy(fqb.getGroupBy()));
		sb.append(generateOrderBy(fqb.getOrderBy()));

		return new String(sb);
	}

	@SuppressWarnings("rawtypes")
	private static String getEntityClassSimpleName(Class entityClass) throws JPQLBuilderException {
		if (entityClass == null)
			throw new JPQLBuilderException("Entity Class cannot be null.");

		return entityClass.getSimpleName();
	}

	private static String generateAttributeClause(String[] attributes) {
		if (attributes.length == 0)
			return "x";

		return getStringOfAttributesSeparatedByComma(attributes);
	}

	private static String generateWhereClause(List<FParameter> parameters) {
		StringBuilder sb = new StringBuilder();

		int size = parameters.size();
		if (size != 0) {
			sb.append(" WHERE ");
			for (int i = 0; i < size; i++) {
				FParameter fParameter = parameters.get(i);
				sb.append(generateClauseForOneParameter(i, fParameter));

				if (i != size - 1)
					sb.append(" AND ");
			}
		}

		return new String(sb);
	}

	private static String generateClauseForOneParameter(int i, FParameter fParameter) {
		StringBuilder sb = new StringBuilder();
		sb.append("x.");
		sb.append(fParameter.getAtribute());
		sb.append(" ");
		sb.append(fParameter.getOperator().getJpqlOperator());

		if (fParameter.getOperator() == FOperator.BETWEEN) {
			sb.append(" ");
			sb.append(":param0");
			sb.append(i);
			sb.append(" AND ");
			sb.append(":param1");
			sb.append(i);
		} else if (fParameter.getOperator() != FOperator.ENDS_WITH && fParameter.getOperator() != FOperator.DOESNT_END_WITH) {
			sb.append(" ");
			sb.append(":param");
			sb.append(i);
		}

		return new String(sb);
	}

	private static String generateGroupBy(String[] groupByAttributes) {
		StringBuilder sb = new StringBuilder();
		if (groupByAttributes.length != 0) {
			sb.append(" GROUP BY ");
			sb.append(getStringOfAttributesSeparatedByComma(groupByAttributes));
		}

		return new String(sb);
	}

	private static String generateOrderBy(FOrderBy orderBy) {
		StringBuilder sb = new StringBuilder();
		if (orderBy != null && orderBy.getAttributes().length != 0) {
			sb.append(" ORDER BY ");
			sb.append(getStringOfAttributesSeparatedByComma(orderBy.getAttributes()));
			sb.append(" ");
			sb.append(orderBy.getSortOrder().getJpqlSyntax());
		}

		return new String(sb);
	}

	private static String getStringOfAttributesSeparatedByComma(String[] attributes) {
		StringBuilder sb = new StringBuilder();
		int size = attributes.length;
		for (int i = 0; i < size; i++) {
			sb.append("x.");
			sb.append(attributes[i]);

			if (i != size - 1)
				sb.append(", ");
		}

		return new String(sb);
	}
}
