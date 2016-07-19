package datos;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import beans.Medico;
import beans.Trainer;

public class TrainerDatos {

	
	public static void insertar( String nombre, String apellidop, String apellidom,  String dni, String direccion,
			  String telefono, String email){
	 
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	
	 final Trainer admi = new Trainer(nombre, apellidop, apellidom,dni, direccion, telefono, email);
	
	 pm.makePersistent(admi);	
	 pm.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Trainer> verTrainer(){
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	 final Query query = pm.newQuery(Trainer.class);
	 return (List<Trainer>) query.execute();
	 
	}

	public static List<Trainer> verTrainer(String dni) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String query = "select from " +Trainer.class.getName();
		Query q = pm.newQuery(query);
		q.setFilter("dni == nombreParam");
		q.declareParameters("String nombreParam");
		
		List<Trainer> trainer = (List<Trainer>)q.execute(dni);
		 return(trainer);
	}
}
