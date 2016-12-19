/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.jdbc;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.factory.DBManager;
import com.sebatec.dao.interfaces.SolicitanteDAO;
import com.sebatec.dao.interfaces.TecnicoDAO;
import com.sebatec.enums.Estados;
import com.sebatec.enums.TipoUsuario;
import com.sebatec.modelo.Empresa;

import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Solicitante;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
/**
 *
 * @author Mi Laptop
 */
public class SolicitanteDAOJDBC implements SolicitanteDAO{
//crear la conecion
    private final Connection con;
	    public SolicitanteDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }

    @Override
    public Solicitante crear(Solicitante objsolite) throws DAOException {
      try{
        CallableStatement st=con.prepareCall("{call sp_solicitante_n(?,?,?,?,?,?,?,?,?,?)}");
                            st.setString(1,objsolite.getNombre());
                            st.setString(2,objsolite.getApellido());
                            st.setString(3,objsolite.getDni());
                            st.setString(4,objsolite.getDireccion());
                            st.setString(5,objsolite.getTelefono());
                            st.setString(6,objsolite.getEmail());
                            
                            st.setString(7,objsolite.getEmpresa().getRazon());
                            
                            st.setString(8,objsolite.getEmpresa().getRuc());
                             st.setString(9,objsolite.getEmpresa().getDireccion());
                            
                            st.setString(10,objsolite.getCargo());
                             
                            
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Solicitante(
                            rs.getInt("idSolicitante"),
                            new Empresa(
                            rs.getInt("idEmpresa"),
                            rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion")
                            ),
                            rs.getString("cargo"),
                             
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("direccion1"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            Estados.valueOf(rs.getString("estado"))
                            
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error creando tecnico en DAO", se);
        }
    }

    @Override
    public Solicitante modificar(Solicitante objsolite) throws DAOException {
       try{
        CallableStatement st=con.prepareCall("{call sp_solicitante_m(?,?,?,?,?,?,?,?)}");
                            st.setInt(1,objsolite.getIdSolicitante());
                            st.setString(2,objsolite.getNombre());
                            st.setString(3,objsolite.getApellido());
                            st.setString(4,objsolite.getDni());
                            st.setString(5,objsolite.getDireccion());
                            st.setString(6,objsolite.getTelefono());
                            st.setString(7,objsolite.getEmail());
                                                    
                            st.setString(8,objsolite.getCargo());
                            
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Solicitante(
                            rs.getInt("idSolicitante"),
                            new Empresa(
                            rs.getInt("idEmpresa"),
                            rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion")),
                            rs.getString("cargo"),
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("direccion1"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            Estados.valueOf(rs.getString("estado"))
                            
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error modificando tecnico en DAO", se);
        }
    }

    @Override
    public boolean eliminar(Solicitante objsolite) throws DAOException {
        try  {
	           CallableStatement st=con.prepareCall("{call sp_solicitante_e(?) }");
            
            st.setInt(1,objsolite.getIdSolicitante() );


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error eliminando solicitante");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error eliminando solicitante en DAO", se);
        }
        return true; 
    }

    @Override
    public Solicitante leerxid(Solicitante objsolite) throws DAOException {
         try{
        CallableStatement st=con.prepareCall("{call sp_solicitante_bco(?)}");
                            st.setInt(1,objsolite.getIdSolicitante());
                            
                            
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                    new Solicitante(
                            rs.getInt("idSolicitante"),
                            new Empresa(
                            rs.getInt("idEmpresa"),
                            rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion")),
                            
                            rs.getString("cargo"),
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("direccion1"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                          
                            Estados.valueOf(rs.getString("estado"))
                            
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error buscando solicitante en DAO", se);
        }
    }

    @Override
    public Solicitante[] leertodo() throws DAOException {
        try  {
             CallableStatement st=con.prepareCall("{call sp_solicitante_all()}");
           
              ResultSet rs = st.executeQuery();
                      
            ArrayList<Solicitante> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                    new Solicitante(
                            rs.getInt("idSolicitante"),
                            new Empresa(
                            rs.getInt("idEmpresa"),
                            rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion")),
                            rs.getString("cargo"),
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("direccion1"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            Estados.valueOf(rs.getString("estado"))
                            
                           
                     )
                            
                            
                   );
            }
            return tribs.toArray(new Solicitante[0]);
        } catch (SQLException se) {
            
            throw new DAOException("Error obteniedo todos los solicitantes en DAO: " 
                    + se.getMessage(), se);
        }  
    }

   
	  
}
