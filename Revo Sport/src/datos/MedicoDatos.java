package datos;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import beans.Medico;
import beans.Secretaria;

public class MedicoDatos {

	public static void insertar(String nombre, String apellidoP, String apellidoM,
			 String dni, String dia, String mes, String anio, String especialidad, String sexo,
			 String direccionp, String celular, String telefono, String email, String fechanac){
	
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	
	 final Medico medico = new Medico(nombre, apellidoP, apellidoM, dni, 
				dia, mes, anio, especialidad, sexo, direccionp, 
				celular, telefono, email, fechanac);

	 pm.makePersistent(medico);
	 pm.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Medico> verMedicos(){
	 final PersistenceManager pm = PMF.get().getPersistenceManager();
	 final Query query = pm.newQuery(Medico.class);
	 return (List<Medico>) query.execute();
	}

	public static List<Medico> verMedico(String dni) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String query = "select from " +Medico.class.getName();
		Query q = pm.newQuery(query);
		q.setFilter("dni == nombreParam");
		q.declareParameters("String nombreParam");
		
		List<Medico> medico = (List<Medico>)q.execute(dni);
		 return(medico);
	}
}
