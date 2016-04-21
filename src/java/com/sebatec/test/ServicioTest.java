/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.DAOException;
import com.sebatec.dao.ServicioDAO;
import com.sebatec.dao.ServicioDAOFactory;
import com.sebatec.modelo.EstadoSev;
import com.sebatec.modelo.Estados;
import com.sebatec.modelo.Servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 *
 * @author Mi Laptop
 */
public class ServicioTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException{
//        crearservicio();
//        modificarservicio();
//        eliminarservicio();
//        leerservicio();
//        leertodo();
        leerxidLista();
//        leerssidtecnicoLista();
//       crearLeer();
//        modificarLeer();
        
    }
    public static void crearservicio() throws DAOException
	{
		 ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
                  

                    int idSolicitud=1;
                    int idTecnico=1;
                          
                 
		Servicio servi= new Servicio();
		
                servi.setDescripcion("se arreglo por eso ja");
                
                servi.setMonto(25.25);
               
                
		 
		 daote.crear(servi,idSolicitud,idTecnico);
		  
		
		}
	public static void modificarservicio()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
		  
                 
                      int idSolicitud=1;
                    int idTecnico=1;            
		 Servicio servi= new Servicio();
                 servi.setIdServicio(9);
		 
                 servi.setDescripcion("se arreglo porrr ");
                 
                 servi.setMonto(25.25);
                 servi.setEstado(EstadoSev.C);
		 
		 daote.modificar(servi,idSolicitud,idTecnico);
                
	    
	}
	public static void eliminarservicio()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
	 
	 if(daote.leerxid(8)==null)
	 {
	     System.out.println("no existe un servicio con el codigo "+9 +" en la base de datos");
	 }
	 else
	 {
	 daote.eliminar(8);
	 System.out.println("se elimino correctamente");
	 }
	    
	}
	public static void leerservicio()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
	 
	   Servicio per=daote.leerxid(14);
	 System.out.println(" "+per.toString());
	    
	}
	public static void leertodo()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
	 
	  Servicio[] perv=daote.leertodo();
	  
	  for(Servicio perv1:perv)
	  {
	      
	      System.out.println(" "+perv1.toString());
	  
	  }
	 
	 
	    
	}
        public static void leerxidLista()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
	 
	  Servicio[] perv=daote.leerxxid(3);
	  
	  for(Servicio perv1:perv)
	  {
	      
	      System.out.println(" "+perv1.toString());
	  
	  }
	 
	}
        public static void leerssidtecnicoLista()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
	 
	  Servicio[] perv=daote.leerTodoTecnico(3);
	  
	  for(Servicio perv1:perv)
	  {
	      
	      System.out.println(" "+perv1.toString());
	  
	  }
	 
	}
        public static void crearLeer()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
                  Servicio servi= new Servicio();
                
		 servi.getSolicitud().setIdSolicitud(1);
                 servi.getTecnico().setIdTecnico(3);
                 servi.setDescripcion("se arreglo porrr no queria");
                
	  Servicio per=daote.crearLeer(servi);
	 System.out.println(" "+per.toString());
	 
	}
        public static void modificarLeer()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
                 Servicio servi= new Servicio();
                 servi.setIdServicio(15);
		 servi.getTecnico().setIdTecnico(3);
                 servi.setDescripcion("se arreglo porrr no queria");
                 servi.setMonto(25.5);
                 servi.setEstado(EstadoSev.C);
                
	  Servicio per=daote.modificarLeer(servi);
	 System.out.println(" "+per.toString());
	 
	}
}
