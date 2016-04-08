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
        crearsolicitud();
//        modificarsolicitud();
      //  eliminarsolicitud();
//        leersolicitud();
//        leertodo();
//        leertodo2();
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
	public static void modificarsolicitud()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
		 
		 Solicitud soli= new Solicitud();
                 Cliente objCli= new Cliente();
                 objCli.setIdCliente(14);
                 
                soli.setIdSolicitud(14);
		soli.setCliente(objCli);
                soli.setDescripcion("aca pes pes");
                soli.setObservacion("ddfgdfg");
               
		 
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
}
