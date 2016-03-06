/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mi Laptop
 */
public class PersonaDAOJDBC implements PersonaDAO{
   private final Connection con;
	//crear la conecion
	    public PersonaDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }
	    ///coneccion
	@Override
	public boolean crear(Persona objper) throws DAOException {
		 try (Statement stmt = con.createStatement()) 
	        {
	            String query = "INSERT INTO persona (nombre,apellido,dni,razon,ruc,direccion,telefono,email,estado) VALUES ('"
	                   
	                    +objper.getNombre()+ "','"
	                    + objper.getApellido()+ "','"
	                    +objper.getDni()+"','"
	                    +objper.getRazon()+"','"
	                    +objper.getRuc()+"','"
	                    +objper.getDireccion()+"','"
	                    +objper.getTelefono()+"','"
	                    +objper.getEmail()+"',"
	                    +objper.isEstado()+""
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
	public boolean modificar(Persona objper) throws DAOException {
		  try (Statement stmt = con.createStatement()) {
	            String query = "UPDATE persona "
	                    + "SET nombre='"+objper.getNombre()+ "',"
                        + "apellido='"+ objper.getApellido()+ "',"
                        + "dni='"+objper.getDni()+"',"
                        + "razon='"+objper.getRazon()+"',"
                        + "ruc='"+objper.getRuc()+"',"
                        + "direccion='"+objper.getDireccion()+"',"
                        + "telefono='"+objper.getTelefono()+"',"
                        + "email='"+objper.getEmail()+"',"
                        + "estado="+objper.isEstado()+" "
	                    
	                    
	                    + "WHERE idPersona=" + objper.getIdPersona();
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error actualizando datos del tiposervicio");
	            }
	        } catch (SQLException se) {
	            throw new DAOException("Error actualizando datos del tributo en DAO", se);
	        }    
	        return true;
	}

	@Override
	public boolean eliminar(int idPersona) throws DAOException {
		 try (Statement stmt = con.createStatement()) {
	            String query = "DELETE FROM persona WHERE idPersona=" + idPersona;
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error eliminando persona");
	            }
	        } catch (SQLException se) {
	            //se.printStackTrace();
	            throw new DAOException("Error eliminando tributo en DAO", se);
	        } 
	   return true;
	}

	@Override
	public Persona leerxid(int idPersona) throws DAOException {
		try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM persona WHERE idPersona=" + idPersona;
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            
            return (
                    new Persona(
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            rs.getBoolean("estado"))
                    );
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error buscando tributi en DAO", se);
        }
	}

	@Override
	public Persona[] leertodo() throws DAOException {
		try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM persona";
            ResultSet rs = stmt.executeQuery(query);            
            ArrayList<Persona> tribs = new ArrayList<>(); 
            
           
            while (rs.next()) {
                tribs.add(
                        
                        new Persona(
                        		 rs.getInt("idPersona"),
                                 rs.getString("nombre"),
                                 rs.getString("apellido"),
                                 rs.getString("dni"),
                                 rs.getString("razon"),
                                 rs.getString("ruc"),
                                 rs.getString("direccion"),
                                 rs.getString("telefono"),
                                 rs.getString("email"),
                                 rs.getBoolean("estado"))
                        
                
                );
            }
            return tribs.toArray(new Persona[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos las persona en DAO: " + se.getMessage(), se);
        }   
	}

}
