package unsa;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class CerrarServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		UserService us = UserServiceFactory.getUserService();
		HttpSession sesion= req.getSession();
		User user = us.getCurrentUser();
	 	
			if(user == null){
	            RequestDispatcher rd = req.getRequestDispatcher("/portada.html");
	   		 	rd.forward(req, resp);
	        }
	        else{
		
	        	sesion.invalidate();
	        	resp.sendRedirect(us.createLogoutURL(req.getRequestURI()));
	        	
	        }
	}
}
