package fr.formation.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.dao.EmployeeDaoImpl;
import fr.formation.inti.entities.Employee;

@Service("service")
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeDaoImpl dao;
	
	
	
	public void setDao(EmployeeDaoImpl dao) {
		this.dao = dao;
	}
	public EmployeeService() {
		System.out.println("EmployeeService");
	}
	public void persist(Employee e) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(e);
        dao.closeCurrentSessionwithTransaction();
    }
	public Integer save(Employee e) {
		Integer id;
        dao.openCurrentSessionwithTransaction();
        id = dao.save(e);
        dao.closeCurrentSessionwithTransaction();
        return id;
    }
    public void update(Employee e) {
        dao.openCurrentSessionwithTransaction();
        dao.update(e);
        dao.closeCurrentSessionwithTransaction();
    }
 
    public Employee findById(Integer id) {
        dao.openCurrentSession();
        Employee emp = dao.findById(id);
        dao.closeCurrentSession();
        return emp;
    }
 
    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Employee emp = dao.findById(id);
        dao.delete(emp);
        dao.closeCurrentSessionwithTransaction();
    }
    public List<Employee> findAll() {
        dao.openCurrentSession();
        List<Employee> employees = dao.getAll();
        dao.closeCurrentSession();
        return employees;
    }
 
    
 
    public EmployeeDaoImpl EmployeeDao() {
        return dao;
    }

}
