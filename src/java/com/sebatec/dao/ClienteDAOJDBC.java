/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Cliente;
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
public class ClienteDAOJDBC implements ClienteDAO{
 
    private final Connection con;
//crear la conecion
    public ClienteDAOJDBC() {
        this.con = DBManager.getConnection();
    }
    ///coneccion
    @Override
    public boolean crear(Cliente objcli) throws DAOException {
        try (Statement stmt = con.createStatement()) 
        {
            String query = "INSERT INTO cliente (idPersona,estado) VALUES ("
                   
                    + objcli.getIdPersona()+ ","
                    + objcli.isEstado()+ ")";
            
            
            System.out.println(query);
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error añadiendo tipo");
               
            }  
            
            
        } catch (SQLException se) {            
            //se.printStackTrace();
            throw new DAOException("Error añadiendo tipo en DAO", se);
            
        }   
        return true;}

    @Override
    public boolean modificar(Cliente objcli) throws DAOException {
        
        try (Statement stmt = con.createStatement()) {
            String query = "UPDATE cliente "
                    + "SET idPersona='" + objcli.getIdPersona() + "',"
                    + "estado=" + objcli.isEstado()+" "
                    + "WHERE idCliente=" + objcli.getIdCliente();
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error actualizando datos del tiposervicio");
            }
        } catch (SQLException se) {
            throw new DAOException("Error actualizando datos del tributo en DAO", se);
        }    
        return true;
    }

    @Override
    public boolean eliminar(int idCliente) throws DAOException {  
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM cliente WHERE idCliente=" + idCliente;
            if (stmt.executeUpdate(query) != 1) {
                throw new DAOException("Error eliminando tributo");
            }
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error eliminando tributo en DAO", se);
        } 
   return true;}

    @Override
    public Cliente leerxid(int idCliente) throws DAOException {
    try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM cliente WHERE idCliente=" + idCliente;
            ResultSet rs = stmt.executeQuery(query);
            if (!rs.next()) {
                return null;
            }
            ClienteDAOFactory cli = new ClienteDAOFactory();
            ClienteDAO daote = cli.metodoDAO();
           
            return (
                    new Cliente(
                            rs.getInt("idCliente"),
                            
                            rs.getInt("idPersona"),
                             
                            rs.getBoolean("estado"))
                    );
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error buscando tributi en DAO", se);
        }
    
    }

    @Override
    public Cliente[] leertodo() throws DAOException {
     try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM cliente";
            ResultSet rs = stmt.executeQuery(query);            
            ArrayList<Cliente> tribs = new ArrayList<>(); 
            ClienteDAOFactory cli = new ClienteDAOFactory();
            ClienteDAO daote = cli.metodoDAO();
           
            while (rs.next()) {
                tribs.add(
                        
                        new Cliente(
                            rs.getInt("idCliente"),
                            
                            rs.getInt("idPersona"),
                             
                            rs.getBoolean("estado")
                        )
                        
                
                );
            }
            return tribs.toArray(new Cliente[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los tiposervicio en DAO: " + se.getMessage(), se);
        }   
    
    }
    
}
