/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.DAOException;

import com.sebatec.dao.SolicitudDAO;
import com.sebatec.dao.SolicitudDAOFactory;

import com.sebatec.modelo.Solicitud;



/**
 *
 * @author Mi Laptop
 */
public class SolicitudTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException{
        // TODO code application logic here
    //    crearsolicitud();
  //      modificarsolicitud();
      //  eliminarsolicitud();
   //     leersolicitud();
        leertodo();
    }
    public static void crearsolicitud() throws DAOException
	{
		 SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
                
		Solicitud soli= new Solicitud();
		soli.setIdPersona(1);
                soli.setDescripcion("aca pes ");
                soli.setObservacion("ddfgdfg");
                soli.setEstado(true);
                
		 
		 daote.crear(soli);
		   
		
		}
	public static void modificarsolicitud()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
		 
		 Solicitud soli= new Solicitud();
                 soli.setIdSolicitud(1);
		soli.setIdPersona(1);
                soli.setDescripcion("aca pes pes");
                soli.setObservacion("ddfgdfg");
                soli.setEstado(true);
		 
		 daote.modificar(soli);
                 
	    
	}
	public static void eliminarsolicitud()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
	 
	 if(daote.leerxid(11)==null)
	 {
	     System.out.println("no existe un servicio con el codigo "+9 +" en la base de datos");
	 }
	 else
	 {
	 daote.eliminar(11);
	 System.out.println("se elimino correctamente");
	 }
	    
	}
	public static void leersolicitud()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
	 
	   Solicitud per=daote.leerxid(3);
	 System.out.println(" "+per.toString());
	    
	}
	public static void leertodo()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
	 
	  Solicitud[] perv=daote.leertodo();
	  
	  for(int i=0; i<perv.length;i++)
	  {
	      
	      System.out.println(" "+perv[i].toString());
	  
	  }
	 
	 
	    
	}
}
