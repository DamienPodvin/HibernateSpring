package projet.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Employee;
import fr.formation.inti.entities.User;
import fr.formation.inti.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(LoginServlet.class);
	UserService serviceUser = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.getRequestDispatcher("pageNonFiltre/Login.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		String mdp = request.getParameter("mdp");
		Employee emp = serviceUser.Login(pseudo, mdp);
		
		   Map<String, String> messages = new HashMap<String, String>();
		
	      if (pseudo == null || pseudo.isEmpty()) {
	            messages.put("pseudo", "Please enter pseudo");
	        }

	        if (mdp == null || mdp.isEmpty()) {
	            messages.put("mdp", "Please enter mdp");
	        }

	            if (emp != null) {
	                request.getSession().setAttribute("emp", emp);
	                request.getRequestDispatcher("Connexion.jsp").forward(request, response);
	                return;
	            } else {
	                messages.put("login", "Unknown login, please try again");
	            }
		        request.setAttribute("messages", messages);
		        request.getRequestDispatcher("NewLogin.jsp").forward(request, response); 
	        }


	    }
		

		// fonctionne sans le filtre
//		if(emp == null) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("NewLogin.jsp");
//			dispatcher.forward(request, response);
//		}
//		
//		else {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("Connexion.jsp");
//			dispatcher.forward(request, response);	
//		}



