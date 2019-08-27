package projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.service.EmployeeService;

/**
 * Servlet implementation class ValiderDelServlet
 */
@WebServlet("/valider")
public class ValiderDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Log log = LogFactory.getLog(ValiderDelServlet.class);
	EmployeeService service = new EmployeeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValiderDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rep = request.getParameter("Yes/No");
		int id =  Integer.parseInt(request.getParameter("id"));
		log.info("=============" + id);

		if(rep.equals("oui"))service.delete(id);
		String contex = request.getContextPath();
		response.sendRedirect(contex + "/Accueil.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
