/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.jdbc;


import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.factory.DBManager;
import com.sebatec.dao.interfaces.TipoServicioDAO;
import com.sebatec.enums.Estados;

import com.sebatec.modelo.TipoServicio;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    @Override
    public TipoServicio crear(TipoServicio objSer) throws DAOException {
       try{
        CallableStatement st=con.prepareCall("{call sp_tiposervicio_n(?)}");
                            st.setString(1,objSer.getDescripcion());
                            
                            
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new TipoServicio(
                            rs.getInt("idTipoServicio"),
                            rs.getString("descripcion"),
                           
                            Estados.valueOf(rs.getString("estado"))
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error creando tipo de servicio en DAO", se);
        }
    
    }

    @Override
    public TipoServicio modificar(TipoServicio objSer) throws DAOException {
       try{
        CallableStatement st=con.prepareCall("{call sp_tiposervicio_m(?,?,?)}");
                            st.setInt(1,objSer.getIdTipoServicio());
                             st.setString(2,objSer.getDescripcion());
                             st.setString(3,objSer.getEstado().name());
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                     new TipoServicio(
                            rs.getInt("idTipoServicio"),
                            rs.getString("descripcion"),
                           
                            Estados.valueOf(rs.getString("estado"))
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error modificando tipo de servicio en DAO", se);
        }
    }

    @Override
    public boolean eliminar(TipoServicio objSer) throws DAOException {
        try  {
	           CallableStatement st=con.prepareCall("{call sp_tiposervicio_e(?) }");
            
            st.setInt(1,objSer.getIdTipoServicio() );


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error eliminando tiposervicio");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error eliminando tiposservicio en DAO", se);
        }
        return true; 
    }

    @Override
    public TipoServicio leerxid(TipoServicio objSer) throws DAOException {
        try{
        CallableStatement st=con.prepareCall("{call sp_tiposervicio_bco(?)}");
                            st.setInt(1,objSer.getIdTipoServicio());
                             
                            
                           
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                        
                    new TipoServicio(
                            rs.getInt("idTipoServicio"),
                            rs.getString("descripcion"),
                           
                            Estados.valueOf(rs.getString("estado"))
                           
                     )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error buscando tipo de servicio en DAO", se);
        }
    }

    @Override
    public TipoServicio[] leertodo() throws DAOException {
        try  {
             CallableStatement st=con.prepareCall("{call sp_tiposervicio_all()}");
           
              ResultSet rs = st.executeQuery();
                      
            ArrayList<TipoServicio> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                      new TipoServicio(
                            rs.getInt("idTipoServicio"),
                            rs.getString("descripcion"),
                           
                            Estados.valueOf(rs.getString("estado"))
                           
                     )
                            
                            
                   );
            }
            return tribs.toArray(new TipoServicio[0]);
        } catch (SQLException se) {
            
            throw new DAOException("Error obteniedo todos los tipos de servicio en DAO: " 
                    + se.getMessage(), se);
        }  
    }
 
    
    
}
