package projet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class NonLoginFilter
 */
@WebFilter("/*")
public class NonLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public NonLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	       HttpServletRequest req = (HttpServletRequest) request ;
	        HttpServletResponse res = (HttpServletResponse) response;
	        HttpSession session = req.getSession(false);
	        String loginURI = req.getContextPath() + "/login";

	        boolean loggedIn = session != null && session.getAttribute("emp") != null;
	        boolean loginRequest = req.getRequestURI().equals(loginURI);
	        
	        String chemin =req.getRequestURI().substring(req.getContextPath().length());
	        if(chemin.startsWith("/pageNonFiltre"))
	        	{chain.doFilter(req, res);
	        return ;}

	        if (loggedIn || loginRequest) {
	            chain.doFilter(req, res);
	        } else {
	            res.sendRedirect(loginURI);
	        }
	    
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
