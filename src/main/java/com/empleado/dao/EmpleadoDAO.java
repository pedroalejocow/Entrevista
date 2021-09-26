package com.empleado.dao;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.empleado.modelo.Departamento;
import com.empleado.modelo.Empleado;
import com.empleado.modelo.JpaConexion;

public class EmpleadoDAO {
	EntityManager entity = JpaConexion.getEntityManagerFactory().createEntityManager();

	/**
	 * Se metodo se encarga de guarda un empleado
	 * 
	 * @param empleado
	 * @throws ParseException
	 */
	public void guardarEmpleado(Empleado empleado) throws ParseException {
		entity.getTransaction().begin();
		entity.persist(empleado);
		entity.getTransaction().commit();
		// JpaConexion.desconectarConexion();
	}

	/**
	 * Este metodo se encarga de actualizar el Departamento
	 * 
	 * @param departamento
	 */
	public void actualizarEmpleado(Empleado empleado) {
		entity.getTransaction().begin();
		entity.merge(empleado);
		entity.getTransaction().commit();
		// JpaConexion.desconectarConexion();
	}

	/**
	 * Este metodo se encarga de eliminar el Departamento
	 * 
	 * @param departamento
	 */
	public void eliminarEmpleado(Empleado empleado) {
		entity.getTransaction().begin();
		entity.remove(entity.contains(empleado) ? entity : entity.merge(empleado));
		entity.getTransaction().commit();
		// JpaConexion.desconectarConexion();
	}

	/**
	 * Este metodo se encarga de buscar los Empleados
	 * 
	 * @return Retorna todos los Empleados
	 */
	@SuppressWarnings("unchecked")
	public List<Empleado> buscarEmpleado() {
		/*
		 * StringBuilder stringConsulta = new StringBuilder("SELECT id,\n" +
		 * "    departamento_codigo,\n" + " departamento_nombre,\n" +
		 * "    fecha_hora_crea,\n" + "    fecha_hora_modifica\n" +
		 * "FROM `empleado`.`Departamento`");
		 */
		Query query = entity.createQuery("SELECT c FROM Empleado c");
		// Query query = entity.createNativeQuery(stringConsulta.toString());
		List<Empleado> departamento = query.getResultList();
		// JpaConexion.desconectarConexion();
		return departamento;

	}

	/**
	 * Se metodo se encarga de buscar un departamento
	 * 
	 * @param empleado
	 * @throws ParseException
	 */
	public Departamento buscarDepartamentoEspecifico(Integer id) throws ParseException {
		Departamento departamento = new Departamento();
		departamento = entity.find(Departamento.class, id);
		return departamento;
	}
}
