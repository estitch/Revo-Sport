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

import beans.Cliente;
import beans.Secretaria;
import datos.PMF;


@SuppressWarnings("serial")
public class BorrarCliente extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	try {
			
				
				String dni = request.getParameter("dni");
				PersistenceManager pm = PMF.get().getPersistenceManager();
				 
				String query = "select from " + Cliente.class.getName()
						+ " where documento == '"+dni+"'";
				List<Cliente> clientes = (List<Cliente>) pm.newQuery(query).execute();
				
			

					for(Cliente p: clientes){
						
						pm.deletePersistent(p);
					}
					pm.close();
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/exitoBorrarCliente.jsp");
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

