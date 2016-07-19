package unsa;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import javax.jdo.Query;
import javax.servlet.RequestDispatcher;

import beans.Admi;
import datos.PMF;



@SuppressWarnings("serial")
public class BorrarAdmi extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	try {
			if (request.getParameter("action").equals("borrar")) {
				
				String dni = request.getParameter("dni");
				PersistenceManager pm = PMF.get().getPersistenceManager();
				
				final Query q = pm.newQuery(Admi.class);
				q.setFilter("dni == dniParam");
				q.declareParameters("String dniParam");
				
				try{
					List<Admi> admis = (List<Admi>) q.execute(dni);

					for(Admi p: admis){
						
						pm.deletePersistent(p);
					}
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoBorrarAdmi.jsp");
					rd.forward(request, response);

				}catch(Exception e){
					
				}finally{
					 q.closeAll();
				}
			
			}	
	
	} catch (Exception e) {
		RequestDispatcher rd = getServletContext()
				.getRequestDispatcher("/WEB-INF/Error.jsp");
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

