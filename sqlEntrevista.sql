
CREATE DATABASE empleado;

--DROP TABLE `empleado`.`Departamento`;
create table `empleado`.`Departamento`(
   id INT NOT NULL AUTO_INCREMENT,
   departamento_codigo VARCHAR(100) NOT NULL,
   departamento_nombre VARCHAR(40) NOT NULL,
   fecha_hora_crea DATETIME,
   fecha_hora_modifica DATETIME,
   PRIMARY KEY (id)
);

--DROP TABLE `empleado`.`Empleado`;
create table `empleado`.`Empleado`(
   id INT NOT NULL AUTO_INCREMENT,
   departamentos_id INT NOT NULL,
   documento_tipo VARCHAR(40) NOT NULL,
   documento_numero VARCHAR(40) NOT NULL,
   nombres VARCHAR(40) NOT NULL,
   apellidos VARCHAR(40) NOT NULL,
   ciudad VARCHAR(40) NOT NULL,
   direccion VARCHAR(40) NOT NULL,
   correo_electronico VARCHAR(40) NOT NULL,
   Telefono VARCHAR(40) NOT NULL,
   fecha_hora_crea DATETIME,
   fecha_hora_modifica DATETIME,
   PRIMARY KEY (id),
   FOREIGN KEY (departamentos_id) REFERENCES `empleado`.`Departamento`(id)
);
