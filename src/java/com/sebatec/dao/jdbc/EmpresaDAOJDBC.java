/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.jdbc;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.factory.DBManager;
import com.sebatec.enums.Estados;
import com.sebatec.modelo.Empresa;


import com.sebatec.modelo.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import com.sebatec.dao.interfaces.EmpresaDAO;

/**
 *
 * @author Mi Laptop
 */
public class EmpresaDAOJDBC implements EmpresaDAO{
 
    private final Connection con;
//crear la conecion
    public EmpresaDAOJDBC() {
        this.con = DBManager.getConnection();
    }

    @Override
    public Empresa crear(Empresa objEmpre) throws DAOException {
        try{
        CallableStatement st=con.prepareCall("{call sp_empresa_n(?,?,?)}");
                            st.setString(1,objEmpre.getRazon());
                            st.setString(2,objEmpre.getRuc());
                            st.setString(3,objEmpre.getDireccion());
                           
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Empresa(
                            rs.getInt("idEmpresa"),
                             rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion")
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error creando empresa en DAO", se);
        }
    }

    @Override
    public Empresa modificar(Empresa objEmpre) throws DAOException {
        try{
        CallableStatement st=con.prepareCall("{call sp_empresa_m(?,?,?,?,?)}");
                            st.setInt(1,objEmpre.getIdEmpresa());
                            st.setString(2,objEmpre.getRazon());
                            st.setString(3,objEmpre.getRuc());
                            st.setString(4,objEmpre.getDireccion());
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Empresa(
                            rs.getInt("idEmpresa"),
                             rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion")
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error modificando empresa en DAO", se);
        }
    }

    @Override
    public boolean eliminar(Empresa objEmpre) throws DAOException {
        try  {
	           CallableStatement st=con.prepareCall("{call sp_empresa_e(?) }");
            
            st.setInt(1,objEmpre.getIdEmpresa());


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error eliminando empresa");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error eliminando empresa en DAO", se);
        }
        return true; 
    }

    @Override
    public Empresa leerxid(Empresa objEmpre) throws DAOException {
      try{
        CallableStatement st=con.prepareCall("{call sp_empresa_bco(?)}");
                            st.setInt(1,objEmpre.getIdEmpresa());
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                   new Empresa(
                            rs.getInt("idEmpresa"),
                             rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion")
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error buscando empresa en DAO", se);
        }
    }

    @Override
    public Empresa[] leertodo() throws DAOException {
      try  {
             CallableStatement st=con.prepareCall("{call sp_empresa_all()}");
           
              ResultSet rs = st.executeQuery();
                      
            ArrayList<Empresa> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add( new Empresa(
                            rs.getInt("idEmpresa"),
                             rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion")
                           
                     )
                            
                            
                   );
            }
            return tribs.toArray(new Empresa[0]);
        } catch (SQLException se) {
            
            throw new DAOException("Error obteniedo todos las empresas en DAO: " 
                    + se.getMessage(), se);
        }  
    
    }
    

   
    }
    

