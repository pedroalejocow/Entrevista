package com.empleado.modelo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta clase es la encargada de la conexion de la base de datos
 * @author alejo
 *
 */
public class JpaConexion {
	private static final String PERSISTENCE_UNIT_NAME = "Entrevista";
	private static EntityManagerFactory factory;
	
	/**
	 * Este metodo se encarga de la conexion a la base de dats
	 * @return Retorna la conexion a la base de datos
	 */
	public static EntityManagerFactory getEntityManagerFactory() {
		if (factory == null)
			factory= Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		return factory;
	}
	
	/**
	 * Este metodo se encarga de desconectar la base de datos
	 */
	public static void desconectarConexion() {
		if (factory != null)
			factory.close();
	}
}
