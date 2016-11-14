/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.jdbc;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.factory.DBManager;
import com.sebatec.dao.interfaces.ServicioDAO;
import com.sebatec.enums.EstadoServicio;
import com.sebatec.enums.EstadoSolicitud;
import com.sebatec.enums.Estados;
import com.sebatec.enums.TipoUsuario;
import com.sebatec.modelo.Cliente;

import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Servicio;
import com.sebatec.modelo.Solicitud;
import com.sebatec.modelo.Tecnico;
import com.sebatec.modelo.TipoServicio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Mi Laptop
 */
public class ServicioDAOJDBC implements ServicioDAO{
private final Connection con;
	//crear la conecion
	    public ServicioDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }

    @Override
    public Servicio crear(Servicio objSer) throws DAOException {
       try{
        CallableStatement st=con.prepareCall("{call sp_servicio_n(?,?,?,?)}");
                            st.setInt(1,objSer.getSolicitud().getIdSolicitud());
                            st.setInt(2,objSer.getTecnico().getIdTecnico());
                            st.setInt(3,objSer.getTiposervicio().getIdTipoServicio());
                            st.setString(4,objSer.getDescripcion());
                            
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                    new Servicio(
                            rs.getInt("idServicio"),
                      new Solicitud(  
                              rs.getInt("idSolicitud"),
                     new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("ruc"),
                            rs.getString("razonsocial"),
                            
                            rs.getInt("idPersona1"),
                            rs.getString("nombre1"),
                            rs.getString("apellido1"),
                            rs.getString("dni1"),
                            rs.getString("direccion1"),
                            rs.getString("telefono1"),
                            rs.getString("email1"),
                            Estados.valueOf(rs.getString("estado1"))
                           
                     ),
                              rs.getString("descripcion1"),
                              rs.getDate("fecha"),
                              rs.getString("observacion"),
                              EstadoSolicitud.valueOf(rs.getString("estadoSolicitud"))
                      ),
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
                            Estados.valueOf(rs.getString("estado2"))
                      
                      ), 
                            new TipoServicio (
                                     rs.getInt("idTipoServicio"),
                            rs.getString("descripcion"),
                           
                            Estados.valueOf(rs.getString("estado"))
                            )
                            
                            ,
                            rs.getString("descripcion"),
                            rs.getDate("fechaAsignacion"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoServicio.valueOf(rs.getString("estadoServicio"))
                              )
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error creando solicitud en DAO", se);
        }
    }

    @Override
    public Servicio modificar(Servicio objSer) throws DAOException {
        try{
        CallableStatement st=con.prepareCall("{call sp_servicio_m(?,?,?,?,?,?)}");
                            st.setInt(1, objSer.getIdServicio());
                        
                            st.setInt(2,objSer.getTecnico().getIdTecnico());
                            st.setInt(3,objSer.getTiposervicio().getIdTipoServicio());
                            st.setString(4,objSer.getDescripcion());
                            st.setDouble(5, objSer.getMonto());
                            st.setString(6,objSer.getEstadoservicio().name());
                          
                            
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                    new Servicio(
                            rs.getInt("idServicio"),
                      new Solicitud(  
                              rs.getInt("idSolicitud"),
                     new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("ruc"),
                            rs.getString("razonsocial"),
                            
                            rs.getInt("idPersona1"),
                            rs.getString("nombre1"),
                            rs.getString("apellido1"),
                            rs.getString("dni1"),
                            rs.getString("direccion1"),
                            rs.getString("telefono1"),
                            rs.getString("email1"),
                            Estados.valueOf(rs.getString("estado1"))
                           
                     ),
                              rs.getString("descripcion1"),
                              rs.getDate("fecha"),
                              rs.getString("observacion"),
                              EstadoSolicitud.valueOf(rs.getString("estadoSolicitud"))
                      ),
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
                            Estados.valueOf(rs.getString("estado2"))
                      
                      ), 
                            new TipoServicio (
                                     rs.getInt("idTipoServicio"),
                            rs.getString("descripcion"),
                           
                            Estados.valueOf(rs.getString("estado"))
                            )
                            
                            ,
                            rs.getString("descripcion"),
                            rs.getDate("fechaAsignacion"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoServicio.valueOf(rs.getString("estadoServicio"))
                              )
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error creando solicitud en DAO", se);
        }
    }

    @Override
    public boolean eliminar(Servicio objSer) throws DAOException {
        try  {
	           CallableStatement st=con.prepareCall("{call sp_servicio_e(?) }");
            
            st.setInt(1,objSer.getIdServicio());


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
    public Servicio leerxid(Servicio objSer) throws DAOException {
        try{
        CallableStatement st=con.prepareCall("{call sp_servicio_bco(?)}");
                            st.setInt(1,objSer.getIdServicio());
                          
                            
                            
                          
             ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                    new Servicio(
                            rs.getInt("idServicio"),
                      new Solicitud(  
                              rs.getInt("idSolicitud"),
                     new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("ruc"),
                            rs.getString("razonsocial"),
                            
                            rs.getInt("idPersona1"),
                            rs.getString("nombre1"),
                            rs.getString("apellido1"),
                            rs.getString("dni1"),
                            rs.getString("direccion1"),
                            rs.getString("telefono1"),
                            rs.getString("email1"),
                            Estados.valueOf(rs.getString("estado1"))
                           
                     ),
                              rs.getString("descripcion1"),
                              rs.getDate("fecha"),
                              rs.getString("observacion"),
                              EstadoSolicitud.valueOf(rs.getString("estadoSolicitud"))
                      ),
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
                            Estados.valueOf(rs.getString("estado2"))
                      
                      ), 
                            new TipoServicio (
                                     rs.getInt("idTipoServicio"),
                            rs.getString("descripcion"),
                           
                            Estados.valueOf(rs.getString("estado"))
                            )
                            
                            ,
                            rs.getString("descripcion"),
                            rs.getDate("fechaAsignacion"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoServicio.valueOf(rs.getString("estadoServicio"))
                              )
                            
                   );
           } catch (SQLException se) {
            
            throw new DAOException("Error creando solicitud en DAO", se);
        }
    }

    @Override
    public Servicio[] leertodo() throws DAOException {
        try  {
             CallableStatement st=con.prepareCall("{call sp_servicio_all()}");
           
              ResultSet rs = st.executeQuery();
                      
            ArrayList<Servicio> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                      new Servicio(
                            rs.getInt("idServicio"),
                      new Solicitud(  
                              rs.getInt("idSolicitud"),
                     new Cliente(
                            rs.getInt("idCliente"),
                            rs.getString("ruc"),
                            rs.getString("razonsocial"),
                            
                            rs.getInt("idPersona1"),
                            rs.getString("nombre1"),
                            rs.getString("apellido1"),
                            rs.getString("dni1"),
                            rs.getString("direccion1"),
                            rs.getString("telefono1"),
                            rs.getString("email1"),
                            Estados.valueOf(rs.getString("estado1"))
                           
                     ),
                              rs.getString("descripcion1"),
                              rs.getDate("fecha"),
                              rs.getString("observacion"),
                              EstadoSolicitud.valueOf(rs.getString("estadoSolicitud"))
                      ),
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
                            Estados.valueOf(rs.getString("estado2"))
                      
                      ), 
                            new TipoServicio (
                                     rs.getInt("idTipoServicio"),
                            rs.getString("descripcion"),
                           
                            Estados.valueOf(rs.getString("estado"))
                            )
                            
                            ,
                            rs.getString("descripcion"),
                            rs.getDate("fechaAsignacion"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoServicio.valueOf(rs.getString("estadoServicio"))
                              )
                            
                   );
            }
            return tribs.toArray(new Servicio[0]);
        } catch (SQLException se) {
            
            throw new DAOException("Error obteniedo todos las solicitudes en DAO: " 
                    + se.getMessage(), se);
        }  
    }
	
    }
    

