package unsa;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import datos.*;

@SuppressWarnings("serial")
public class GmailServlet extends HttpServlet {
 public void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws IOException, ServletException {
	 resp.setContentType("text/html");
 
 
	 UserService us = UserServiceFactory.getUserService();
	 User user = us.getCurrentUser();
 	
	 if(user == null){
		/*List<Admi> admis = AdmiDatos.verAdmis();
		List<Medico> medicos = MedicoDatos.verMedicos();
		List<Object> general = null;
		
		general.addAll(admis);
		general.addAll(medicos);
		for(int i=0;i<general.size();i++){
			if(user.getEmail().equals(general.get(i))){
				
			}
		}*/
		
		HttpSession sesion= req.getSession(true);
		resp.sendRedirect(us.createLoginURL(req.getRequestURI())); 
	 }
	 else{
		 RequestDispatcher rd = req.getRequestDispatcher("/portada.jsp");
		 rd.forward(req, resp);
	 }
 }
}