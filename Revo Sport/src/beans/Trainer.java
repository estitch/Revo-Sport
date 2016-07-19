package beans;

import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.*;
@PersistenceCapable (identityType=IdentityType.APPLICATION)
public class Trainer {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.SEQUENCE)
	private Long id;
	@Persistent 
	private String nombre;
	@Persistent 
	private String apellidop;
	@Persistent 
	private String apellidom;	 
	@Persistent
	private String dni;
	@Persistent
	private String direccion;
	@Persistent
	private String lugar;
	@Persistent
	private String telefono;
	@Persistent
	private String email;
	@Persistent
	private Date fecha;

	public Trainer(String nombre, String apellidop, String apellidom,  String dni, String direccion,
			 String telefono, String email){

		this.nombre = nombre;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;


		TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
		this.fecha = new Date();
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}

	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidop() {
		return apellidop;
	}
	public String getApellidom() {
		return apellidom;
	}

	public String getdni() {
		return dni;
	}

	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getEmail() {
		return email;
	}
	public Date getFecha() {
		return fecha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}