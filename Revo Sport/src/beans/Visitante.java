package beans;

import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.*;

@PersistenceCapable (identityType=IdentityType.APPLICATION)
public class Visitante {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.SEQUENCE)
	private Long id;	 
	@Persistent
	private String dni;
	@Persistent
	private Date fecha;
	public Visitante(String dni) {
		super();
		this.dni = dni;
		TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
		this.fecha = new Date();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFecha() {
		return fecha;
	}



}
