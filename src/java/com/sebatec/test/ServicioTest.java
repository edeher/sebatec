/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.interfaces.ServicioDAO;
import com.sebatec.dao.factory.ServicioDAOFactory;
import com.sebatec.enums.EstadoServicio;

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
        leertodo();

        
    }
    public static void crearservicio() throws DAOException
	{
		 ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
                  
                 Servicio ser=new Servicio();
                 ser.getSolicitud().setIdSolicitud(7);
                 ser.getTecnico().setIdTecnico(16);
                 ser.getTiposervicio().setIdTipoServicio(15);
                 ser.setDescripcion("atender de inmediato");
                          
                             
                
		 
		Servicio servi= daote.crear(ser);
		  
		          System.out.println("servicio :"+servi.toString());
		}
	public static void modificarservicio()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
		  
                  Servicio ser=new Servicio();
                 ser.setIdServicio(21);
                 ser.getTecnico().setIdTecnico(15);
                 ser.getTiposervicio().setIdTipoServicio(15);
                 ser.setDescripcion("atender de inmediato apura ya");
                 ser.setMonto(60);
                 ser.setEstadoservicio(EstadoServicio.AS);
                          
                             
                
		 
		Servicio servi= daote.modificar(ser);
		  
		          System.out.println("servicio :"+servi.toString());
	    
	}
	public static void eliminarservicio()throws DAOException
	{
	ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
                 
                   Servicio Soli= new   Servicio();
		 Soli.setIdServicio(22);
                
	 daote.eliminar(Soli);
	 System.out.println("se elimino correctamente");
	    
	}
	public static void leerservicio()throws DAOException
	{
		ServicioDAOFactory fabricate= new ServicioDAOFactory();
		 ServicioDAO daote= fabricate.metodoDAO();
                 Servicio ser=new Servicio();
                 ser.setIdServicio(21);
                 
	 
	   Servicio per=daote.leerxid(ser);
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
//        
}
