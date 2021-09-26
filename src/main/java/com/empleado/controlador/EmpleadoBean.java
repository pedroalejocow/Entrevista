package com.empleado.controlador;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.empleado.dao.EmpleadoDAO;
import com.empleado.modelo.Departamento;
import com.empleado.modelo.Empleado;

@ManagedBean(name = "empleadoBean")
@ViewScoped
public class EmpleadoBean {
	private Empleado empleado;
	private Integer idDepartamento;
	private List<Empleado> listaEmpleados;

	public EmpleadoBean() {
		empleado = new Empleado();
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Integer getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public List<Empleado> getListaEmpleados() {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		listaEmpleados = empleadoDAO.buscarEmpleado();
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public void limpiarEmpleado() {
		empleado = new Empleado();
	}

	public void crearEmpleado() throws ParseException {
		Date fechaActual = new Date();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		Departamento departamento = new Departamento();
		System.out.println(empleado.toString());
		System.out.println("Departamento:" + idDepartamento);
		departamento = empleadoDAO.buscarDepartamentoEspecifico(idDepartamento);
		empleado.setFechaHoraCrea(new java.sql.Date(fechaActual.getTime()));
		empleado.setDepartamento2(departamento);
		empleadoDAO.guardarEmpleado(empleado);
	}

	public void modificarEmpleado() throws ParseException {
		Date fechaActual = new Date();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		Departamento departamento = new Departamento();
		empleado.setFechaHoraModifica(new java.sql.Date(fechaActual.getTime()));
		departamento = empleadoDAO.buscarDepartamentoEspecifico(empleado.getDepartamento2().getId());
		empleado.setDepartamento2(departamento);
		empleadoDAO.actualizarEmpleado(empleado);
		limpiarEmpleado();
	}

	public void eliminarEmpleado() {
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		empleadoDAO.eliminarEmpleado(empleado);
		limpiarEmpleado();
	}
}
