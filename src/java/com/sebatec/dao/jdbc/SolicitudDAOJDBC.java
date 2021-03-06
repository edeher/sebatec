/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.jdbc;


import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.factory.DBManager;
import com.sebatec.dao.interfaces.SolicitudDAO;
import com.sebatec.modelo.Empresa;
import com.sebatec.enums.EstadoSolicitud;
import com.sebatec.enums.Estados;
import com.sebatec.modelo.Solicitante;
import com.sebatec.modelo.Solicitud;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Mi Laptop
 */
public class SolicitudDAOJDBC implements SolicitudDAO{
 private final Connection con;
	//crear la conecion
	    public SolicitudDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }
	    ///coneccion

    @Override
    public Solicitud crear(Solicitud objSoli) throws DAOException {
       try{
        CallableStatement st=con.prepareCall("{call sp_solicitud_n(?,?,?,?,?,?,?,?,?,?,?)}");
                            st.setString(1,objSoli.getSolicitante().getNombre());
                            st.setString(2,objSoli.getSolicitante().getApellido());
                            st.setString(3,objSoli.getSolicitante().getDni());
                            st.setString(4,objSoli.getSolicitante().getDireccion());
                            st.setString(5,objSoli.getSolicitante().getTelefono());
                            st.setString(6,objSoli.getSolicitante().getEmail());
                            
                            st.setString(7,objSoli.getSolicitante().getEmpresa().getRazon());
                            st.setString(8,objSoli.getSolicitante().getEmpresa().getRuc());
                            st.setString(9,objSoli.getSolicitante().getEmpresa().getDireccion());
                            
                            st.setString(10,objSoli.getSolicitante().getCargo());
                            st.setString(11,objSoli.getDescripcion());
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                      new Solicitud(  
                              rs.getInt("idSolicitud"),
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
                            
                           
                     ),
                              rs.getString("descripcion"),
                              rs.getDate("fecha"),
                              rs.getString("observacion"),
                              EstadoSolicitud.valueOf(rs.getString("estadoSolicitud"))
                      )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error creando solicitud en DAO", se);
        }
    }

  @Override
    public Solicitud modificar(Solicitud objSoli) throws DAOException {
       try{
        CallableStatement st=con.prepareCall("{call sp_solicitud_m(?,?,?,?)}");
                             st.setInt(1,objSoli.getIdSolicitud());
                           
                             st.setString(2,objSoli.getDescripcion());
                             st.setString(3,objSoli.getObservacion());
                             st.setString(4,objSoli.getEstadoSolicitud().name());
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                     new Solicitud(  
                              rs.getInt("idSolicitud"),
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
                            
                           
                     ),
                              rs.getString("descripcion"),
                              rs.getDate("fecha"),
                              rs.getString("observacion"),
                              EstadoSolicitud.valueOf(rs.getString("estadoSolicitud"))
                      )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error modificando solicitud en DAO", se);
        }
    }

    @Override
    public boolean eliminar(Solicitud objSoli) throws DAOException {
        try  {
	           CallableStatement st=con.prepareCall("{call sp_solicitud_e(?) }");
            
            st.setInt(1,objSoli.getIdSolicitud());


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error eliminando solicitud");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error eliminando solicitud en DAO", se);
        }
        return true; 
    }

    @Override
    public Solicitud leerxid(Solicitud objSoli) throws DAOException {
      try{
        CallableStatement st=con.prepareCall("{call sp_solicitud_bco(?)}");
                            st.setInt(1,objSoli.getIdSolicitud());
                             
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                     new Solicitud(  
                              rs.getInt("idSolicitud"),
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
                            
                           
                     ),
                              rs.getString("descripcion"),
                              rs.getDate("fecha"),
                              rs.getString("observacion"),
                              EstadoSolicitud.valueOf(rs.getString("estadoSolicitud"))
                      )
                            
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error buscando solicitud en DAO", se);
        }

    }

    @Override
    public Solicitud[] leertodo() throws DAOException {
        try  {
             CallableStatement st=con.prepareCall("{call sp_solicitud_all()}");
           
              ResultSet rs = st.executeQuery();
                      
            ArrayList<Solicitud> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        new Solicitud(  
                            rs.getInt("idSolicitud"),
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
                            
                           
                     ),
                              rs.getString("descripcion"),
                              rs.getDate("fecha"),
                              rs.getString("observacion"),
                              EstadoSolicitud.valueOf(rs.getString("estadoSolicitud"))
                      )
                            
                            
                   );
            }
            return tribs.toArray(new Solicitud[0]);
        } catch (SQLException se) {
            
            throw new DAOException("Error obteniedo todos las solicitudes en DAO: " 
                    + se.getMessage(), se);
        }  
    }
   
    
}
