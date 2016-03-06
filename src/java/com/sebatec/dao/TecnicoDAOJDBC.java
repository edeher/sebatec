/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Tecnico;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Mi Laptop
 */
public class TecnicoDAOJDBC implements TecnicoDAO{
//crear la conecion
    private final Connection con;
	    public TecnicoDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }
	    ///coneccion
    @Override
    public boolean crear(Tecnico objtec) throws DAOException {
        try (Statement stmt = con.createStatement()) 
	        {
	            String query = "INSERT INTO Tecnico (idPersona,profesion,especialidad,estado) VALUES ("
	                   
	                    +objtec.getIdPersona()+",'"
	                    + objtec.getProfesion()+"','"
	                    +objtec.getEspecialidad()+"',"
	                    +objtec.isEstado()+")";
	            
	            
	            System.out.println(query);
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error añadiendo tecnicod");
	               
	            }  
	            
	            
	        } catch (SQLException se) {            
	            //se.printStackTrace();
	            throw new DAOException("Error añadiendo tecnico en DAO", se);
	            
	        }   
	        return true;
    }

    @Override
    public boolean modificar(Tecnico objtec) throws DAOException {
        try (Statement stmt = con.createStatement()) {
	            String query = "UPDATE Tecnico "
	                    + "SET idPersona="+objtec.getIdPersona()+ ","
                        + "profesion='"+objtec.getProfesion() + "',"
                        + "especialidad='"+objtec.getEspecialidad()+"',"
                        + "estado="+objtec.isEstado()+" "
	                + "WHERE idTecnico=" + objtec.getIdTecnico();
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error actualizando datos del tecnico");
	            }
	        } catch (SQLException se) {
	            throw new DAOException("Error actualizando datos del tecnico en DAO", se);
	        }    
	        return true;
    }

    @Override
    public boolean eliminar(int idTecnico) throws DAOException {
        try (Statement stmt = con.createStatement()) {
	            String query = "DELETE FROM tecnico WHERE idTecnico=" + idTecnico;
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error eliminando tecnico");
	            }
	        } catch (SQLException se) {
	            //se.printStackTrace();
	            throw new DAOException("Error eliminando tecnico en DAO", se);
	        } 
	   return true;  
    }

    @Override
    public Tecnico leerxid(int idTecnico) throws DAOException {
         try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM tecnico WHERE idTecnico=" + idTecnico;
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            
            return (
                    new Tecnico(
                            rs.getInt("idTecnico"),
                            rs.getInt("idPersona"),
                            rs.getString("profesion"),
                            rs.getString("especialidad"),
                            rs.getBoolean("estado"))
                    );
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error buscando solicitud en DAO", se);
        }   
    }

    @Override
    public Tecnico[] leertodo() throws DAOException {
         try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM tecnico";
            ResultSet rs = stmt.executeQuery(query);            
            ArrayList<Tecnico> tribs = new ArrayList<>(); 
            
           
            while (rs.next()) {
                tribs.add(
                        
                       new Tecnico(
                            rs.getInt("idTecnico"),
                            rs.getInt("idPersona"),
                            rs.getString("profesion"),
                            rs.getString("especialidad"),
                            rs.getBoolean("estado"))
                        
                
                );
            }
            return tribs.toArray(new Tecnico[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos las persona en DAO: " + se.getMessage(), se);
        }       
    
    }
    
}
