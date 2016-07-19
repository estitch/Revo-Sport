package beans;

import java.util.*;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable (identityType=IdentityType.APPLICATION)
public class Disciplina{
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.SEQUENCE)
	private Long id;
	@Persistent 
	private String nombre;
	@Persistent 
	private String dia;
	@Persistent
	private String hora;
	@Persistent
	private Date fecha;


	public Disciplina(String nombre, String dia, String hora){
		super();
		this.nombre = nombre;
		this.dia =dia;
		this.hora = hora;	

		TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
		this.fecha = new Date();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDia() {
		return dia;
	}


	public void setDia(String dia) {
		this.dia = dia;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


}
