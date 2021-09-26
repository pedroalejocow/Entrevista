package com.empleado.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="departamento_codigo")
	private String departamentoCodigo;

	@Column(name="departamento_nombre")
	private String departamentoNombre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_hora_crea")
	private Date fechaHoraCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_hora_modifica")
	private Date fechaHoraModifica;

	//bi-directional one-to-one association to Empleado
	@OneToOne(mappedBy="departamento1")
	private Empleado empleado;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="departamento2")
	private List<Empleado> empleados;

	public Departamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartamentoCodigo() {
		return this.departamentoCodigo;
	}

	public void setDepartamentoCodigo(String departamentoCodigo) {
		this.departamentoCodigo = departamentoCodigo;
	}

	public String getDepartamentoNombre() {
		return this.departamentoNombre;
	}

	public void setDepartamentoNombre(String departamentoNombre) {
		this.departamentoNombre = departamentoNombre;
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

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setDepartamento2(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setDepartamento2(null);

		return empleado;
	}

}