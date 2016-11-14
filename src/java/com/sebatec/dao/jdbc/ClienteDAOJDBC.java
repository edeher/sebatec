/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.jdbc;

import com.sebatec.dao.interfaces.ClienteDAO;
import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.factory.DBManager;
import com.sebatec.enums.Estados;
import com.sebatec.modelo.Cliente;


import com.sebatec.modelo.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @Override
    public Cliente crear(Cliente objcli) throws DAOException {
        try{
        CallableStatement st=con.prepareCall("{call sp_cliente_n(?,?,?,?,?,?,?,?)}");
                            st.setString(1,objcli.getNombre());
                            st.setString(2,objcli.getApellido());
                            st.setString(3,objcli.getDni());
                            st.setString(4,objcli.getDireccion());
                            st.setString(5,objcli.getTelefono());
                            st.setString(6,objcli.getEmail());
                            st.setString(7,objcli.getRuc());
                            
                            st.setString(8,objcli.getRazonSocial());
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("ruc"),
                            rs.getString("razonsocial"),
                            
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            Estados.valueOf(rs.getString("estado"))
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error creando cliente en DAO", se);
        }
    }

    @Override
    public Cliente modificar(Cliente objcli) throws DAOException {
        try{
        CallableStatement st=con.prepareCall("{call sp_cliente_m(?,?,?,?,?,?,?,?,?,?)}");
                            st.setInt(1,objcli.getIdCliente());
                            st.setString(2,objcli.getNombre());
                            st.setString(3,objcli.getApellido());
                            st.setString(4,objcli.getDni());
                            st.setString(5,objcli.getDireccion());
                            st.setString(6,objcli.getTelefono());
                            st.setString(7,objcli.getEmail());
                            st.setString(8,objcli.getRuc());
                            st.setString(9,objcli.getRazonSocial());
                            st.setString(10, objcli.getEstado().name());
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("ruc"),
                            rs.getString("razonsocial"),
                            
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            Estados.valueOf(rs.getString("estado"))
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error modificando cliente en DAO", se);
        }
    }

    @Override
    public boolean eliminar(Cliente objCli) throws DAOException {
        try  {
	           CallableStatement st=con.prepareCall("{call sp_cliente_e(?) }");
            
            st.setInt(1,objCli.getIdCliente());


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error eliminando Cliente");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error eliminando cliente en DAO", se);
        }
        return true; 
    }

    @Override
    public Cliente leerxid(Cliente objCli) throws DAOException {
      try{
        CallableStatement st=con.prepareCall("{call sp_cliente_bco(?)}");
                            st.setInt(1,objCli.getIdCliente());
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("ruc"),
                            rs.getString("razonsocial"),
                            
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            Estados.valueOf(rs.getString("estado"))
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error buscando cliente en DAO", se);
        }
    }

    @Override
    public Cliente[] leertodo() throws DAOException {
      try  {
             CallableStatement st=con.prepareCall("{call sp_cliente_all()}");
           
              ResultSet rs = st.executeQuery();
                      
            ArrayList<Cliente> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                      new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("ruc"),
                            rs.getString("razonsocial"),
                            
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            Estados.valueOf(rs.getString("estado"))
                           
                     )
                            
                            
                   );
            }
            return tribs.toArray(new Cliente[0]);
        } catch (SQLException se) {
            
            throw new DAOException("Error obteniedo todos los Cliente en DAO: " 
                    + se.getMessage(), se);
        }  
    
    }
    

   
    }
    

