/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Cliente;

import com.sebatec.modelo.Estados;
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
    ///coneccion
    @Override

    public boolean crear(Cliente objcli)throws DAOException
    { 
        try {

            
            CallableStatement st=con.prepareCall("{call sp_cliente_n(?,?,?,?,?,?,?,?)}");
            
           
                            st.setString(1,objcli.getNombre());
                            st.setString(2,objcli.getApellido());
                            st.setString(3,objcli.getDni());
                            st.setString(4, objcli.getDireccion());
                            st.setString(5, objcli.getTelefono());
	                    st.setString(6, objcli.getEmail());
                            
                            st.setString(7, objcli.getRuc());
                            st.setString(8, objcli.getRazonSocial());
                            
            
            if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando cliente");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo cliente en DAO", se);
        }
        return (true);
    
    }

    @Override

public boolean modificar(Cliente objcli) throws DAOException {
        
       
        try {

            
            CallableStatement st=con.prepareCall("{call sp_cliente_m(?,?,?,?,?,?,?,?,?)}");
            
                            st.setInt(1,objcli.getIdCliente());
                            st.setString(2,objcli.getNombre());
                            st.setString(3,objcli.getApellido());
                            st.setString(4,objcli.getDni());
                            st.setString(5, objcli.getDireccion());
                            st.setString(6, objcli.getTelefono());
	                    st.setString(7, objcli.getEmail());
                            
                            st.setString(8, objcli.getRuc());
                            st.setString(9, objcli.getRazonSocial());
                            
            
            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando cliente");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo tipo en DAO", se);
        }
        return (true);
    }

    @Override

   public boolean eliminar(int idCliente) throws DAOException {  
       
        try {

            
            CallableStatement st=con.prepareCall("{call sp_cliente_e(?) }");
            
            st.setInt(1,idCliente);


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando cliente");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo tipo en DAO", se);
        }
        return true;
   
   }
    @Override

    
     public Cliente leerxid(int idCliente) throws DAOException {
    try  {
        
            CallableStatement st=con.prepareCall("{call sp_cliente_bco(?)}");
            st.setInt(1,idCliente);
              ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                    new Cliente(
                              rs.getInt("idCliente"),
                              rs.getString("ruc"),
                              rs.getString("razonSocial"),
                            
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email"))
                             
                            
                            
                    );
        } catch (SQLException se) {
            
            throw new DAOException("Error buscando cliente en DAO", se);
        }
    
    }
     
    @Override

    public Cliente[] leertodo() throws DAOException {
     try  {
            CallableStatement stm=con.prepareCall("{call sp_cliente_all}");
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<Cliente> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                         new Cliente(
                              rs.getInt("idCliente"),
                              rs.getString("ruc"),
                              rs.getString("razonSocial"),
                            
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email"))
                             
                            
                            
                    );
            }
            return tribs.toArray(new Cliente[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los clientes en DAO: " 
                    + se.getMessage(), se);
        }   
    
    }
    
}
