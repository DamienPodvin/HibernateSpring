package fr.formation.inti.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.entities.User;
import fr.formation.inti.utils.HibernateUtils;

public class UserDaoImpl implements IUserDao {
	
	private Session currentSession;
	private Transaction currentTransaction;

	public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    @Override
	public List<User> getAll() {
		Query q = getCurrentSession().createQuery("FROM " + User.class.getName());		
		List<User> Users = q.list();
		return Users;
	}

	@Override
	public void persist(User e) {
		getCurrentSession().persist(e);
	}

	@Override
	public Integer save(User e) {
		
		return (Integer) getCurrentSession().save(e);
	}

	@Override
	public void update(User e) {
		getCurrentSession().update(e);
	}

	@Override
	public void delete(User e) {
		getCurrentSession().delete(e);
	}

	@Override
	public User findById(Integer id) {
		User emp = (User) getCurrentSession().get(User.class, id);
		return emp;
	}

	@Override
	public void deleteByID(Integer id) {
		try {
			User e = findById(id);
			delete(e);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void close() {
		HibernateUtils.shutdown();
	}

	public Employee Login(String pseudo, String mdp) {
		 String sql = "Select emp from " + User.class.getName() + " e where e.pseudo= \'"+mdp+"\' and e.mdp='"+ pseudo +"'";
		Query q = getCurrentSession().createQuery(sql);	
		List<Integer> result =q.list();
		Iterator it = result.iterator();
		Employee emp = (Employee) it.next();
		return emp;
			}
		
	}
