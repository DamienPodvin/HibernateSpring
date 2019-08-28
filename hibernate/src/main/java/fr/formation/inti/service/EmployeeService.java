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
       
        dao.persist(e);
      
    }
	public Integer save(Employee e) {
		
        return dao.save(e);
        
    }
    public void update(Employee e) {
     
        dao.update(e);
       
    }
 
    public Employee findById(Integer id) {
        
        return dao.findById(id, Employee.class);
        
        
    }
 
    public void delete(Integer id) {
        
        Employee emp = dao.findById(id,Employee.class);
        dao.delete(emp);
    }
    public List<Employee> findAll() {
        
        return dao.getAll();
    }
 
    
 
    public EmployeeDaoImpl EmployeeDao() {
        return dao;
    }

}
