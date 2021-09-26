package com.empleado.controlador;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.empleado.dao.DepartamentoDAO;
import com.empleado.modelo.Departamento;

@ManagedBean(name="departamentoBean")
@ViewScoped
public class DepartamentoBean {
	private Departamento departamento;
	private List<Departamento> listaDepartamentos;
	
	public DepartamentoBean() {
		 departamento = new Departamento();
	}
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public void limpiarDepartamento() {
		departamento = new Departamento();
    }
	
	public List<Departamento> getListaDepartamentos() {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		listaDepartamentos = departamentoDAO.buscarDepartamento();
		return listaDepartamentos;
	}
	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}
	
	public void crearDepartamento() throws ParseException {
		Date fechaActual= new Date();
		departamento.setFechaHoraCrea(new java.sql.Date(fechaActual.getTime()));
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		departamentoDAO.guardarDepartamento(departamento);
    }

    public void modificarDepartamento() {
    	Date fechaActual= new Date();
		departamento.setFechaHoraModifica(new java.sql.Date(fechaActual.getTime()));
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    	departamentoDAO.actualizarDepartamento(departamento);
        limpiarDepartamento();
    }

    public void eliminarDepartamento() {
    	DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    	departamentoDAO.eliminarDepartamento(departamento);
        limpiarDepartamento();
    }
}
