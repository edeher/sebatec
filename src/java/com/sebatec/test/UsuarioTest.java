/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.DAOException;

import com.sebatec.dao.UsuarioDAO;
import com.sebatec.dao.UsuarioDAOFactory;
import com.sebatec.modelo.Estados;
import com.sebatec.modelo.Usuario;



public class UsuarioTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws DAOException {
        // TODO code application logic here
//        crearusuario();
//        modificarusuario();
      //  eliminarusuario();
//        leerusuario();
        leertodo();
        
    }
    public static void crearusuario() throws DAOException
	{
		 UsuarioDAOFactory fabricate= new UsuarioDAOFactory();
		 UsuarioDAO daote= fabricate.metodoDAO();
                  
		Usuario usu= new Usuario();
		usu.setIdTecnico(1);
                usu.setUsuario("edeher");
                usu.setPassword("1234");
                usu.setTipo("assd");
                usu.setEstado(Estados.A);           
		 
		 daote.crear(usu);
		   
		
		}
	public static void modificarusuario()throws DAOException
	{
		UsuarioDAOFactory fabricate= new UsuarioDAOFactory();
		 UsuarioDAO daote= fabricate.metodoDAO();
                  
		Usuario usu= new Usuario();
                usu.setIdUsuario(7);
                usu.setIdTecnico(1);
                usu.setUsuario("edeher ponce");
                usu.setPassword("1234");
                usu.setTipo("assd");
                usu.setEstado(Estados.A);
                		 
		 daote.modificar(usu);
                
	    
	}
	public static void eliminarusuario()throws DAOException
	{
		UsuarioDAOFactory fabricate= new UsuarioDAOFactory();
		 UsuarioDAO daote= fabricate.metodoDAO();
                  
		
	 
	 if(daote.leerxid(8)==null)
	 {
	     System.out.println("no existe un usuario con el codigo "+9 +" en la base de datos");
	 }
	 else
	 {
	 daote.eliminar(8);
	 System.out.println("se elimino correctamente");
	 }
	    
	}
	public static void leerusuario()throws DAOException
	{
		 UsuarioDAOFactory fabricate= new UsuarioDAOFactory();
		 UsuarioDAO daote= fabricate.metodoDAO();
                  
		 
	   Usuario tec=daote.leerxid(3);
	 System.out.println(" "+tec.toString());
	    
	}
	public static void leertodo()throws DAOException
	{
		 UsuarioDAOFactory fabricate= new UsuarioDAOFactory();
		 UsuarioDAO daote= fabricate.metodoDAO();
                  
		
	 
	  Usuario[] usuv=daote.leertodo();
	  
	  for(Usuario usuv1:usuv)
	  {
	      
	      System.out.println(" "+usuv1.toString());
	  
	  }
	 
        } 

}
