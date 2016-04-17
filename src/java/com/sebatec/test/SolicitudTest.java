/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.DAOException;

import com.sebatec.dao.SolicitudDAO;
import com.sebatec.dao.SolicitudDAOFactory;
import com.sebatec.modelo.Cliente;
import com.sebatec.modelo.EstadoSo;
import com.sebatec.modelo.Estados;

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
//        crearsolicitud();
//        modificarsolicitud();
      //  eliminarsolicitud();
//        leersolicitud();
//        leertodo();
//        leertodo2();
crearLEERsolicitud();
//crearLEERsolicitud2();
//modificarsolicitudleer();
modificarsolicitudleer2();
    }
    public static void crearsolicitud() throws DAOException
	{
		 SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
                
		Solicitud soli= new Solicitud();
		
                
                soli.getCliente().setNombre("pancracio");
                 soli.getCliente().setApellido("telesforo");
                soli.getCliente().setDni("45632112");
                 soli.getCliente().setRazonSocial("softponce");
                 soli.getCliente().setRuc("12345678978");
                 soli.getCliente().setDireccion("mi casita");
                 soli.getCliente().setTelefono("942154007");
                 soli.getCliente().setEmail("vpisistemas@unia.pe");
                
                
                
               
                soli.setDescripcion("aca pes ");
                soli.setObservacion("ddfgdfg");
                
                
		 
		 daote.crear(soli);
		   
		
		}
    public static void crearsolicitud2() throws DAOException
	{
		 SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
                
		Solicitud soli= new Solicitud();
		
                int idCliente=4;
               
               
                soli.setDescripcion("aca pes ");
                soli.setObservacion("ddfgdfg");
                
                
		 
		 daote.crear(soli,idCliente);
		   
		
		}
	public static void modificarsolicitud()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
		 
		 Solicitud soli= new Solicitud();
                 Cliente objCli= new Cliente();
                 objCli.setIdCliente(14);
                 
                soli.setIdSolicitud(14);
		soli.setCliente(objCli);
                soli.setDescripcion("aca pes pes solo se cambio este");
//                soli.setObservacion("ddfgdfg");
               
		 
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
	 
	  Solicitud[] solv=daote.leertodo();
	  
	  for(Solicitud solv1:solv )
	  {
	      
	      System.out.println(" "+solv1.toString());
	  
	  }
	 
	 
	    
	}
        public static void leertodo2()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
	 
	  Solicitud[] solv=daote.leertodo(1);
	  
	  for(Solicitud solv1:solv )
	  {
	      
	      System.out.println(" "+solv1.toString());
	  
	  }
	 
	 
	    
	}
          public static void crearLEERsolicitud() throws DAOException
	{
		 SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
                
		Solicitud soli= new Solicitud();
		
                
                soli.getCliente().setNombre("pancracio FUCIONADO");
                 soli.getCliente().setApellido("telesforo");
                soli.getCliente().setDni("45632112");
                 soli.getCliente().setRazonSocial("softponce");
                 soli.getCliente().setRuc("12345678978");
                 soli.getCliente().setDireccion("mi casita");
                 soli.getCliente().setTelefono("942154007");
                 soli.getCliente().setEmail("vpisistemas@unia.pe FUCIONADO");
                
                soli.setDescripcion("aca pes FUCIONADO");
                soli.setObservacion("ningunaw");
                
                	 
		 
		   Solicitud per=daote.crearLeer(soli);
	         System.out.println(" "+per.toString());
		
		}
          public static void crearLEERsolicitud2() throws DAOException
	{
		 SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
                
		Solicitud soli= new Solicitud();
		
                
                int idCliente=3;
                
                soli.setDescripcion("aca pes FUCIONADO");
                
                
                	 
		 
		   Solicitud per=daote.crearLeer(soli,idCliente);
	         System.out.println(" "+per.toString());
		
		}
          public static void modificarsolicitudleer()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
		 
		 Solicitud soli= new Solicitud();
                 
                 
                soli.setIdSolicitud(14);
		soli.getCliente().setIdCliente(14);
                soli.setDescripcion("aca pes pes cambio leyo");
                soli.setObservacion("leeeo");
               
		 
		Solicitud per= daote.modificarLeer(soli);
                  System.out.println(" "+per.toString());
	    
	}
           public static void modificarsolicitudleer2()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
		 
		int idSolicitud=25;
		Solicitud per= daote.modificarLeer(idSolicitud);
                  System.out.println(" "+per.toString());
	    
	}
}
