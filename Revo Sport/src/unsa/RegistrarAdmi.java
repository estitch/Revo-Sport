package unsa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.servlet.RequestDispatcher;

import beans.Admi;
import beans.Cliente;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import datos.AdmiDatos;
import datos.ClienteDatos;

@SuppressWarnings("serial")
public class RegistrarAdmi extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		if (request.getParameter("action").equals("create")) {

			//	UserService us = UserServiceFactory.getUserService();
			// User user = us.getCurrentUser();



			String nombre = request.getParameter("nombre");
			String apellidop = request.getParameter("paterno");
			String apellidom = request.getParameter("materno");
			String dni = request.getParameter("dni");
			String direccion = request.getParameter("direccion");
			String distrito = request.getParameter("distrito");
			String provincia = request.getParameter("provincia");
			String departamento = request.getParameter("departamento");
			String direccionp = direccion + " - "  + " / "
					+ distrito + " / " + provincia + " / " + departamento;
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("correo");
			
			boolean ver = true;
			List<Admi> admis = AdmiDatos.verAdmis();
			for(int i=0;i<admis.size();i++){
				if(admis.get(i).getDni().equalsIgnoreCase(dni)){
					ver=false;
			}
			}
			if(ver==true){
				AdmiDatos.insertar(nombre, apellidop, apellidom, dni, direccionp, telefono, email);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoAdministrador.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
				rd.forward(request, response);
			}

		} else if (request.getParameter("action").equals("show")) {
			List<Admi> admis = AdmiDatos.verAdmis();
			request.setAttribute("verAdmis", admis);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/verAdministrador.jsp");
			rd.forward(request, response);


		}
		else if (request.getParameter("action").equals("buscar")) {

			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/busquedaAdministrador.jsp");
			rd.forward(request, response);


		} else if (request.getParameter("action").equals("borrar")) {
			
			boolean es = false;
			List<Admi> admis = AdmiDatos.verAdmis();
			UserService us = UserServiceFactory.getUserService();
			User user = us.getCurrentUser();
			for(int i=0;i<admis.size();i++){
				if (admis.get(i).getEmail().equals(user.getEmail())||us.isUserAdmin()==true) {

					if(admis.get(i).isPermiso()==true ){
						es = true;
					}
				} 
			}
			if(es==true){
				request.setAttribute("verAdmis", admis);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/borrarAdmi.jsp");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
				rd.forward(request, response);
			}
			//				UserService us = UserServiceFactory.getUserService();
			//				if (us.isUserAdmin() == true) {
			//					RequestDispatcher rd = getServletContext()
			//							.getRequestDispatcher("/borrarAdmi.jsp");
			//					rd.forward(request, response);
			//				} else {
			//					RequestDispatcher rd = getServletContext()
			//							.getRequestDispatcher("/Denegado.jsp");
			//					rd.forward(request, response);
			//
			//				}
		} else if (request.getParameter("action").equals("red")) {
			boolean es = false;
			List<Admi> admis = AdmiDatos.verAdmis();
			UserService us = UserServiceFactory.getUserService();
			User user = us.getCurrentUser();
			for(int i=0;i<admis.size();i++){
				if (admis.get(i).getEmail().equals(user.getEmail())||us.isUserAdmin()==true) {

					if(admis.get(i).isPermiso()==true ){
						es = true;
					}
				} 
			}
			if(es==true){
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoAdministrador.jsp");
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
