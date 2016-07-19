package beans;

import java.util.*;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable (identityType=IdentityType.APPLICATION)
public class Medico {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.SEQUENCE)
	private Long id;
	@Persistent
	private String nombre;
	@Persistent 
	private String apellidoP;
	@Persistent 
	private String apellidoM;
	@Persistent 
	private String dni;
	@Persistent 
	private String dia;
	@Persistent 
	private String mes;
	@Persistent 
	private String anio;
	@Persistent 
	private String especialidad;
	@Persistent 
	private String sexo;
	@Persistent 
	private String direccionp;
	@Persistent 
	private String celular;
	@Persistent 
	private String telefono;
	@Persistent 
	private String email;
	@Persistent 
	private String fechanac;
	@Persistent
	private Date fecha;


	public Medico( String nombre, String apellidoP, String apellidoM,
			String dni, String dia, String mes, String anio,
			String especialidad, String sexo, String direccionp,
			String celular, String telefono, String email, String fechanac) {
		super();
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.dni = dni;
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
		this.especialidad = especialidad;
		this.sexo = sexo;
		this.direccionp = direccionp;
		this.celular = celular;
		this.telefono = telefono;
		this.email = email;
		this.fechanac = fechanac;
		TimeZone.setDefault(TimeZone.getTimeZone("America/Lima"));
		this.fecha = new Date();	
		}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoP() {
		return apellidoP;
	}
	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}
	public String getApellidoM() {
		return apellidoM;
	}
	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDireccionp() {
		return direccionp;
	}
	public void setDireccionp(String direccionp) {
		this.direccionp = direccionp;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFechanac() {
		return fechanac;
	}
	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
