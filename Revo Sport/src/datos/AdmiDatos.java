package datos;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import beans.Admi;
import beans.Trainer;
import beans.Visitante;


public class AdmiDatos {

	
	public static void insertar(String nombre, String apellidop, String apellidom,  String dni, String direccion,
			  String telefono, String email){
	 
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	
	 final Admi admi = new Admi(nombre, apellidop, apellidom,dni, direccion, telefono, email);
	
	 pm.makePersistent(admi);	
	 pm.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Admi> verAdmis(){
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	 final Query query = pm.newQuery(Admi.class);
	 return (List<Admi>) query.execute();
	 
	}

	public static List<Admi> verAdmi(String dni) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String query = "select from " +Admi.class.getName();
		Query q = pm.newQuery(query);
		q.setFilter("dni == nombreParam");
		q.declareParameters("String nombreParam");
		
		List<Admi> admi = (List<Admi>)q.execute(dni);
		 return(admi);
	}
}
