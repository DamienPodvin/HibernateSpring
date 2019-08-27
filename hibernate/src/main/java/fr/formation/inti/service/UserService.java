package fr.formation.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.EmployeeDaoImpl;
import fr.formation.inti.dao.UserDaoImpl;
import fr.formation.inti.entities.Employee;
import fr.formation.inti.entities.User;
@Service
public class UserService {
	
	@Autowired
	private static UserDaoImpl dao;
	@Autowired
	private static EmployeeDaoImpl dao2;
	
	public UserService() {
		dao = new UserDaoImpl();
	}
	public void persist(User e) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(e);
        dao.closeCurrentSessionwithTransaction();
    }
	public Integer save(User e) {
		Integer id;
        dao.openCurrentSessionwithTransaction();
        id = dao.save(e);
        dao.closeCurrentSessionwithTransaction();
        return id;
    }
    public void update(User e) {
        dao.openCurrentSessionwithTransaction();
        dao.update(e);
        dao.closeCurrentSessionwithTransaction();
    }
 
    public User findById(Integer id) {
        dao.openCurrentSession();
        User emp = dao.findById(id);
        dao.closeCurrentSession();
        return emp;
    }
 
    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        User emp = dao.findById(id);
        dao.delete(emp);
        dao.closeCurrentSessionwithTransaction();
    }
    public List<User> findAll() {
        dao.openCurrentSession();
        List<User> Users = dao.getAll();
        dao.closeCurrentSession();
        return Users;
    }
 
    
 
    public UserDaoImpl UserDao() {
        return dao;
    }
	public Employee Login(String pseudo, String mdp) {
		dao.openCurrentSession();
        Employee emp = dao.Login(pseudo,mdp);
        dao.closeCurrentSession();	
		return emp;
	}

}
