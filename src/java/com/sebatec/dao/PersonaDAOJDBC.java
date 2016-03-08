/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Estados;
import com.sebatec.modelo.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

/**
 *
 * @author Mi Laptop
 */
public class PersonaDAOJDBC implements PersonaDAO{
   private final Connection con;
	//crear la conecion
	    public PersonaDAOJDBC() {
	        this.con = DBManager.getConnection();
	    }
	    ///coneccion
	@Override
	public boolean crear(Persona objper) throws DAOException {
		 try 
	        {
	            
            CallableStatement st=con.prepareCall("{call sp_persona_n(?,?,?,?,?,?,?,?,?)}");
            
           
                            st.setString(1,objper.getNombre());
                            st.setString(2,objper.getApellido());
	                    st.setString(3,objper.getDni());
	                    st.setString(4,objper.getRazon());
	                    st.setString(5,objper.getRuc());
	                    st.setString(6,objper.getDireccion());
	                    st.setString(7,objper.getTelefono());
	                    st.setString(8,objper.getEmail());
	                    st.setString(9,objper.getEstado().name());
	                    		
	            
	            if (st.execute()) //devuelve verdadero si fallo
            {
               throw new DAOException("Error creando persona");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo persona en DAO", se);
        }
        return true;
	}

	@Override
	public boolean modificar(Persona objper) throws DAOException {
		  try {

            
            CallableStatement st=con.prepareCall("{call sp_persona_m(?,?,?,?,?,?,?,?,?,?)}");
            
	                     st.setInt(1,objper.getIdPersona());
                             st.setString(2,objper.getNombre());
                            st.setString(3,objper.getApellido());
	                    st.setString(4,objper.getDni());
	                    st.setString(5,objper.getRazon());
	                    st.setString(6,objper.getRuc());
	                    st.setString(7,objper.getDireccion());
	                    st.setString(8,objper.getTelefono());
	                    st.setString(9,objper.getEmail());
	                    st.setString(10,objper.getEstado().name());
	                    
	                if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando persona");
            }
            st.close();
            
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo persona en DAO", se);
        }
        return (true);
	}

	@Override
	public boolean eliminar(int idPersona) throws DAOException {
		  try {

            
            CallableStatement st=con.prepareCall("{call sp_persona_e(?) }");
            
            st.setInt(1,idPersona);


            if (st.execute()) //devuelve verdadero si fallo
            {
                throw new DAOException("Error modificando persona");
            }
            st.close();
            
        } catch (SQLException se) {
            throw new DAOException("Error añadiendo persona en DAO", se);
        }
        return true;
   
	}

	@Override
	public Persona leerxid(int idPersona) throws DAOException {
            try{
	CallableStatement st=con.prepareCall("{call sp_persona_bco(?)}");
            st.setInt(1,idPersona);
              ResultSet rs = st.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return (
                    new Persona(
                            rs.getInt("idPersona"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("dni"),
                            rs.getString("razon"),
                            rs.getString("ruc"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            Estados.valueOf(rs.getString("estado")))
                    );
        } catch (SQLException se) {
            
            throw new DAOException("Error buscando persona en DAO", se);
        }
	}

	@Override
	public Persona[] leertodo() throws DAOException {
		try  {
            CallableStatement stm=con.prepareCall("{call sp_persona_all}");
            ResultSet rs=stm.executeQuery();
                      
            ArrayList<Persona> tribs = new ArrayList<>(); 
            
            while (rs.next()) {
                tribs.add(
                        
                        new Persona(
                        		 rs.getInt("idPersona"),
                                 rs.getString("nombre"),
                                 rs.getString("apellido"),
                                 rs.getString("dni"),
                                 rs.getString("razon"),
                                 rs.getString("ruc"),
                                 rs.getString("direccion"),
                                 rs.getString("telefono"),
                                 rs.getString("email"),
                                 Estados.valueOf(rs.getString("estado")))
                        
                
                );
            }
            return tribs.toArray(new Persona[0]);
        } catch (SQLException se) {
            //se.printStackTrace();
            throw new DAOException("Error obteniedo todos los persona en DAO: " 
                    + se.getMessage(), se);
        }   
	}

}
