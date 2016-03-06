/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Servicio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Mi Laptop
 */
public class ServicioDAOJDBC implements ServicioDAO{
private final Connection con;
	//crear la conecion
	    public ServicioDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }
	    ///coneccion
    @Override
    public boolean crear(Servicio objservi) throws DAOException {
        try (Statement stmt = con.createStatement()) 
	        {
    String query = "INSERT INTO servicio (idSolicitud,idTecnico,descripcion,fechaEmision,fechaGestion,monto,estado) "
             + "VALUES ("+objservi.getIdSolicitud()+ ","
	                    + objservi.getIdTecnico()+ ",'"
	                    +objservi.getDescripcion()+"','"
	                    +new java.sql.Date(objservi.getFechaEmimsion().getTime())+"','"
	                    +new java.sql.Date(objservi.getFechaGestion().getTime())+"',"
	                    +objservi.getMonto()+","
	                    +objservi.isEstado()+""
	                    		+ ")";
	            
	            
	            System.out.println(query);
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error añadiendo tipo");
	               
	            }  
	            
	            
	        } catch (SQLException se) {            
	            //se.printStackTrace();
	            throw new DAOException("Error añadiendo tipo en DAO", se);
	            
	        }   
	        return true;
    
    }

    @Override
    public boolean modificar(Servicio objservi) throws DAOException {
       try (Statement stmt = con.createStatement()) {
	            String query = "UPDATE servicio "
	                    + "SET idSolicitud="+objservi.getIdSolicitud()+","
                        + "idTecnico="+objservi.getIdTecnico()+","
                        + "descripcion='"+objservi.getDescripcion()+"',"
                        + "fechaEmision='"+new java.sql.Date(objservi.getFechaEmimsion().getTime())+"',"
                        + "fechaGestion='"+new java.sql.Date(objservi.getFechaGestion().getTime())+"',"
                        + "monto="+objservi.getMonto()+","
                        + "estado="+objservi.isEstado()+" "
                            + "WHERE idServicio="+objservi.getIdServicio();
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error actualizando datos del servicio");
	            }
	        } catch (SQLException se) {
	            throw new DAOException("Error actualizando datos del servicio en DAO", se);
	        }    
	        return true;
    
    }

    @Override
    public boolean eliminar(int idServicio) throws DAOException {
       try (Statement stmt = con.createStatement()) {
	            String query = "DELETE FROM servicio WHERE idServicio=" + idServicio;
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error eliminando servicio");
	            }
	        } catch (SQLException se) {
	            //se.printStackTrace();
	            throw new DAOException("Error eliminando servicio en DAO", se);
	        } 
	   return true; 
    }

    @Override
    public Servicio leerxid(int idServicio) throws DAOException {
       try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM servicio WHERE idServicio=" + idServicio;
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            
            return (
                    new Servicio(
                            rs.getInt("idServicio"),
                            rs.getInt("idSolicitud"),
                            rs.getInt("idTecnico"),
                            rs.getString("descripcion"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            rs.getBoolean("estado")
                    )
                    );
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error buscando tributi en DAO", se);
        }
    }

    @Override
    public Servicio[] leertodo() throws DAOException {
       try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM servicio";
            ResultSet rs = stmt.executeQuery(query);            
            ArrayList<Servicio> tribs = new ArrayList<>(); 
            
           
            while (rs.next()) {
                tribs.add(
                        
                        new Servicio(
                        		rs.getInt("idServicio"),
                            rs.getInt("idSolicitud"),
                            rs.getInt("idTecnico"),
                            rs.getString("descripcion"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            rs.getBoolean("estado")
                    )
                        
                
                );
            }
            return tribs.toArray(new Servicio[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los servicios en DAO: " + se.getMessage(), se);
        }   
    }
    
}
