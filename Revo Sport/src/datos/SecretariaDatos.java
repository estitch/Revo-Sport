package datos;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import beans.Admi;
import beans.Secretaria;

 


public class SecretariaDatos {

	
	public static void insertar(String nombre, String apellidop, String apellidom, String fechanac, String documento,
			  String estado, String sexo, String direccionp,
			 String celular, String telefono, String email){
	 
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	
	 final Secretaria secretaria = new Secretaria(nombre, apellidop, apellidom, fechanac,
				documento, estado, sexo, direccionp, celular, telefono, email);
	
	 pm.makePersistent(secretaria);
	 pm.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Secretaria> verSecretarias(){
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	 final Query query = pm.newQuery(Secretaria.class);
	 return (List<Secretaria>) query.execute();
	 
	}

	public static List<Secretaria> verSecretaria(String dni) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String query = "select from " +Secretaria.class.getName();
		Query q = pm.newQuery(query);
		q.setFilter("documento == nombreParam");
		q.declareParameters("String nombreParam");
		
		List<Secretaria> secretaria = (List<Secretaria>)q.execute(dni);
		 return(secretaria);
	}
}
