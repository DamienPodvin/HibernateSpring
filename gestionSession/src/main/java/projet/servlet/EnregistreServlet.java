package projet.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.PropertyValueException;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.service.EmployeeService;

/**
 * Servlet implementation class EnregistreServlet
 */
@WebServlet("/reg")
public class EnregistreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(EnregistreServlet.class);
	EmployeeService service = new EmployeeService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnregistreServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Boolean exist = false;

		String name = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = request.getParameter("Date");
		Date datepars = null;
		try {
			 datepars = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Employee emp = new Employee();
		emp.setFirstName(name);
		emp.setLastName(prenom);
		emp.setStartDate(datepars);
		List<Employee> listEmp = service.findAll();
		for (Employee e : listEmp) {

			if ((e.getFirstName().equals(emp.getFirstName())) && (e.getLastName().equals(emp.getLastName()))) {
				request.setAttribute("e", e);
				exist = true;
				}
				else {
					try {
						service.save(emp);
						String contex = request.getContextPath();
						response.sendRedirect(contex + "/Accueil.jsp");
						return;
					}catch (PropertyValueException except) {
						String contex = request.getContextPath();
						response.sendRedirect(contex + "/NewInscription.jsp");
						return ;
					}
				}	
			
		}
		if (exist) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("LoginProfilExist.jsp");
			dispatcher.forward(request, response);
		} 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
