package entity;

import java.util.List;

import javax.persistence.EntityManager;

import control.FlexibleQueryController;

@SuppressWarnings("rawtypes")
public class FQueryBuilder {

	private EntityManager entityManager;
	private Class entityClass;
	private String[] attributes;
	private List<FParameter> parameters;
	private int maxResults;

	@SuppressWarnings("unchecked")
	public <T> T getSingleResult() throws Exception {
		return (T) FlexibleQueryController.doQuery(this).get(0);
	}

	public <T> List<T> getResultList() throws Exception {
		return FlexibleQueryController.doQuery(this);
	}

	public FQueryBuilder() {
	}

	public FQueryBuilder(EntityManager entityManager) {
		this.entityManager = entityManager;
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

	public void setParameters(List<FParameter> parameters) {
		this.parameters = parameters;
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

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}
}
