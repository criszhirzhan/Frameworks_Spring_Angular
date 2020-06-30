package ec.edu.ups.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import ec.edu.ups.dao.GenericDAO;

public class AbstractJpaDAO < T , ID> implements GenericDAO<T, ID>{
	
	private Class<T> persistentClass;
	   @PersistenceContext
	   EntityManager entityManager;
	 
	   public AbstractJpaDAO() {
		   ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
			this.persistentClass = (Class) genericSuperclass.getActualTypeArguments()[1];
		}

	 @Transactional
	@Override
	public boolean create(T entity) {
		entityManager.persist( entity );
	return false;
		
	}

	@Override
	public T findOne(ID id) {
		return entityManager.find(persistentClass, id);
	}
	@Override
	public boolean update(T entity) {
		entityManager.getTransaction().begin();
		try {
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:update " + e);
			if (entityManager.getTransaction().isActive())
				entityManager.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public boolean delete(T entity) {
		System.out.println("ELIMINANDO...");
		entityManager.getTransaction().begin();
		try {
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(">>>> ERROR:JPAGenericDAO:delete " + e);
			if (entityManager.getTransaction().isActive())
				entityManager.getTransaction().rollback();
			return false;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<T> findAll() {
		entityManager.getTransaction().begin();
		List<T> lista = null;
		try {
			CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
			cq.select(cq.from(persistentClass));
			lista = entityManager.createQuery(cq).getResultList();
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
		
}
