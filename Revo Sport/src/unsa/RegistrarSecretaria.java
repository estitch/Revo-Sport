package unsa;

import java.io.IOException;






import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.servlet.RequestDispatcher;

import beans.Admi;
import beans.Secretaria;
import beans.Trainer;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import datos.AdmiDatos;
import datos.SecretariaDatos;
import datos.TrainerDatos;

@SuppressWarnings("serial")
public class RegistrarSecretaria extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
			if (request.getParameter("action").equals("create")) {

				String nombre = request.getParameter("nombre");
				String apellidop = request.getParameter("apellidoP");
				String apellidom = request.getParameter("apellidoM");
				String dia = request.getParameter("dia");
				String mes = request.getParameter("mes");
				String anio = request.getParameter("anio");
				String fechanac = dia + " / " + mes + " / " + anio;
				String documento = request.getParameter("documento");
				String estado = request.getParameter("estado");
				String sexo = request.getParameter("sexo");
				String direccion = request.getParameter("direccion");
				String distrito = request.getParameter("distrito");
				String provincia = request.getParameter("provincia");
				String departamento = request.getParameter("departamento");
				String direccionp = direccion  + " / "
						+ distrito + " / " + provincia + " / " + departamento;
				String celular = request.getParameter("celular");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				
				
				boolean ver = true;
				List<Secretaria> secre = SecretariaDatos.verSecretarias();
				for(int i=0;i<secre.size();i++){
					if(secre.get(i).getDocumento().equalsIgnoreCase(documento))
						ver=false;
					
				}
				if(ver==true){
					SecretariaDatos.insertar(nombre, apellidop, apellidom, fechanac,
						documento, estado, sexo, direccionp, celular, telefono, email);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoSecretaria.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
					rd.forward(request, response);
				}

			} else if (request.getParameter("action").equals("show")) {
				
				List<Secretaria> secre = SecretariaDatos.verSecretarias();
				request.setAttribute("secretaria", secre);
					RequestDispatcher rd = getServletContext()
							.getRequestDispatcher("/verSecretarias.jsp");
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
					List<Secretaria> secretarias = SecretariaDatos.verSecretarias();
					request.setAttribute("secretarias", secretarias);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/borrarSecretaria.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarSecretaria.jsp");
					rd.forward(request, response);
				}
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
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoSecretaria.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
					rd.forward(request, response);
				}
			}
			try {} catch (Exception e) {
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher("/errorSecretaria.jsp");
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
