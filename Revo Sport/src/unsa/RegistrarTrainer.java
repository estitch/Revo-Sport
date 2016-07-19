package unsa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.util.List;

import javax.servlet.RequestDispatcher;

import beans.Admi;
import beans.Secretaria;
import beans.Trainer;
import datos.AdmiDatos;
import datos.SecretariaDatos;
import datos.TrainerDatos;



@SuppressWarnings("serial")
public class RegistrarTrainer extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
			if (request.getParameter("action").equals("create")) {
				

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
				List<Trainer> admis = TrainerDatos.verTrainer();
				for(int i=0;i<admis.size();i++){
					if(admis.get(i).getdni().equalsIgnoreCase(dni))
						ver=false;
					
				}
				if(ver==true){
					TrainerDatos.insertar(nombre, apellidop, apellidom, dni, direccionp, telefono, email);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/ConfirmarTrainer.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
					rd.forward(request, response);
				}
			} else if (request.getParameter("action").equals("show")) {

				List<Trainer> admis = TrainerDatos.verTrainer();
				request.setAttribute("verTrainer", admis);
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/verTrainer.jsp");
				rd.forward(request, response);


			} else if (request.getParameter("action").equals("buscar")) {

				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/busquedaTrainer.jsp");
				rd.forward(request, response);

			
			} else if (request.getParameter("action").equals("actualizar")) {

				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher("/actualizarTrainer.jsp");
				rd.forward(request, response);

				
			} else if (request.getParameter("action").equals("borrar")) {

				boolean es = false;
				List<Admi> admis = AdmiDatos.verAdmis();
				List<Secretaria> secretarias = SecretariaDatos.verSecretarias();
				UserService us = UserServiceFactory.getUserService();
				User user = us.getCurrentUser();
				for(int i=0;i<admis.size();i++){
					if (admis.get(i).getEmail().equals(user.getEmail())||us.isUserAdmin()==true) {

						if(admis.get(i).isPermiso()==true ){
							es = true;
							break;
						}
					} 
				}
				if(es==false){
					for(int i=0;i<secretarias.size();i++){
						if (secretarias.get(i).getEmail().equals(user.getEmail())) {
								es = true;
								break;
						} 
					}
				}
				if(es==true){
					List<Trainer> trainers = TrainerDatos.verTrainer();
					request.setAttribute("trainers", trainers);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/borrarTrainer.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarTrainer.jsp");
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
				List<Secretaria> secretarias = SecretariaDatos.verSecretarias();
				UserService us = UserServiceFactory.getUserService();
				User user = us.getCurrentUser();
				for(int i=0;i<admis.size();i++){
					if (admis.get(i).getEmail().equals(user.getEmail())||us.isUserAdmin()==true) {

						if(admis.get(i).isPermiso()==true ){
							es = true;
							break;
						}
					} 
				}
				if(es==false){
					for(int i=0;i<secretarias.size();i++){
						if (secretarias.get(i).getEmail().equals(user.getEmail())) {
								es = true;
								break;
						} 
					}
				}
				if(es==true){
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoTrainer.jsp");
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