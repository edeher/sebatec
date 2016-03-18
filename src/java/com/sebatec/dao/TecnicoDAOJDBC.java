/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Estados;
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
	    ///coneccion
    @Override
    public boolean crear(Tecnico objtec) throws DAOException {
        try  
	        {
	           CallableStatement st=con.prepareCall("{call sp_tecnico_n(?,?,?,?,?,?,?,?,?,?)}");
	                   
	                    st.setString(1,objtec.getNombre());
                            st.setString(2,objtec.getApellido());
                            st.setString(3,objtec.getDni());
                            st.setString(4, objtec.getRazon());
                            st.setString(5, objtec.getRuc());
                            st.setString(6, objtec.getDireccion());
                            st.setString(7, objtec.getTelefono());
	                    st.setString(8, objtec.getEmail());
                            st.setString(9, objtec.getProfesion());
	                     st.setString(10,objtec.getEspecialidad());
	                    
	            
	            
	           if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando tecnico");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo tecnico en DAO", se);
        }
        return (true);
    }

    @Override
    public boolean modificar(Tecnico objtec) throws DAOException {
        try  {
	           
	           CallableStatement st=con.prepareCall("{call sp_tecnico_m(?,?,?,?,?,?,?,?,?,?,?)}");
	                   st.setInt(1,objtec.getIdTecnico());
	                    st.setString(2,objtec.getNombre());
                            st.setString(3,objtec.getApellido());
                            st.setString(4,objtec.getDni());
                            st.setString(5, objtec.getRazon());
                            st.setString(6, objtec.getRuc());
                            st.setString(7, objtec.getDireccion());
                            st.setString(8, objtec.getTelefono());
	                    st.setString(9, objtec.getEmail());
                            st.setString(10, objtec.getProfesion());
	                     st.setString(11,objtec.getEspecialidad());
	            
	           if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando tecnico");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo tecnico en DAO", se);
        }
        return true;
    
    }

    @Override
    public boolean eliminar(int idTecnico) throws DAOException {
        try  {
	               CallableStatement st=con.prepareCall("{call sp_tecnico_e(?) }");
            
            st.setInt(1,idTecnico);


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando tecnico");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo tecnico en DAO", se);
        }
        return true; 
    }

    @Override
    public Tecnico leerxid(int idTecnico) throws DAOException {
         try  {
            CallableStatement st=con.prepareCall("{call sp_tecnico_bco(?)}");
            st.setInt(1,idTecnico);
              ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                    new Tecnico(
                             rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                             rs.getString("especialidad"),
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("razon"),
                             rs.getString("ruc"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email")
                             
                             )
                           
                     );
        } catch (SQLException se) {
            
            throw new DAOException("Error buscando tecnico en DAO", se);
        }
    }

    @Override
    public Tecnico[] leertodo() throws DAOException {
         try  {
            CallableStatement stm=con.prepareCall("{call sp_tecnico_all}");
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<Tecnico> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                       new Tecnico(
                             rs.getInt("idTecnico"),
                            rs.getString("profesion"),
                             rs.getString("especialidad"),
                             rs.getString("nombre"),
                             rs.getString("apellido"),
                             rs.getString("dni"),
                             rs.getString("razon"),
                             rs.getString("ruc"),
                             rs.getString("direccion"),
                             rs.getString("telefono"),
                             rs.getString("email")
                             
                             )
                        
                );
            }
            return tribs.toArray(new Tecnico[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos las tecnicos en DAO: " 
                    + se.getMessage(), se);
        }   
    }
    
}
