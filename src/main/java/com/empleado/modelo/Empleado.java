package com.empleado.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String apellidos;

	private String ciudad;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String direccion;

	@Column(name="documento_numero")
	private String documentoNumero;

	@Column(name="documento_tipo")
	private String documentoTipo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_hora_crea")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_hora_modifica")
	private Date fechaHoraModifica;

	private String nombres;

	@Column(name="Telefono")
	private String telefono;

	//bi-directional one-to-one association to Departamento
	@OneToOne
	@JoinColumn(name="id")
	private Departamento departamento1;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="departamentos_id")
	private Departamento departamento2;

	public Empleado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDocumentoNumero() {
		return this.documentoNumero;
	}

	public void setDocumentoNumero(String documentoNumero) {
		this.documentoNumero = documentoNumero;
	}

	public String getDocumentoTipo() {
		return this.documentoTipo;
	}

	public void setDocumentoTipo(String documentoTipo) {
		this.documentoTipo = documentoTipo;
	}

	public Date getFechaHoraCrea() {
		return this.fechaHoraCrea;
	}

	public void setFechaHoraCrea(Date fechaHoraCrea) {
		this.fechaHoraCrea = fechaHoraCrea;
	}

	public Date getFechaHoraModifica() {
		return this.fechaHoraModifica;
	}

	public void setFechaHoraModifica(Date fechaHoraModifica) {
		this.fechaHoraModifica = fechaHoraModifica;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Departamento getDepartamento1() {
		return this.departamento1;
	}

	public void setDepartamento1(Departamento departamento1) {
		this.departamento1 = departamento1;
	}

	public Departamento getDepartamento2() {
		return this.departamento2;
	}

	public void setDepartamento2(Departamento departamento2) {
		this.departamento2 = departamento2;
	}

}