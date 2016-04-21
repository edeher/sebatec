/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.EstadoSev;
import com.sebatec.modelo.EstadoSo;
import com.sebatec.modelo.Estados;
import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Servicio;
import com.sebatec.modelo.Solicitud;
import com.sebatec.modelo.Tecnico;
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
	    ///coneccion
    @Override
    public boolean crear(Servicio objservi,int idSolicitud,int idTecnico) throws DAOException {
        try 
	        {
                            CallableStatement st=con.prepareCall("{call sp_servicio_n(?,?,?,?)}");
                            st.setInt(1,idSolicitud);
	                    st.setInt(2, idTecnico);
	                    st.setString(3,objservi.getDescripcion());
	                    
	                    st.setDouble(4,objservi.getMonto());
	                    
	            
	            if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando servicio");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo servicio en DAO", se);
        }
        return true;
    }

    @Override
    public boolean modificar(Servicio objservi,int idSolicitud, int idTecnico) throws DAOException {
       try  {
	           CallableStatement st=con.prepareCall("{call sp_servicio_m(?,?,?,?,?,?)}");
	                    st.setInt(1,objservi.getIdServicio());
                            st.setInt(2,idSolicitud);
	                    st.setInt(3,idTecnico);
	                    st.setString(4,objservi.getDescripcion());
	                   
	                    st.setDouble(5,objservi.getMonto());
	                    st.setString(6,objservi.getEstado().name());
	            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando servicio");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo servicio en DAO", se);
        }
        return (true);
    }

    @Override
    public boolean eliminar(int idServicio) throws DAOException {
       try  {
	            CallableStatement st=con.prepareCall("{call sp_servicio_e(?) }");
            
            st.setInt(1,idServicio);


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando servicio");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo servicio en DAO", se);
        }
        return true;
    }

    @Override
    public Servicio leerxid(int idServicio) throws DAOException {
       try  {
            CallableStatement st=con.prepareCall("{call sp_servicio_bco(?)}");
            st.setInt(1,idServicio);
              ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return (
                    new Servicio(
                            rs.getInt("idServicio"),
                            new Solicitud(
                            rs.getInt("idSolicitud"),       
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            EstadoSo.valueOf(rs.getString("estado"))
                            ),
                                 
                            new Tecnico(
                             rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                             rs.getString("especialidad"),
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email")
                            ),
                                 
                            rs.getString("descripcion1"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoSev.valueOf(rs.getString("estado1"))
                    )
                     );
        } catch (SQLException se) {
            
            throw new DAOException("Error buscando servicio en DAO", se);
        }
    }

    @Override
    public Servicio[] leertodo() throws DAOException {
       try  {
             CallableStatement stm=con.prepareCall("{call sp_servicio_all}");
             
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<Servicio> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                         new Servicio(
                            rs.getInt("idServicio"),
                            new Solicitud(
                            rs.getInt("idSolicitud"),       
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            EstadoSo.valueOf(rs.getString("estado"))
                            ),
                                 
                            new Tecnico(
                             rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                             rs.getString("especialidad"),
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email")
                            ),
                                 
                            rs.getString("descripcion1"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoSev.valueOf(rs.getString("estado1"))
                    )
                     );
            }
            return tribs.toArray(new Servicio[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los servicios en DAO: " 
                    + se.getMessage(), se);
        }   
    }

    @Override
    public Servicio[] leerxxid(int idServicio) throws DAOException {
        try  {
             CallableStatement stm=con.prepareCall("{call sp_servicio_bco(?)}");
             stm.setInt(1,idServicio);
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<Servicio> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                         new Servicio(
                            rs.getInt("idServicio"),
                            new Solicitud(
                            rs.getInt("idSolicitud"),       
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            EstadoSo.valueOf(rs.getString("estado"))
                            ),
                                 
                            new Tecnico(
                             rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                             rs.getString("especialidad"),
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email")
                            ),
                                 
                            rs.getString("descripcion1"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoSev.valueOf(rs.getString("estado1"))
                    )
                     );
            }
            return tribs.toArray(new Servicio[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los servicios en DAO: " 
                    + se.getMessage(), se);
        }   
    }

    @Override
    public Servicio[] leerTodoTecnico(int idTecnico) throws DAOException {
        try  {
             CallableStatement stm=con.prepareCall("{call sp_servicio_bco2(?)}");
             stm.setInt(1,idTecnico);
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<Servicio> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                         new Servicio(
                            rs.getInt("idServicio"),
                            new Solicitud(
                            rs.getInt("idSolicitud"),       
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            EstadoSo.valueOf(rs.getString("estado"))
                            ),
                                 
                            new Tecnico(
                             rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                             rs.getString("especialidad"),
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email")
                            ),
                                 
                            rs.getString("descripcion1"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoSev.valueOf(rs.getString("estado1"))
                    )
                     );
            }
            return tribs.toArray(new Servicio[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los servicios en DAO: " 
                    + se.getMessage(), se);
        }   
    }

    @Override
    public Servicio crearLeer(Servicio objSer) throws DAOException {
       try  {
            CallableStatement st=con.prepareCall("{call sp_servicio_n1(?,?,?)}");
            st.setInt(1,objSer.getSolicitud().getIdSolicitud());
            st.setInt(2,objSer.getTecnico().getIdTecnico());
            st.setString(3,objSer.getDescripcion());
              ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return (
                    new Servicio(
                            rs.getInt("idServicio"),
                            new Solicitud(
                            rs.getInt("idSolicitud"),       
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            EstadoSo.valueOf(rs.getString("estado"))
                            ),
                                 
                            new Tecnico(
                             rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                             rs.getString("especialidad"),
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email")
                            ),
                                 
                            rs.getString("descripcion1"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoSev.valueOf(rs.getString("estado1"))
                    )
                     );
        } catch (SQLException se) {
            
            throw new DAOException("Error buscando servicio en DAO", se);
        }
    }

    @Override
    public Servicio modificarLeer(Servicio objSer) throws DAOException {
        
    try  {
            CallableStatement st=con.prepareCall("{call sp_servicio_m2(?,?,?,?,?)}");
             st.setInt(1,objSer.getIdServicio());
             st.setInt(2,objSer.getTecnico().getIdTecnico());
             st.setString(3,objSer.getDescripcion());
            st.setDouble(4,objSer.getMonto());
            st.setString(5,objSer.getEstado().name());
                       
              ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return (
                    new Servicio(
                            rs.getInt("idServicio"),
                            new Solicitud(
                            rs.getInt("idSolicitud"),       
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            EstadoSo.valueOf(rs.getString("estado"))
                            ),
                                 
                            new Tecnico(
                             rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                             rs.getString("especialidad"),
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email")
                            ),
                                 
                            rs.getString("descripcion1"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            EstadoSev.valueOf(rs.getString("estado1"))
                    )
                     );
        } catch (SQLException se) {
            
            throw new DAOException("Error buscando servicio en DAO", se);
        }
    }
    
}
