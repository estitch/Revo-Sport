package beans;

import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.*;

@PersistenceCapable (identityType=IdentityType.APPLICATION)
public class Secretaria {
	
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
	 private String fechanac;
	 @Persistent
	 private String documento;
	 @Persistent
	 private String estado;
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
	 private Date fecha;
	public Secretaria( String nombre, String apellidop,
			String apellidom, String fechanac, String documento, String estado,
			String sexo, String direccionp, String celular, String telefono,
			String email) {
		super();
		this.nombre = nombre;
		this.apellidop = apellidop;
		this.apellidom = apellidom;
		this.fechanac = fechanac;
		this.documento = documento;
		this.estado = estado;
		this.sexo = sexo;
		this.direccionp = direccionp;
		this.celular = celular;
		this.telefono = telefono;
		this.email = email;
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
	public String getApellidop() {
		return apellidop;
	}
	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}
	public String getApellidom() {
		return apellidom;
	}
	public void setApellidom(String apellidom) {
		this.apellidom = apellidom;
	}
	public String getFechanac() {
		return fechanac;
	}
	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	 
}
