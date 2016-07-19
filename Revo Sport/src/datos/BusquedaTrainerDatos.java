package datos;

import java.util.List;

import javax.jdo.PersistenceManager;

import beans.Admi;
import beans.Trainer;


public class BusquedaTrainerDatos {
	
	public static List<Admi> buscardni(String dni){
		 final PersistenceManager pm = PMF.get().getPersistenceManager();
		 String query = " select from " +
		 Admi.class.getName() +
		 " where dni == '" +
		 dni + "'";
		 List<Admi> admi = (List<Admi>)pm.newQuery(query).execute();
		 return(admi);
		}
	public static List<Trainer> buscardniTrainer(String dni){
		 final PersistenceManager pm = PMF.get().getPersistenceManager();
		 String query = " select from " +Trainer.class.getName() +" where dni == '" +dni + "'";
		 List<Trainer> trainer = (List<Trainer>)pm.newQuery(query).execute();
		 return(trainer);
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
