package datos;

import java.util.List;

import javax.jdo.PersistenceManager;

import beans.*;


public class BusquedaDisciplinaDatos {
	
	public static List<Disciplina> buscardniDisciplina(String nombre){
		 final PersistenceManager pm = PMF.get().getPersistenceManager();
		 String query = " select from " +Disciplina.class.getName() +" where nombre == '" +nombre + "'";
		 List<Disciplina> disciplinas = (List<Disciplina>)pm.newQuery(query).execute();
		 
		 return(disciplinas);
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
