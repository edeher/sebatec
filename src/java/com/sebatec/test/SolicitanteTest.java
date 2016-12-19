/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.factory.SolicitanteDAOFactory;
import com.sebatec.dao.interfaces.TecnicoDAO;
import com.sebatec.dao.factory.TecnicoDAOFactory;
import com.sebatec.dao.interfaces.SolicitanteDAO;
import com.sebatec.enums.TipoUsuario;

import com.sebatec.modelo.Tecnico;
import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Solicitante;


/**
 *
 * @author Mi Laptop
 */
public class SolicitanteTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws DAOException{
        // TODO code application logic here
//        crearSolicitante();
//        modificarsolicitante();
//        eliminarsolicitante();
//        leersolicitante();
        leertodo();
//        validar();
    }
    public static void crearSolicitante() throws DAOException
	{
		SolicitanteDAOFactory fabricate= new SolicitanteDAOFactory();
		SolicitanteDAO daote= fabricate.metodoDAO();
                  
		Solicitante soli= new Solicitante();
                 
                 
                soli.setNombre("edeher");
		 soli.setApellido("nuevo ponce");
		soli.setDni("77777775");
		 soli.setDireccion("dfdgfdg");
		soli.setTelefono("546546");
		 soli.setEmail("fsdfdfsdsdf");
		
		
               soli.getEmpresa().setRazon("amor");
                soli.getEmpresa().setRuc("11100022233");
                soli.getEmpresa().setDireccion("alla");
                soli.setCargo("secre");
                
                
                
		 
		Solicitante solicitante= daote.crear(soli);
		   
		System.out.println("tecnico "+solicitante.toString());
		}
	public static void modificarsolicitante()throws DAOException
	{
		SolicitanteDAOFactory fabricate= new SolicitanteDAOFactory();
		SolicitanteDAO daote= fabricate.metodoDAO();
                  
		Solicitante soli= new Solicitante();
                
                soli.setIdSolicitante(3);
                
                 soli.setNombre("eeeeee ");
		 soli.setApellido("nuevo ponceccccccc");
		soli.setDni("46546545");
		 soli.setDireccion("dfdgfdg");
		 soli.setTelefono("546546");
		soli.setEmail("fsdfdfsdsdf");
                
                soli.setCargo("secre");
		 
              
                
		 
		Solicitante solicitante= daote.modificar(soli);
		   
		System.out.println("tecnico "+solicitante.toString());
                
	    
	}
	public static void eliminarsolicitante()throws DAOException
	{
		SolicitanteDAOFactory fabricate= new SolicitanteDAOFactory();
		SolicitanteDAO daote= fabricate.metodoDAO();
                  
		Solicitante soli= new Solicitante();
                soli.setIdSolicitante(26);
                
	 daote.eliminar(soli);
	 System.out.println("se elimino correctamente");
	    
	}
	public static void leersolicitante()throws DAOException
	{
		SolicitanteDAOFactory fabricate= new SolicitanteDAOFactory();
		 SolicitanteDAO daote= fabricate.metodoDAO();
	 Solicitante soli=new Solicitante();
        soli.setIdSolicitante(16);
                 
	   Solicitante solicitante=daote.leerxid(soli);
	 System.out.println(" "+solicitante.toString());
	    
	}
	public static void leertodo()throws DAOException
	{
		SolicitanteDAOFactory fabricate= new SolicitanteDAOFactory();
		SolicitanteDAO daote= fabricate.metodoDAO();
	 
	  Solicitante[] soli=daote.leertodo();
	  
	  for(Solicitante solicitante:soli)
	  {
	      
	      System.out.println(" "+solicitante.toString());
	  
	  }
	 
        } 
        

}
