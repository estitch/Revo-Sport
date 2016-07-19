package unsa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.servlet.RequestDispatcher;

import datos.*;
import beans.*;

import java.io.PrintWriter;
import java.util.*;

import javax.jdo.Query;
import javax.jdo.PersistenceManager;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


@SuppressWarnings("serial")
public class ActualizarSecretaria extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("action").equals("create")) {
			String cod= request.getParameter("dni");
			PersistenceManager pm = PMF.get().getPersistenceManager();
			
			String query = "select from " +Secretaria.class.getName();
			Query q = pm.newQuery(query);
			q.setFilter("documento == nombreParam");
			q.declareParameters("String nombreParam");
			
			
				List<Secretaria> secretarias = (List<Secretaria>)q.execute(cod);
				
				for (Secretaria a : secretarias) {
					
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
					
					a.setNombre(nombre);
					a.setApellidom(apellidom);
					a.setApellidop(apellidop);
					a.setDocumento(dni);
					a.setDireccionp(direccionp);
					a.setTelefono(telefono);
					a.setEmail(email);
					break;
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/portada.jsp");
				rd.forward(request, response);
		}
			 else {
					
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
						String dni=(String) request.getParameter("action");
						List<Secretaria> secretarias1 = SecretariaDatos.verSecretaria(dni);
						request.setAttribute("secretarias", secretarias1);
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/actualizarSecretaria.jsp");
						rd.forward(request, response);
					}
					else{
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
						rd.forward(request, response);
					}
				}

			try {} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/busquedaDNI.jsp");
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