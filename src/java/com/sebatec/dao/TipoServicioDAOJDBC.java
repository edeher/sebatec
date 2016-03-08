/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;


import com.sebatec.modelo.Estados;
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
    ///coneccion
    @Override
    public boolean crear(TipoServicio objser)throws DAOException  {
        try 
        {
           CallableStatement st=con.prepareCall("{call sp_tipoServicio_n(?,?)}");
	                   
	                    st.setString(1,objser.getDescripcion());
                            st.setString(2,objser.getEstado().name());
            
            if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando tipo servicio");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo tipo servicio en DAO", se);
        }
        return (true);
    }

    @Override
    public boolean modificar(TipoServicio objser) throws DAOException
    {
        
        try  {
             CallableStatement st=con.prepareCall("{call sp_tipoServicio_m(?,?,?)}");
                            
                            st.setInt(1, objser.getIdTipoServicio());
	                    st.setString(2,objser.getDescripcion());
                            st.setString(3,objser.getEstado().name());
            
            if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error modificando tiposervicio");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo tiposervicio en DAO", se);
        }
        return (true);
    }

    @Override
    public boolean eliminar(int idtipoServicio) throws DAOException{
        
       
        
        try  {
            CallableStatement st=con.prepareCall("{call sp_tipoServicio_e(?) }");
            
            st.setInt(1,idtipoServicio);


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando tiposervicio");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo tiposervicio en DAO", se);
        }
        return true; 
    }

    @Override
    public TipoServicio leerxid(int idTipoServicio) throws DAOException{
        try  {
            CallableStatement st=con.prepareCall("{call sp_tipoServicio_bco(?)}");
            st.setInt(1,idTipoServicio);
              ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                    new TipoServicio(
                            rs.getInt("idTiposervicio"),
                            
                            rs.getString("descripcion"),
                             
                            Estados.valueOf(rs.getString("estado")))
                    );
        } catch (SQLException se) {
            
            throw new DAOException("Error buscando tiposervicio en DAO", se);
        
        }}

    @Override
    public TipoServicio[] leertodo() throws DAOException
    {
         try  {
            CallableStatement stm=con.prepareCall("{call sp_tipoServicio_all}");
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<TipoServicio> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                        
                        new TipoServicio(
                            rs.getInt("idTiposervicio"),
                            
                            rs.getString("descripcion"),
                             
                            Estados.valueOf(rs.getString("estado"))
                        )
                        
                
              );
            }
            return tribs.toArray(new TipoServicio[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los tiposervicio en DAO: " 
                    + se.getMessage(), se);
        }   
    
    
    }
    
    
    
    
    
    
}
