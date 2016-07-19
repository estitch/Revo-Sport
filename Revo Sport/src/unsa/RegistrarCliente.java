package unsa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.servlet.RequestDispatcher;

import beans.Admi;
import beans.Cliente;
import beans.Secretaria;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import datos.AdmiDatos;
import datos.ClienteDatos;
import datos.SecretariaDatos;

@SuppressWarnings("serial")
public class RegistrarCliente extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			if (request.getParameter("action").equals("create")) {
				
				String nombre = request.getParameter("nombre");
				String apellidop = request.getParameter("apellidoP");
				String apellidom = request.getParameter("apellidoM");
				String dia = request.getParameter("dia");
				String mes = request.getParameter("mes");
				String anio = request.getParameter("anio");
				String fechanac = dia + "/" + mes + "/" + anio;
				String documento = request.getParameter("documento");
				String sexo = request.getParameter("sexo");
				String direccion = request.getParameter("direccion");
				String distrito = request.getParameter("distrito");
				String provincia = request.getParameter("provincia");
				String departamento = request.getParameter("departamento");
				String direccionp = direccion + " / "
						+ distrito + " / " + provincia + " / "
						+ departamento;
				String celular = request.getParameter("celular");
				String telefono = request.getParameter("telefono");
				String email = request.getParameter("email");
				
				boolean ver = true;
				List<Cliente> clientes = ClienteDatos.verClientes();
				for(int i=0;i<clientes.size();i++){
					if(clientes.get(i).getDocumento().equalsIgnoreCase(documento))
						ver=false;
				}
				if(ver==true){
					ClienteDatos.insertar(nombre, apellidop, apellidom,
						fechanac, documento, sexo, direccionp, celular, telefono, email);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoCliente.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
					rd.forward(request, response);
				}				

			} else if (request.getParameter("action").equals("show")) {
				
				List<Cliente> clientes = ClienteDatos.verClientes();
				request.setAttribute("clientes", clientes);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/verClientes.jsp");
				rd.forward(request, response);
				
			}
			else if(request.getParameter("action").equals("borrar")){
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
						List<Cliente> clientes = ClienteDatos.verClientes();
						request.setAttribute("clientes", clientes);
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/borrarCliente.jsp");
						rd.forward(request, response);
					}
					else{
						RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
						rd.forward(request, response);
					}
				
			}
			else if (request.getParameter("action").equals("red")) {
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
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoCliente.jsp");
					rd.forward(request, response);
				}
				else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
					rd.forward(request, response);
				}
			}
			}
			catch (Exception e) {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorCliente.jsp");
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
