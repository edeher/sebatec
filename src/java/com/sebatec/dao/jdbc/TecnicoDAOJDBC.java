/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.jdbc;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.factory.DBManager;
import com.sebatec.dao.interfaces.TecnicoDAO;
import com.sebatec.enums.Estados;
import com.sebatec.enums.TipoUsuario;

import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Tecnico;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @Override
    public Tecnico crear(Tecnico objTec) throws DAOException {
      try{
        CallableStatement st=con.prepareCall("{call sp_tecnico_n(?,?,?,?,?,?,?,?,?,?,?)}");
                            st.setString(1,objTec.getNombre());
                            st.setString(2,objTec.getApellido());
                            st.setString(3,objTec.getDni());
                            st.setString(4,objTec.getDireccion());
                            st.setString(5,objTec.getTelefono());
                            st.setString(6,objTec.getEmail());
                            
                            st.setString(7,objTec.getProfesion());
                            
                            st.setString(8,objTec.getEspecialidad());
                             st.setString(9,objTec.getUsuario());
                            
                            st.setString(10,objTec.getPassword());
                             st.setString(11,objTec.getTipousuario().name());
                            
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Tecnico(
                            rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                            rs.getString("especialidad"),
                            rs.getString("usuario"),
                            null,
                            TipoUsuario.valueOf(rs.getString("tipoUsuario")),
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
            
            throw new DAOException("Error creando tecnico en DAO", se);
        }
    }

    @Override
    public Tecnico modificar(Tecnico objTec) throws DAOException {
       try{
        CallableStatement st=con.prepareCall("{call sp_tecnico_m(?,?,?,?,?,?,?,?,?,?,?,?)}");
                            st.setInt(1,objTec.getIdTecnico());
                            st.setString(2,objTec.getNombre());
                            st.setString(3,objTec.getApellido());
                            st.setString(4,objTec.getDni());
                            st.setString(5,objTec.getDireccion());
                            st.setString(6,objTec.getTelefono());
                            st.setString(7,objTec.getEmail());
                            
                            st.setString(8,objTec.getProfesion());
                            
                            st.setString(9,objTec.getEspecialidad());
                             st.setString(10,objTec.getUsuario());
                            
                            st.setString(11,objTec.getPassword());
                             st.setString(12,objTec.getTipousuario().name());
                            
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Tecnico(
                            rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                            rs.getString("especialidad"),
                            rs.getString("usuario"),
                            null,
                            TipoUsuario.valueOf(rs.getString("tipoUsuario")),
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
            
            throw new DAOException("Error modificando tecnico en DAO", se);
        }
    }

    @Override
    public boolean eliminar(Tecnico objTec) throws DAOException {
        try  {
	           CallableStatement st=con.prepareCall("{call sp_tecnico_e(?) }");
            
            st.setInt(1,objTec.getIdTecnico() );


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error eliminando tecnico");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error eliminando tecnico en DAO", se);
        }
        return true; 
    }

    @Override
    public Tecnico leerxid(Tecnico objTec) throws DAOException {
         try{
        CallableStatement st=con.prepareCall("{call sp_tecnico_bco(?)}");
                            st.setInt(1,objTec.getIdTecnico());
                            
                            
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Tecnico(
                            rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                            rs.getString("especialidad"),
                            rs.getString("usuario"),
                            null,
                            TipoUsuario.valueOf(rs.getString("tipoUsuario")),
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
            
            throw new DAOException("Error buscando tecnico en DAO", se);
        }
    }

    @Override
    public Tecnico[] leertodo() throws DAOException {
        try  {
             CallableStatement st=con.prepareCall("{call sp_tecnico_all()}");
           
              ResultSet rs = st.executeQuery();
                      
            ArrayList<Tecnico> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                       new Tecnico(
                            rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                            rs.getString("especialidad"),
                            rs.getString("usuario"),
                            null,
                            TipoUsuario.valueOf(rs.getString("tipoUsuario")),
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
            return tribs.toArray(new Tecnico[0]);
        } catch (SQLException se) {
            
            throw new DAOException("Error obteniedo todos los tecnicos en DAO: " 
                    + se.getMessage(), se);
        }  
    }

    @Override
    public Tecnico validar(Tecnico objTec) throws DAOException {
         try{
        CallableStatement st=con.prepareCall("{call sp_tecnico_validar(?,?)}");
                            st.setString(1,objTec.getUsuario());
                            st.setString(2,objTec.getPassword());
                             
                            
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new Tecnico(
                            rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                            rs.getString("especialidad"),
                            rs.getString("usuario"),
                            null,
                            TipoUsuario.valueOf(rs.getString("tipoUsuario")),
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
            
            throw new DAOException("Error validando tecnico en DAO", se);
        }
    }
	  
}
