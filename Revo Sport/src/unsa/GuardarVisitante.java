package unsa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.servlet.RequestDispatcher;

import beans.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import datos.*;

@SuppressWarnings("serial")
public class GuardarVisitante extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		if (request.getParameter("action").equals("create")) {

			String dni = request.getParameter("dni");

			VisitanteDatos.insertar(dni);
			request.setAttribute("dni", dni);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoVisitante.jsp");
			rd.forward(request, response);

		} else if (request.getParameter("action").equals("show")) {
			List<Visitante> visitantes = VisitanteDatos.verVisitante();
			request.setAttribute("visitantes", visitantes);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/verVisitantes.jsp");
			rd.forward(request, response);


		}
		else if (request.getParameter("action").equals("buscar")) {
			
			String dni = request.getParameter("dni");
			List<Visitante> visitantes = VisitanteDatos.buscardniVisitante(dni);
			request.setAttribute("visitantes", visitantes);
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/busquedaVisitantes.jsp");
			rd.forward(request, response);


		}  else if (request.getParameter("action").equals("red")) {
			boolean es = false;
			List<Secretaria> secretarias = SecretariaDatos.verSecretarias();
			UserService us = UserServiceFactory.getUserService();
			User user = us.getCurrentUser();
			for(int i=0;i<secretarias.size();i++){
				if (secretarias.get(i).getEmail().equals(user.getEmail())||us.isUserAdmin()==true) {
						es = true;
				} 
			}
			if(es==true){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/registrarVisitante.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
				rd.forward(request, response);
			}
		}try { 
		} catch (Exception e) {
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
