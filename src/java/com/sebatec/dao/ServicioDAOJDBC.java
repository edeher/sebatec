/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Estados;
import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Servicio;
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
    public boolean crear(Servicio objservi) throws DAOException {
        try 
	        {
                            CallableStatement st=con.prepareCall("{call sp_servicio_n(?,?,?,?,?,?,?)}");
                            st.setInt(1,objservi.getIdSolicitud());
	                    st.setInt(2,objservi.getIdTecnico());
	                    st.setString(3,objservi.getDescripcion());
	                    st.setDate(4,new java.sql.Date(objservi.getFechaEmimsion().getTime()));
	                    st.setDate(5,new java.sql.Date(objservi.getFechaGestion().getTime()));
	                    st.setDouble(6,objservi.getMonto());
	                    st.setString(7,objservi.getEstado().name());
	            
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
    public boolean modificar(Servicio objservi) throws DAOException {
       try  {
	           CallableStatement st=con.prepareCall("{call sp_servicio_m(?,?,?,?,?,?,?,?)}");
	                    st.setInt(1,objservi.getIdServicio());
                            st.setInt(2,objservi.getIdSolicitud());
	                    st.setInt(3,objservi.getIdTecnico());
	                    st.setString(4,objservi.getDescripcion());
	                    st.setDate(5,new java.sql.Date(objservi.getFechaEmimsion().getTime()));
	                    st.setDate(6,new java.sql.Date(objservi.getFechaGestion().getTime()));
	                    st.setDouble(7,objservi.getMonto());
	                    st.setString(8,objservi.getEstado().name());
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
                            rs.getInt("idSolicitud"),
                            rs.getInt("idTecnico"),
                            rs.getString("descripcion"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            Estados.valueOf(rs.getString("estado"))
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
                            rs.getInt("idSolicitud"),
                            rs.getInt("idTecnico"),
                            rs.getString("descripcion"),
                            rs.getDate("fechaEmision"),
                            rs.getDate("fechaGestion"),
                            rs.getDouble("monto"),
                            Estados.valueOf(rs.getString("estado"))
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
    
}
