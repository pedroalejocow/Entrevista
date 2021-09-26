package com.empleado.dao;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.empleado.modelo.Departamento;
import com.empleado.modelo.JpaConexion;
/**
 * La clase DAO del departamento 
 * @author alejo
 *
 */
public class DepartamentoDAO {
	EntityManager entity = JpaConexion.getEntityManagerFactory().createEntityManager();
	
	/**
	 * Se metodo se encarga de guarda un departamento
	 * @param departamento
	 * @throws ParseException 
	 */
	public void guardarDepartamento(Departamento departamento) throws ParseException {
		entity.getTransaction().begin();
		entity.persist(departamento);
		entity.getTransaction().commit();
		//JpaConexion.desconectarConexion();
	}
	
	/**
	 * Este metodo se encarga de actualizar el Departamento
	 * @param departamento
	 */
	public void actualizarDepartamento(Departamento departamento) {
		entity.getTransaction().begin();
		entity.merge(departamento);
		entity.getTransaction().commit();
		//JpaConexion.desconectarConexion();
	}
	
	/**
	 * Este metodo se encarga de buscar los Departamentos
	 * @return Retorna todos los departamentos
	 */
	@SuppressWarnings("unchecked")
	public List<Departamento> buscarDepartamento() {
		/*StringBuilder stringConsulta = new StringBuilder("SELECT id,\n"
				+ "    departamento_codigo,\n"
				+ " departamento_nombre,\n"
				+ "    fecha_hora_crea,\n"
				+ "    fecha_hora_modifica\n"
				+ "FROM `empleado`.`Departamento`");*/
		Query query = entity.createQuery("SELECT c FROM Departamento c");
		//Query query = entity.createNativeQuery(stringConsulta.toString());
		List<Departamento> departamento =  query.getResultList();
		//JpaConexion.desconectarConexion();
		return departamento;
		
	}
	
	/**
	 * Este metodo se encarga de eliminar el Departamento
	 * @param departamento
	 */
	public void eliminarDepartamento(Departamento departamento) {
		entity.getTransaction().begin();
		entity.remove(entity.contains(departamento) ? entity : entity.merge(departamento));
		entity.getTransaction().commit();
		//JpaConexion.desconectarConexion();
	}
	
}
