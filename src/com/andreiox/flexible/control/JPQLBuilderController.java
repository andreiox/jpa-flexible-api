package com.andreiox.flexible.control;

import java.util.List;

import com.andreiox.flexible.entity.FOrderBy;
import com.andreiox.flexible.entity.FParameter;

class JPQLBuilderController {

	static String buildJpql(FQueryBuilder builder) {

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(generateAttributeClause(builder.getAttributes()));
		sb.append(" FROM ");
		sb.append(getEntityClassSimpleName(builder.getEntityClass()));
		sb.append(" x");
		sb.append(generateWhereClause(builder.getParameters()));
		sb.append(generateGroupBy(builder.getGroupBy()));
		sb.append(generateOrderBy(builder.getOrderBy()));

		return new String(sb);
	}

	private static String getEntityClassSimpleName(Class<?> entityClass) {
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
		return fParameter.getOperator().getJpqlSyntax(fParameter.getAtribute(), i);
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
