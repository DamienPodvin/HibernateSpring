package fr.formation.inti;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.service.EmployeeService;

public class App4 {
	
	private static final Log log = LogFactory.getLog(App4.class);
	
	public static void main(String[] args) {
		
//		User user = new User();
		
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service = (EmployeeService) context.getBean("service");

//		EmployeeService service = new EmployeeService();

		List<Employee> list = service.findAll();
		for(Employee e : list)
			System.out.println("#### "+e);
		Employee emp = service.findById(39);
		log.info(emp);

		Employee emp2 = new Employee();
		emp2.setDepartment(emp.getDepartment());
		emp2.setEmployees(emp.getEmployees());
		emp2.setFirstName("Jean");
		emp2.setLastName("Cadeau");
		emp2.setManager(emp.getManager());
		emp2.setStartDate(new Date());
		
		list = service.findAll();
		System.out.println("Nombre employees :"+ list.size());
		Integer id = service.save(emp2);
		
		System.out.println("emp2 save id :"+ id);
		list = service.findAll();
		System.out.println("Nombre after save employees :"+ list.size());
		service.delete(id);
		list = service.findAll();
		System.out.println("Nombre after delete employees :" + list.size());
//		System.out.println("emp2 persist ? "+ session.contains(emp2));
		
		
		
	}

}
