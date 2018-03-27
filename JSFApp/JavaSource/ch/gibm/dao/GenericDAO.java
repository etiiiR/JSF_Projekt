package ch.gibm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

abstract class GenericDAO<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Class<T> entityClass;

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public void save(T entity) {
		EntityManagerHelper.getEntityManager().persist(entity);
	}

	public void delete(Object id, Class<T> classe) {
		EntityManager em = EntityManagerHelper.getEntityManager();
		T entityToBeRemoved = em.getReference(classe, id);
		em.remove(entityToBeRemoved);
	}

	public T update(T entity) {
		return EntityManagerHelper.getEntityManager().merge(entity);
	}

	public T find(int entityID) {
		return EntityManagerHelper.getEntityManager().find(entityClass, entityID);
	}

	public T findReferenceOnly(int entityID) {
		return EntityManagerHelper.getEntityManager().getReference(entityClass, entityID);
	}

	public List<T> findAll() {
		EntityManager em = EntityManagerHelper.getEntityManager();
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(this.entityClass);
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;
		EntityManager em = EntityManagerHelper.getEntityManager();

		try {
			TypedQuery<T> query = em.createNamedQuery(namedQuery, this.entityClass);

			// populate parameters
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("No result found for named query: " + namedQuery);
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}

		return result;
	}

	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
}
