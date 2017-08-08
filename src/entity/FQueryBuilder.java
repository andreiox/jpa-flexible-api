package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import control.FlexibleQueryController;

@SuppressWarnings("rawtypes")
public class FQueryBuilder {

	private EntityManager entityManager;
	private Class entityClass;
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

	@SuppressWarnings("unchecked")
	public <T> T getSingleResult() throws Exception {
		return (T) FlexibleQueryController.doQuery(this).get(0);
	}

	public <T> List<T> getResultList() throws Exception {
		return FlexibleQueryController.doQuery(this);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<FParameter> getParameters() {
		return parameters;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public Class getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class entityClass) {
		this.entityClass = entityClass;
	}

	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String... attributes) {
		this.attributes = attributes;
	}

	public String[] getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String... groupBy) {
		this.groupBy = groupBy;
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
}
