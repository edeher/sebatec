/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;


import com.sebatec.modelo.Cliente;
import com.sebatec.modelo.EstadoSo;
import com.sebatec.modelo.Estados;
import com.sebatec.modelo.Solicitud;
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
public class SolicitudDAOJDBC implements SolicitudDAO{
 private final Connection con;
	//crear la conecion
	    public SolicitudDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }
	    ///coneccion
    public boolean crear(Solicitud objsoli) throws DAOException {
        try  
	        {
	          CallableStatement st=con.prepareCall("{call sp_solicitud_n(?,?,?,?,?,?,?,?,?,?)}");
	                   
                            st.setString(1,objsoli.getCliente().getNombre());
                            st.setString(2,objsoli.getCliente().getApellido());
                            st.setString(3,objsoli.getCliente().getDni());
                            st.setString(4, objsoli.getCliente().getRazon());
                            st.setString(5, objsoli.getCliente().getRuc());
                            st.setString(6, objsoli.getCliente().getDireccion());
                            st.setString(7, objsoli.getCliente().getTelefono());
	                    st.setString(8, objsoli.getCliente().getEmail());
	                   
	                     st.setString(9 ,objsoli.getDescripcion());
	                     st.setString(10,objsoli.getObservacion());
	                     
	            
	            if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando solicitud");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo solicitud en DAO", se);
        }
        return true;
    
    }

    @Override
    public boolean modificar(Solicitud objsoli) throws DAOException {
        try  {
	            
	          CallableStatement st=con.prepareCall("{call sp_solicitud_m(?,?,?,?)}");
	                   st.setInt(1,objsoli.getIdSolicitud());
	                    st.setInt(2,objsoli.getCliente().getIdCliente());
	                     st.setString(3 ,objsoli.getDescripcion());
	                     st.setString(4,objsoli.getObservacion());
	                    
	            
	            if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando solicitud");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo solicitud en DAO", se);
        }
        return (true);
    }

    @Override
    public boolean eliminar(int idSolicitud) throws DAOException {
    try  {
	             CallableStatement st=con.prepareCall("{call sp_solicitud_e(?) }");
            
            st.setInt(1,idSolicitud);


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando solicitud");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo solicitud en DAO", se);
        }
        return true; 
    }

    @Override
    public Solicitud leerxid(int idSolicitud) throws DAOException {
    try  {
           CallableStatement st=con.prepareCall("{call sp_solicitud_bco(?)}");
            st.setInt(1,idSolicitud);
              ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                    new Solicitud(
                            rs.getInt("idSolicitud"),
                            new Cliente(
                            rs.getString("nombre")),
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            EstadoSo.valueOf(rs.getString("estado"))
                            )
                    );
        } catch (SQLException se) {
            
            throw new DAOException("Error buscando solicitud en DAO", se);
        }
    }

    @Override
    public Solicitud[] leertodo() throws DAOException {
     try  {
            CallableStatement stm=con.prepareCall("{call sp_solicitud_all}");
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<Solicitud> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                        
                        new Solicitud(
                            rs.getInt("idSolicitud"),
                            new Cliente(
                            rs.getString("nombre")),
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            EstadoSo.valueOf(rs.getString("estado"))
                            )
                    );
            }
            return tribs.toArray(new Solicitud[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos las solicitudes en DAO: " 
                    + se.getMessage(), se);
        }   
    }

    @Override
    public boolean crear(Solicitud objsoli, int idCliente) throws DAOException {
     try  
	        {
	          CallableStatement st=con.prepareCall("{call sp_solicitud_n(?,?,?,?)}");
	                   
                            st.setInt(1, idCliente);
	                   
                             
	                     st.setString(2 ,objsoli.getDescripcion());
	                     st.setString(3,objsoli.getObservacion());
	                     st.setString(4,objsoli.getEstado().name());
	            
	            if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando solicitud");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo solicitud en DAO", se);
        }
        return true;     
    }

    @Override
    public Solicitud[] leertodo(int idCliente) throws DAOException {
        try  {
            CallableStatement stm=con.prepareCall("{call sp_solicitud_all2(?)}");
            stm.setInt(1,idCliente);
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<Solicitud> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                        
                        new Solicitud(
                            rs.getInt("idSolicitud"),
                            new Cliente(
                            rs.getString("nombre")),
                            rs.getString("descripcion"),
                            rs.getString("observacion"),
                            EstadoSo.valueOf(rs.getString("estado"))
                            )
                    );
            }
            return tribs.toArray(new Solicitud[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos las solicitudes en DAO: " 
                    + se.getMessage(), se);
        }   
    }
    
}
