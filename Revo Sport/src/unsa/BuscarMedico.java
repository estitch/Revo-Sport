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
public class BuscarMedico extends HttpServlet {

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("action").equals("buscarDNI")) {
			String dni = request.getParameter("dni");
			List<Medico> medico = BusquedaMedicoDatos.buscardniMedico(dni);
			request.setAttribute("medicos", medico);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/busquedaDNIMedico.jsp");
			rd.forward(request, response);

		} else 
			if (request.getParameter("action").equals("Busqueda por medico")) {

				String medico = request.getParameter("medico");
				request.setAttribute("medico", medico);
				List<Admi> historias = BusquedaTrainerDatos.buscardni(medico);
				request.setAttribute("historias", historias);
				request.setAttribute("medico", medico);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/busquedaMedico.jsp");
				rd.forward(request, response);

			} else if (request.getParameter("action").equals("Busqueda por especialidad")) {

				String especialidad = request.getParameter("especialidad");
				request.setAttribute("especialidad", especialidad);
				List<Admi> historias = BusquedaTrainerDatos.buscardni(especialidad);
				request.setAttribute("historias", historias);
				request.setAttribute("especialidad", especialidad);
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/busquedaEspecialidad.jsp");
				rd.forward(request, response);

			}else if (request.getParameter("action").equals("mapa")) {

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/siteMap.jsp");
				rd.forward(request, response);

			}try {

			} catch (Exception e) {
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