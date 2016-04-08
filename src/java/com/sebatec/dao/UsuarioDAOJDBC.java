/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Estados;
import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Solicitud;
import com.sebatec.modelo.Usuario;
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
public class UsuarioDAOJDBC implements UsuarioDAO{
//crear la conecion
    private final Connection con;
	    public UsuarioDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }
	    ///coneccion
    @Override
    public boolean crear(Usuario objusu, int idPersona) throws DAOException {
        try 
	        {
	           CallableStatement st=con.prepareCall("{call sp_usuario_n(?,?,?,?)}");
	                   
	                    st.setInt(1,idPersona);
	                    st.setString(2,objusu.getUsuario());
	                    st.setString(3,objusu.getPassword());
                            st.setString(4,objusu.getTipo());
	                   
	           if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando usuario");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo usuario en DAO", se);
        }
        return true;
    }
@Override
    public boolean crear(Usuario objusu, Persona objper) throws DAOException {
        try 
	        {
	           CallableStatement st=con.prepareCall("{call sp_usuario_n1(?,?,?,?,?,?,?,?,?)}");
	                   
	                     st.setString(1,objper.getNombre());
                            st.setString(2,objper.getApellido());
                            st.setString(3,objper.getDni());
                            st.setString(6, objper.getDireccion());
                            st.setString(7, objper.getTelefono());
	                    st.setString(8, objper.getEmail());
                            
                            
	                    st.setString(9,objusu.getUsuario());
	                    st.setString(10,objusu.getPassword());
                            st.setString(11,objusu.getTipo());
	                    
	            
	            
	           if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando usuario");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo usuario en DAO", se);
        }
        return true;
    }
    @Override
    public boolean modificar(Usuario objusu,Persona objper) throws DAOException {
       try  {
	              CallableStatement st=con.prepareCall("{call sp_usuario_m(?,?,?,?,?,?,?,?,?,?)}");
	                   st.setInt(1,objusu.getIdUsuario());
                            st.setString(2,objper.getNombre());
                            st.setString(3,objper.getApellido());
                            st.setString(4,objper.getDni());
                            st.setString(7, objper.getDireccion());
                            st.setString(8, objper.getTelefono());
	                    st.setString(9, objper.getEmail());
                            
	                    st.setString(10,objusu.getUsuario());
	                    st.setString(11,objusu.getPassword());
                             st.setString(12,objusu.getTipo());
	            
	            
	           if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando usuario");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo usuario en DAO", se);
        }
        return true;
    }

    @Override
    public boolean eliminar(int idUsuario) throws DAOException {
         try  {
	           CallableStatement st=con.prepareCall("{call sp_usuario_e(?) }");
            
            st.setInt(1,idUsuario);


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando usuario");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo usuario en DAO", se);
        }
        return true; 
    }

    @Override
    public Usuario leerxid(int idUsuario) throws DAOException {
         try  {
            CallableStatement st=con.prepareCall("{call sp_usuario_bco(?)}");
            st.setInt(1,idUsuario);
              ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
           
            return (
                    new Usuario(
                            rs.getInt("idUsuario"),
                           new Persona(
                                   rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("dni"),
                                    
                                     rs.getString("direccion"),
                                    rs.getString("telefono"),
                                    rs.getString("email")                           
                           ),
                            rs.getString("usuario"),
                            rs.getString("clave"),
                            rs.getString("tipo"))
                   );
        } catch (SQLException se) {
            
            throw new DAOException("Error buscando usuaio en DAO", se);
        }
    }

    @Override
    public Usuario[] leertodo() throws DAOException {
        try  {
             CallableStatement stm=con.prepareCall("{call sp_usuario_all}");
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<Usuario> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                        
                      new Usuario(
                            rs.getInt("idUsuario"),
                             new Persona(
                                   rs.getString("nombre"),
                                    rs.getString("apellido"),
                                    rs.getString("dni"),
                                   
                                     rs.getString("direccion"),
                                    rs.getString("telefono"),
                                    rs.getString("email")                           
                           ),
                            rs.getString("usuario"),
                            rs.getString("clave"),
                            rs.getString("tipo"))
                        
                
                  );
            }
            return tribs.toArray(new Usuario[0]);
        } catch (SQLException se) {
            
            throw new DAOException("Error obteniedo todos los usuarios en DAO: " 
                    + se.getMessage(), se);
        }   
    }
    
}
