package com.andreiox.flexible.model;

import javax.persistence.Query;

public interface IOperator {

	abstract void setQueryParameter(Query q, int paramNumber, Object value1, Object value2);

	abstract String getJpqlSyntax(String attribute, int paramNumber);

}
