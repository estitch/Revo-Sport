package unsa;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import beans.Admi;
import beans.Cliente;
import beans.Disciplina;
import beans.Medico;
import beans.Secretaria;
import datos.*;

@SuppressWarnings("serial")
public class NuevoMedicoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


		if (req.getParameter("action").equals("create")) {

		String nombre = req.getParameter("nombre");
		String apellidoP = req.getParameter("apellidoP");
		String apellidoM = req.getParameter("apellidoM");
		String dni = req.getParameter("documento");
		String dia = req.getParameter("dia");
		String mes = req.getParameter("mes");
		String anio = req.getParameter("anio");
		String especialidad = req.getParameter("especialidad");
		String sexo = req.getParameter("sexo");
		String direccion = req.getParameter("direccion");
		String distrito = req.getParameter("distrito");
		String provincia = req.getParameter("provincia");
		String departamento = req.getParameter("departamento");
		String celular = req.getParameter("celular");
		String telefono = req.getParameter("telefono");
		String email = req.getParameter("email");
		String fechanac = dia + "/" + mes + "/" + anio;

		String direccionp = direccion + " / "
				+ distrito + " / " + provincia + " / "
				+ departamento;
		
		boolean ver = true;
		List<Medico> medicos = MedicoDatos.verMedicos();
		for(int i=0;i<medicos.size();i++){
			if(medicos.get(i).getDni().equalsIgnoreCase(dni))
				ver=false;
		}
		if(ver==true){
			MedicoDatos.insertar(nombre, apellidoP, apellidoM,
					dni, dia, mes, anio, especialidad, sexo, direccionp,
					celular, telefono, email, fechanac);			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoMedico.jsp");
			rd.forward(req, resp);
		}
		else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
			rd.forward(req, resp);
		}
		
		}
		else if (req.getParameter("action").equals("show")) {
			List<Medico> medicos = MedicoDatos.verMedicos();
			req.setAttribute("medicos", medicos);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/verMedico.jsp");
			rd.forward(req, resp);
			
		}else if(req.getParameter("action").equals("borrar")){
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
				List<Medico> medicos = MedicoDatos.verMedicos();
				req.setAttribute("medicos", medicos);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/borrarMedico.jsp");
				rd.forward(req, resp);
			}
			else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarMedico.jsp");
				rd.forward(req, resp);
			}
		
		}else if (req.getParameter("action").equals("red")) {
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
				List<Disciplina> disciplinas = DisciplinaDatos.verDisciplina();

				req.setAttribute("disciplinas", disciplinas);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevoMedico.jsp");
				rd.forward(req, resp);
			}
			else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
				rd.forward(req, resp);
			}
		}
			
		try {} catch (Exception e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorMedico.jsp");
			rd.forward(req, resp);
		}

	}
}
