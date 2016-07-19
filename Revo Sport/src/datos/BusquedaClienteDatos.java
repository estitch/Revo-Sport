package datos;

import java.util.List;

import javax.jdo.PersistenceManager;

import beans.*;


public class BusquedaClienteDatos {
	
	public static List<Admi> buscardni(String dni){
		 final PersistenceManager pm = PMF.get().getPersistenceManager();
		 String query = " select from " +
		 Admi.class.getName() +
		 " where dni == '" +
		 dni + "'";
		 List<Admi> admi = (List<Admi>)pm.newQuery(query).execute();
		 return(admi);
		}
	public static List<Cliente> buscardniCliente(String documento){
		 final PersistenceManager pm = PMF.get().getPersistenceManager();
		 String query = " select from " +Cliente.class.getName() +" where documento == '" +documento + "'";
		 List<Cliente> clientes = (List<Cliente>)pm.newQuery(query).execute();
		 return(clientes);
		}
	
//	public static List<Historia> buscarespecialidad(String especialidad){
//		 final PersistenceManager pm = PMF.get().getPersistenceManager();
//		 String query = " select from " +
//		Historia.class.getName() +
//		 " where especialidad == '" +
//		 especialidad + "'";
//		 List<Historia> historias = (List<Historia>)pm.newQuery(query).execute();
//		 return(historias);
//		}
//	public static List<Historia> buscarmedico(String medico){
//		 final PersistenceManager pm = PMF.get().getPersistenceManager();
//		 String query = " select from " +
//		 Historia.class.getName() +
//		 " where medico == '" +
//		 medico + "'";
//		 List<Historia> historias = (List<Historia>)pm.newQuery(query).execute();
//		 return(historias);
//		}
}
