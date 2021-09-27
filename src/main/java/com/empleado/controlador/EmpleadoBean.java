package com.empleado.controlador;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.empleado.dao.DepartamentoDAO;
import com.empleado.dao.EmpleadoDAO;
import com.empleado.modelo.Departamento;
import com.empleado.modelo.Empleado;

@ManagedBean(name = "empleadoBean")
@ViewScoped
public class EmpleadoBean {
	private Empleado empleado;
	private Integer idDepartamento;
	private List<Empleado> listaEmpleados;
	private List<SelectItem> listaDepartamentos;
	private Departamento departamentoSelect;

	public Departamento getDepartamentoSelect() {
		return departamentoSelect;
	}

	public void setDepartamentoSelect(Departamento departamentoSelect) {
		this.departamentoSelect = departamentoSelect;
	}

	public EmpleadoBean() {
		empleado = new Empleado();
		departamentoSelect = new Departamento();
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
	
	public List<SelectItem> getListaDepartamentos() {
		this.listaDepartamentos = new ArrayList<SelectItem>();
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		List<Departamento>listaDepartamentoss = departamentoDAO.buscarDepartamento();
		listaDepartamentos.clear();
		for (Departamento departamentos: listaDepartamentoss) {
			SelectItem departamentoItem =  new SelectItem(departamentos.getId(), departamentos.getDepartamentoNombre());
			this.listaDepartamentos.add(departamentoItem);
		}
		return listaDepartamentos;
	}

	public void limpiarEmpleado() {
		empleado = new Empleado();
	}

	public void crearEmpleado() throws ParseException {
		Date fechaActual = new Date();
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		Departamento departamento = new Departamento();
		departamento = empleadoDAO.buscarDepartamentoEspecifico(departamentoSelect.getId());
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
