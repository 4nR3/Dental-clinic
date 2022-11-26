package com.example.clinicaOdontologica.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SQL {

    private static final Logger logger = LogManager.getLogger();

    public void BuscarTablas(){

        try{
            Class.forName("org.h2.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement sentencia = con.createStatement();

            try {
                String SAO = "select * from ODONTOLOGOS LIMIT 1";
                ResultSet rs = sentencia.executeQuery(SAO);

                logger.info("\n La tabla ODONTOLOGOS fue encontrada\n");

                rs.close();
            }
            catch (SQLException throwables)
            {
                logger.error("La tabla ODONTOLOGOS no existe o no pudo ser encontrada \n"+ throwables);
                CrearOdontologos();
            }

            try {
                String SAO = "select * from PACIENTES LIMIT 1";
                ResultSet rs = sentencia.executeQuery(SAO);

                logger.info("\n La tabla PACIENTES fue encontrada\n");

                rs.close();
            }
            catch (SQLException throwables)
            {
                logger.error("La tabla PACIENTES no existe o no pudo ser encontrada \n"+ throwables);
                CrearPacientes();
            }

            try {
                String SAO = "select * from DOMICILIOS LIMIT 1";
                ResultSet rs = sentencia.executeQuery(SAO);

                logger.info("\n La tabla DOMICILIOS fue encontrada\n");

                rs.close();
            }
            catch (SQLException throwables)
            {
                logger.error("La tabla DOMICILIOS no existe o no pudo ser encontrada \n"+ throwables);
                CrearDomicilios();
            }

            sentencia.close();
            con.close();

        } catch (SQLException throwables) {
            logger.error(throwables);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        } catch (InstantiationException e) {
            logger.error(e);
        } catch (IllegalAccessException e) {
            logger.error(e);
        }

    }

    public void CrearOdontologos(){

        try{
            Class.forName("org.h2.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement sentencia = con.createStatement();

            logger.info("Se intentara crear una tabla de ODONTOLOGOS\n");

            String CT = "CREATE TABLE ODONTOLOGOS(ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(30), APELLIDO VARCHAR (30));";

            sentencia.execute(CT);

            sentencia.close();
            con.close();
            logger.info("Se creo la tabla ODONTOLOGOS con exito\n");

        } catch (SQLException throwables) {
            logger.error("La tabla no se pudo crear\n"+throwables);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        } catch (InstantiationException e) {
            logger.error(e);
        } catch (IllegalAccessException e) {
            logger.error(e);
        }
    }

    public void CrearDomicilios(){

        try{
            Class.forName("org.h2.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement sentencia = con.createStatement();

            logger.info("Se intentara crear una tabla de DOMICILIOS\n");

            String CT = "CREATE TABLE DOMICILIOS(ID INT AUTO_INCREMENT PRIMARY KEY, CALLE VARCHAR(30), NUMERO INT, LOCALIDAD VARCHAR(30), PROVINCIA VARCHAR(30));";

            sentencia.execute(CT);

            sentencia.close();
            con.close();
            logger.info("Se creo la tabla DOMICILIOS con exito\n");

        } catch (SQLException throwables) {
            logger.error("La tabla no se pudo crear\n"+throwables);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        } catch (InstantiationException e) {
            logger.error(e);
        } catch (IllegalAccessException e) {
            logger.error(e);
        }
    }

    public void CrearPacientes(){

        try{
            Class.forName("org.h2.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement sentencia = con.createStatement();

            logger.info("Se intentara crear una tabla de PACIENTES\n");

            String CT = "CREATE TABLE PACIENTES(ID INT AUTO_INCREMENT PRIMARY KEY, APELLIDO VARCHAR(30), NOMBRE VARCHAR (30),DNI INT,FECHADEINGRESO DATE, IDDOMICILIO INT);";

            sentencia.execute(CT);

            sentencia.close();
            con.close();
            logger.info("Se creo la tabla PACIENTES con exito\n");

        } catch (SQLException throwables) {
            logger.error("La tabla no se pudo crear\n"+throwables);
        } catch (ClassNotFoundException e) {
            logger.error(e);
        } catch (InstantiationException e) {
            logger.error(e);
        } catch (IllegalAccessException e) {
            logger.error(e);
        }
    }


    //-------------- LINEAS PARA BORRAR LA TABLA --------------

    public void borrarTablas(){
        System.out.println("Borrando todo");

        try{
            Class.forName("org.h2.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement sentencia = con.createStatement();

            String DT = "DROP TABLE PACIENTES; DROP TABLE DOMICILIOS;DROP TABLE ODONTOLOGOS";

            sentencia.execute(DT);

            sentencia.close();
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
