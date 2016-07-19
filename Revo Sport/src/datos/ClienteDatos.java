package datos;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import beans.Cliente;
import beans.Trainer;


public class ClienteDatos {

	public static void insertar(String nombre, String apellidop, String apellidom,
			String fechanac, String documento, String sexo, 
			String direccionp, String celular, String telefono, String email){
	
	 final PersistenceManager pm = PMF.get().getPersistenceManager();

	 final Cliente cliente = new Cliente(nombre, apellidop, apellidom, fechanac, documento,
			  sexo, direccionp, celular, telefono, email);
	
	 pm.makePersistent(cliente);
	 pm.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Cliente> verClientes(){
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	 final Query query = pm.newQuery(Cliente.class);
	 return (List<Cliente>) query.execute();
	}

	public static List<Cliente> verCliente(String dni) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String query = "select from " +Cliente.class.getName();
		Query q = pm.newQuery(query);
		q.setFilter("documento == nombreParam");
		q.declareParameters("String nombreParam");
		
		List<Cliente> clientes = (List<Cliente>)q.execute(dni);
		 return(clientes);
	}
}
