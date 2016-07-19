package datos;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import beans.Disciplina;


public class DisciplinaDatos {

	public static void insertar(String nombre, String dia, String hora){
	
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	
	 final Disciplina disciplina = new Disciplina(nombre, dia, hora);

	 pm.makePersistent(disciplina);
	 pm.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Disciplina> verDisciplina(){
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	 final Query query = pm.newQuery(Disciplina.class);
	 return (List<Disciplina>) query.execute();
	}
}
