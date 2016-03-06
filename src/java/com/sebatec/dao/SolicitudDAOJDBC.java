/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;


import com.sebatec.modelo.Solicitud;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Mi Laptop
 */
public class SolicitudDAOJDBC implements SolicitudDAO{
 private final Connection con;
	//crear la conecion
	    public SolicitudDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }
	    ///coneccion
    public boolean crear(Solicitud objsoli) throws DAOException {
        try (Statement stmt = con.createStatement()) 
	        {
	            String query = "INSERT INTO solicitud (idPersona,descripcion,observacion,estado) VALUES ("
	                   
	                    +objsoli.getIdPersona()+ ",'"
	                    + objsoli.getDescripcion()+ "','"
	                    +objsoli.getObservacion()+"',"
	                    +objsoli.isEstado()+")";
	            
	            
	            System.out.println(query);
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error añadiendo solicitud");
	               
	            }  
	            
	            
	        } catch (SQLException se) {            
	            //se.printStackTrace();
	            throw new DAOException("Error añadiendo solicitud en DAO", se);
	            
	        }   
	        return true;
    }

    @Override
    public boolean modificar(Solicitud objsoli) throws DAOException {
        try (Statement stmt = con.createStatement()) {
	            String query = "UPDATE solicitud "
	                    + "SET idPersona="+objsoli.getIdPersona()+ ","
                        + "descripcion='"+ objsoli.getDescripcion()+ "',"
                        + "observacion='"+objsoli.getObservacion()+"',"
                        + "estado="+objsoli.isEstado()+" "
	                + "WHERE idSolicitud=" + objsoli.getIdSolicitud();
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error actualizando datos de la solicitud");
	            }
	        } catch (SQLException se) {
	            throw new DAOException("Error actualizando datos del tributo en DAO", se);
	        }    
	        return true;
    }

    @Override
    public boolean eliminar(int idSolicitud) throws DAOException {
    try (Statement stmt = con.createStatement()) {
	            String query = "DELETE FROM solicitud WHERE idSolicitud=" + idSolicitud;
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error eliminando solicitud");
	            }
	        } catch (SQLException se) {
	            //se.printStackTrace();
	            throw new DAOException("Error eliminando solicitud en DAO", se);
	        } 
	   return true;    
    }

    @Override
    public Solicitud leerxid(int idSolicitud) throws DAOException {
    try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM solicitud WHERE idSolicitud=" + idSolicitud;
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            
            return (
                    new Solicitud(
                            rs.getInt("idSolicitud"),
                            rs.getInt("idPersona"),
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            rs.getBoolean("estado"))
                    );
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error buscando solicitud en DAO", se);
        }   
    }

    @Override
    public Solicitud[] leertodo() throws DAOException {
     try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM solicitud";
            ResultSet rs = stmt.executeQuery(query);            
            ArrayList<Solicitud> tribs = new ArrayList<>(); 
            
           
            while (rs.next()) {
                tribs.add(
                        
                        new Solicitud(
                            rs.getInt("idSolicitud"),
                            rs.getInt("idPersona"),
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            rs.getBoolean("estado"))
                        
                
                );
            }
            return tribs.toArray(new Solicitud[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos las persona en DAO: " + se.getMessage(), se);
        }      
    }
    
}
