package datos;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import beans.*;

public class VisitanteDatos {

	
	public static void insertar(String dni){
	 
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	
	 final Visitante visitante = new Visitante(dni);
	
	 pm.makePersistent(visitante);	
	 pm.close();
	}
	
	public static List<Visitante> buscardniVisitante(String dni){
		 final PersistenceManager pm = PMF.get().getPersistenceManager();
		 String query = " select from " +Visitante.class.getName() +" where dni == '" +dni + "'";
		 List<Visitante> visitantes = (List<Visitante>)pm.newQuery(query).execute();
		 return(visitantes);
		}
	
	@SuppressWarnings("unchecked")
	public static List<Visitante> verVisitante(){
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	 final Query query = pm.newQuery(Visitante.class);
	 return (List<Visitante>) query.execute();
	 
	}
}
