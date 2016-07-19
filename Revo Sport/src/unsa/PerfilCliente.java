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

@SuppressWarnings("serial")
public class PerfilCliente extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
			String buscar = request.getParameter("action");
			List<Cliente> clientes = BusquedaClienteDatos.buscardniCliente(buscar);
			request.setAttribute("cliente", clientes);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/perfilCliente.jsp");
			rd.forward(request, response);

		
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