package control;

import java.util.List;

import javax.persistence.EntityManager;

import dto.FParameter;

@SuppressWarnings("rawtypes")
public class FQueryBuilder {

	private EntityManager entityManager;
	private Class entityClass;
	private List<String> attributes;
	private List<FParameter> parameters;
	private int maxResults;

	public <T> T getSingleResult() {
		return null;
	}

	public <T> List<T> getResultList() {
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

	public List<String> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<String> attributes) {
		this.attributes = attributes;
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
}
