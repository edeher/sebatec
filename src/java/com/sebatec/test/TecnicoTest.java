/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.interfaces.TecnicoDAO;
import com.sebatec.dao.factory.TecnicoDAOFactory;
import com.sebatec.enums.TipoUsuario;

import com.sebatec.modelo.Tecnico;
import com.sebatec.modelo.Persona;


/**
 *
 * @author Mi Laptop
 */
public class TecnicoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws DAOException{
        // TODO code application logic here
//        creartecnico();
//        modificartecnico();
//        eliminartecnico();
//        leertecnico();
//        leertodo();
        validar();
    }
    public static void creartecnico() throws DAOException
	{
		 TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
                  
		Tecnico tec= new Tecnico();
                 
                 
                 tec.setNombre("edeher");
		 tec.setApellido("nuevo ponce");
		 tec.setDni("77777775");
		
		 tec.setDireccion("dfdgfdg");
		tec.setTelefono("546546");
		 tec.setEmail("fsdfdfsdsdf");
		
		
                tec.setProfesion("ing. Sistemas ");
                tec.setEspecialidad("programador");
                tec.setUsuario("popeyes");
                tec.setPassword("popeye");
                tec.setTipousuario(TipoUsuario.A);
                
                
		 
		Tecnico tecni= daote.crear(tec);
		   
		System.out.println("tecnico "+tecni.toString());
		}
	public static void modificartecnico()throws DAOException
	{
		TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
                  
		Tecnico tec= new Tecnico();
                
                
                 tec.setNombre("eeeeee ");
		 tec.setApellido("nuevo ponceccccccc");
		tec.setDni("46546545");
		 
		 tec.setDireccion("dfdgfdg");
		 tec.setTelefono("546546");
		 tec.setEmail("fsdfdfsdsdf");
		 
                tec.setIdTecnico(16);
                
                tec.setProfesion("ing. Sistemas ");
                tec.setEspecialidad("programador");
                tec.setUsuario("popeyess");
                tec.setPassword("popeyes");
                tec.setTipousuario(TipoUsuario.U);
                
		 
		Tecnico tecni= daote.modificar(tec);
		   
		System.out.println("tecnico "+tecni.toString());
                
	    
	}
	public static void eliminartecnico()throws DAOException
	{
		TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
                  
		Tecnico tec= new Tecnico();
                tec.setIdTecnico(17);
                
	 daote.eliminar(tec);
	 System.out.println("se elimino correctamente");
	    
	}
	public static void leertecnico()throws DAOException
	{
		TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
	 Tecnico tec=new Tecnico();
         tec.setIdTecnico(16);
                 
	   Tecnico tecni=daote.leerxid(tec);
	 System.out.println(" "+tecni.toString());
	    
	}
	public static void leertodo()throws DAOException
	{
		TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
	 
	  Tecnico[] tecv=daote.leertodo();
	  
	  for(Tecnico tecv1:tecv)
	  {
	      
	      System.out.println(" "+tecv1.toString());
	  
	  }
	 
        } 
        public static void validar()throws DAOException
	{
		TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
	 Tecnico tec=new Tecnico();
         tec.setUsuario("popeyess");
         tec.setPassword("popeyes");
                 
	   Tecnico tecni=daote.validar(tec);
	 System.out.println(" "+tecni.toString());
	    
	}

}
