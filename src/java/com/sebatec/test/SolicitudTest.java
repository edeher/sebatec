/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.factory.EmpresaDAOFactory;
import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.interfaces.SolicitudDAO;
import com.sebatec.dao.factory.SolicitudDAOFactory;
import com.sebatec.enums.EstadoSolicitud;
import com.sebatec.modelo.Empresa;

import com.sebatec.modelo.Solicitud;
import com.sebatec.dao.interfaces.EmpresaDAO;



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
//          crearsolicitud();

//          modificarsolicitud();
//
//            eliminarsolicitud();
      
                
//        leersolicitud();

        leertodo();



//modificarsolicitudleer();
//modificarsolicitudleer2();
    }
    public static void crearsolicitud() throws DAOException
	{
		 SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
                
		Solicitud soli= new Solicitud();
		
                
                soli.getSolicitante().setNombre("pancracio");
                 soli.getSolicitante().setApellido("telesforo");
                soli.getSolicitante().setDni("45632133");
                 soli.getSolicitante().setDireccion("mi casita");
                 soli.getSolicitante().setTelefono("942154099");
                 soli.getSolicitante().setEmail("vpisistemas@unia.pe");
                 
                  soli.getSolicitante().getEmpresa().setRazon("softponce");
                 soli.getSolicitante().getEmpresa().setRuc("12345678933");
                  soli.getSolicitante().getEmpresa().setDireccion("aca nomas");
                  
                  soli.getSolicitante().setCargo("administrador");
                
                soli.setDescripcion("aca pes ");
                
		Solicitud solici= daote.crear(soli);
                
                System.out.println("solicitud "+solici.toString());
		   
		
		}
  
	public static void modificarsolicitud()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
		 
		 Solicitud soli= new Solicitud();
                 
                
                 
                soli.setIdSolicitud(12);
		
                soli.setDescripcion("aca pes pes solo se cambio este");
                 soli.setObservacion("yano");
                 soli.setEstadoSolicitud(EstadoSolicitud.AS);
               
		 
		Solicitud solici= daote.modificar(soli);
                
                System.out.println("solicitud "+solici.toString());
                 
	    
	}
	public static void eliminarsolicitud()throws DAOException
	{
	SolicitudDAOFactory fabricate= new    SolicitudDAOFactory();
                   SolicitudDAO daote= fabricate.metodoDAO();
                   Solicitud Soli= new   Solicitud();
		 Soli.setIdSolicitud(12);
                
	 daote.eliminar(Soli);
	 System.out.println("se elimino correctamente");
	}
	public static void leersolicitud()throws DAOException
	{
		SolicitudDAOFactory fabricate= new SolicitudDAOFactory();
		 SolicitudDAO daote= fabricate.metodoDAO();
                 
                 Solicitud objSoli=new Solicitud();
                    objSoli.setIdSolicitud(10);
	 
	   Solicitud per=daote.leerxid(objSoli);
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
//       
}
