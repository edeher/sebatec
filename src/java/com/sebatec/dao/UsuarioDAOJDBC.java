/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mi Laptop
 */
public class UsuarioDAOJDBC implements UsuarioDAO{
//crear la conecion
    private final Connection con;
	    public UsuarioDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }
	    ///coneccion
    @Override
    public boolean crear(Usuario objusu) throws DAOException {
        try (Statement stmt = con.createStatement()) 
	        {
	            String query = "INSERT INTO Usuario (idTecnico,usuario,password,tipo,estado) VALUES ("
	                   
	                    +objusu.getIdTecnico()+",'"
	                    + objusu.getUsuario()+"','"
	                    +objusu.getPassword()+"','"
                            +objusu.getTipo()+"',"
	                    +objusu.isEstado()+")";
	            
	            
	            System.out.println(query);
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error añadiendo usuario");
	               
	            }  
	            
	            
	        } catch (SQLException se) {            
	            //se.printStackTrace();
	            throw new DAOException("Error añadiendo usuario en DAO", se);
	            
	        }   
	        return true;
    }

    @Override
    public boolean modificar(Usuario objusu) throws DAOException {
       try (Statement stmt = con.createStatement()) {
	            String query = "UPDATE Usuario "
	                    + "SET idTecnico="+objusu.getIdTecnico()+ ","
                        + "usuario='"+objusu.getUsuario()+"',"
                        + "password='"+objusu.getPassword()+"',"
                        + "tipo='"+objusu.getTipo()+"',"
                         + "estado="+objusu.isEstado()+" "
	                + "WHERE idUsuario=" + objusu.getIdUsuario();
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error actualizando datos del usuaeio");
	            }
	        } catch (SQLException se) {
	            throw new DAOException("Error actualizando datos del usuaio en DAO", se);
	        }    
	        return true;
    }

    @Override
    public boolean eliminar(int idUsuario) throws DAOException {
         try (Statement stmt = con.createStatement()) {
	            String query = "DELETE FROM Usuario WHERE idUsuario=" + idUsuario;
	            if (stmt.executeUpdate(query) != 1) {
	                throw new DAOException("Error eliminando usuario");
	            }
	        } catch (SQLException se) {
	            //se.printStackTrace();
	            throw new DAOException("Error eliminando usuario en DAO", se);
	        } 
	   return true;  
    }

    @Override
    public Usuario leerxid(int idUsuario) throws DAOException {
         try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM Usuario WHERE idUsuario=" + idUsuario;
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            
            return (
                    new Usuario(
                            rs.getInt("idUsuario"),
                            rs.getInt("idTecnico"),
                            rs.getString("usuario"),
                            rs.getString("password"),
                            rs.getString("tipo"),
                            rs.getBoolean("estado"))
                    );
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error buscando usuario en DAO", se);
        }   
    }

    @Override
    public Usuario[] leertodo() throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM Usuario";
            ResultSet rs = stmt.executeQuery(query);            
            ArrayList<Usuario> tribs = new ArrayList<>(); 
            
           
            while (rs.next()) {
                tribs.add(
                        
                      new Usuario(
                            rs.getInt("idUsuario"),
                            rs.getInt("idTecnico"),
                            rs.getString("usuario"),
                            rs.getString("password"),
                            rs.getString("tipo"),
                            rs.getBoolean("estado"))
                        
                
                );
            }
            return tribs.toArray(new Usuario[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los usuarios en DAO: " + se.getMessage(), se);
        }        
    }
    
}
