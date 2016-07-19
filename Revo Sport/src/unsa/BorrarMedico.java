package unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.servlet.RequestDispatcher;

import beans.Cliente;
import beans.Medico;
import datos.PMF;


@SuppressWarnings("serial")
public class BorrarMedico extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	try {
			
				
				String dni = request.getParameter("dni");
				PersistenceManager pm = PMF.get().getPersistenceManager();
				 
				String query = "select from " + Medico.class.getName()
						+ " where dni == '"+dni+"'";
				List<Medico> medicos = (List<Medico>) pm.newQuery(query).execute();
				
			

					for(Medico p: medicos){
						
						pm.deletePersistent(p);
					}
					pm.close();
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoBorrarMedico.jsp");
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

