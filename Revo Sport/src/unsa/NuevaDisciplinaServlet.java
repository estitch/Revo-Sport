package unsa;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import beans.*;
import datos.*;

@SuppressWarnings("serial")
public class NuevaDisciplinaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {


		try {
			if (req.getParameter("action").equals("create")) {

				String nombre = req.getParameter("nombre");
				String dia = req.getParameter("dia");
				String hora = req.getParameter("hora");

				

				DisciplinaDatos.insertar(nombre, dia, hora);

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoDisciplina.jsp");
				rd.forward(req, resp);

			}
			else if (req.getParameter("action").equals("show")) {

				List<Disciplina> disciplinas = DisciplinaDatos.verDisciplina();
				req.setAttribute("disciplinas", disciplinas);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/verDisciplina.jsp");
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
					List<Disciplina> disciplinas = DisciplinaDatos.verDisciplina();
					req.setAttribute("disciplinas", disciplinas);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/borrarDisciplina.jsp");
					rd.forward(req, resp);
				}
				else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarDisciplina.jsp");
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
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/nuevaDisciplina.jsp");
					rd.forward(req, resp);
				}
				else{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
					rd.forward(req, resp);
				}
			}

		} catch (ServletException e) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorDisciplina.jsp");
			rd.forward(req, resp);		
		}
	}
}
