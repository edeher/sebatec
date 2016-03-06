/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.TipoServicio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mi Laptop
 */
public class TipoServicioDAOJDBC implements TipoServicioDAO{
    private final Connection con;
//crear la conecion
    public TipoServicioDAOJDBC() {
        this.con = DBManager.getConnection();
    }
    ///coneccion
    @Override
    public boolean crear(TipoServicio objser)throws DAOException  {
        try (Statement stmt = con.createStatement()) 
        {
            String query = "INSERT INTO tiposervicio (descripcion,estado) VALUES ('"
                    + objser.getDescripcion()+ "'," 
                    + objser.isEstado()+ ")";
            
            
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
    public boolean modificar(TipoServicio objser) throws DAOException
    {
        
        try (Statement stmt = con.createStatement()) {
            String query = "UPDATE tiposervicio "
                    + "SET descripcion='" + objser.getDescripcion() + "',"
                    + "estado=" + objser.isEstado()+" "
                    + "WHERE idTipoServicio=" + objser.getIdTipoServicio();
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error actualizando datos del tiposervicio");
            }
        } catch (SQLException se) {
            throw new DAOException("Error actualizando datos del tributo en DAO", se);
        }    
        return true;
    }

    @Override
    public boolean eliminar(int idtipoServicio) throws DAOException{
        
       
        
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM tiposervicio WHERE idTipoServicio=" + idtipoServicio;
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error eliminando tributo");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error eliminando tributo en DAO", se);
        } 
   return true;
    }

    @Override
    public TipoServicio leerxid(int idTipoServicio) throws DAOException{
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM tiposervicio WHERE idTipoServicio=" + idTipoServicio;
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            TipoServicioDAOFactory tiposer = new TipoServicioDAOFactory();
            TipoServicioDAO daote = tiposer.crearTiposervicioDAO();
           
            return (
                    new TipoServicio(
                            rs.getInt("idTiposervicio"),
                            
                            rs.getString("descripcion"),
                             
                            rs.getBoolean("estado"))
                    );
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error buscando tributi en DAO", se);
        }}

    @Override
    public TipoServicio[] leertodo() throws DAOException
    {
         try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM tiposervicio";
            ResultSet rs = stmt.executeQuery(query);            
            ArrayList<TipoServicio> tribs = new ArrayList<>(); 
            TipoServicioDAOFactory fabrica = new TipoServicioDAOFactory ();
            TipoServicioDAO daoEmp = fabrica.crearTiposervicioDAO();
           
            while (rs.next()) {
                tribs.add(
                        
                        new TipoServicio(
                            rs.getInt("idTiposervicio"),
                            
                            rs.getString("descripcion"),
                             
                            rs.getBoolean("estado")
                        )
                        
                
                );
            }
            return tribs.toArray(new TipoServicio[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los tiposervicio en DAO: " + se.getMessage(), se);
        }   
    
    
    }
    
    
    
    
    
    
}
