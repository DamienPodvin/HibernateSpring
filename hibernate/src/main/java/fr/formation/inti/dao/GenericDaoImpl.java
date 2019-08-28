package fr.formation.inti.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.formation.inti.utils.HibernateUtils;

/**
 * Notre classe TDaoImpl suit le modèle de conception Singleton qui
 * garantit qu'une seule instance de cette classe sera créée dans l'application.
 * Lors de la première création de classe, la méthode getEntityManager () est
 * chargée de créer une instance de EntityManager.
 * 
 * @author 
 * @param <T>
 * @param <I>
 *
 */

@Repository
public class GenericDaoImpl<T, I extends Serializable> implements IGenericDao <T,I> {

	private Class clazz;
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public List<T> getAll() {
		Query q = getCurrentSession().createQuery("FROM " + clazz.getSimpleName());		
		List<T> employees = q.list();
		return employees;
	}

	@Override
	public void persist(T e) {
		getCurrentSession().persist(e);
	}

	@Override
	public I save(T e) {
		
		return (I) getCurrentSession().save(e);
	}

	@Override
	public void update(T e) {
		getCurrentSession().update(e);
	}

	@Override
	public void delete(T e) {
		getCurrentSession().delete(e);
	}

	@Override
	public T findById(I id) {
		T emp = (T) getCurrentSession().get(clazz, id);
		return emp;
	}

	@Override
	public void deleteByID(I id) {
		try {
			T e = findById(id);
			delete(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void close() {
		HibernateUtils.shutdown();
	}


}
