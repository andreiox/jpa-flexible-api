package com.andreiox.flexible.control;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.andreiox.flexible.entity.FOperator;
import com.andreiox.flexible.entity.FOrderBy;
import com.andreiox.flexible.entity.FParameter;

public class FQueryBuilder {

	private EntityManager entityManager;
	private Class<?> entityClass;
	private String[] attributes;
	private List<FParameter> parameters;
	private String[] groupBy;
	private FOrderBy orderBy;
	private int firstResult;
	private int maxResults;

	public FQueryBuilder() {
		parameters = new ArrayList<FParameter>();
	}

	public FQueryBuilder(EntityManager entityManager) {
		this();
		this.entityManager = entityManager;
	}

	public FQueryBuilder(EntityManager entityManager, Class<?> entityClass) {
		this(entityManager);
		this.entityClass = entityClass;
	}

	@SuppressWarnings("unchecked")
	public <T> T getSingleResult() throws Exception {
		return (T) FlexibleQueryController.doQuery(this).get(0);
	}

	public <T> List<T> getResultList() throws Exception {
		return FlexibleQueryController.doQuery(this);
	}

	public void addParameter(String atribute, FOperator operator) {
		parameters.add(new FParameter(atribute, operator));
	}

	public void addParameter(String atribute, FOperator operator, Object value) {
		parameters.add(new FParameter(atribute, operator, value));
	}

	public void addParameter(String atribute, FOperator operator, Object value1, Object value2) {
		parameters.add(new FParameter(atribute, operator, value1, value2));
	}

	public void setAttributes(String... attributes) {
		this.attributes = attributes;
	}

	public void setGroupBy(String... groupBy) {
		this.groupBy = groupBy;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<?> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}

	public List<FParameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<FParameter> parameters) {
		this.parameters = parameters;
	}

	public FOrderBy getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(FOrderBy orderBy) {
		this.orderBy = orderBy;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public String[] getAttributes() {
		return attributes;
	}

	public String[] getGroupBy() {
		return groupBy;
	}
}
