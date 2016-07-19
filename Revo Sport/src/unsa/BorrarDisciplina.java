package unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.servlet.RequestDispatcher;
import beans.Disciplina;
import datos.PMF;


@SuppressWarnings("serial")
public class BorrarDisciplina extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	try {
			
				
				String nombre = request.getParameter("nombre");
				PersistenceManager pm = PMF.get().getPersistenceManager();
				 
				String query = "select from " + Disciplina.class.getName()
						+ " where nombre == '"+nombre+"'";
				List<Disciplina> disciplinas = (List<Disciplina>) pm.newQuery(query).execute();
				
					for(Disciplina p: disciplinas){
						
						pm.deletePersistent(p);
					}
					pm.close();
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoBorrarDisciplina.jsp");
					rd.forward(request, response);

				}catch(Exception e){
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/errorBorrarCliente.jsp");
					rd.forward(request, response);
				}
			
			
	
	//} catch (Exception e) {
		//RequestDispatcher rd = getServletContext()
	//			.getRequestDispatcher("/WEB-INF/Error.jsp");
//		rd.forward(request, response);
	//	}
	
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

