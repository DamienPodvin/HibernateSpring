package fr.formation.inti.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<T, I extends Number> implements IGenericDao <T,I> {

	protected Class<? extends T> daoType;
	@Autowired
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }


	@Override
	public List<T> getAll() {
		return getCurrentSession().createCriteria(daoType).list();
	}

	private Session getCurrentSession() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession();
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
	public T findById(I id, Class<?> persistClass) {
		T emp = (T) getCurrentSession().get(persistClass, id);
		return emp;
	}

	@Override
	public void deleteByID(I id, Class<?> persistClass) {
		try {
			T e = findById(id, persistClass);
			delete(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}


}
