/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.DAOException;

import com.sebatec.dao.TecnicoDAO;
import com.sebatec.dao.TecnicoDAOFactory;
import com.sebatec.modelo.Estados;
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
        leertodo();
    }
    public static void creartecnico() throws DAOException
	{
		 TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
                  
		Tecnico tec= new Tecnico();
                 
                 
                 tec.setNombre("edeher");
		 tec.setApellido("nuevo ponce");
		 tec.setDni("46546545");
		
		 tec.setDireccion("dfdgfdg");
		tec.setTelefono("546546");
		 tec.setEmail("fsdfdfsdsdf");
		
		
                tec.setProfesion("ing. Sistemas ");
                tec.setEspecialidad("programador");
                
                
		 
		 daote.crear(tec);
		   
		
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
		 
                tec.setIdTecnico(7);
                
                tec.setProfesion("eeeee");
                tec.setEspecialidad("programadorccccccc");
                
                
		 
		 daote.modificar(tec);
                
	    
	}
	public static void eliminartecnico()throws DAOException
	{
		TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
	 
	 if(daote.leerxid(8)==null)
	 {
	     System.out.println("no existe un tecnico con el codigo "+9 +" en la base de datos");
	 }
	 else
	 {
	 daote.eliminar(8);
	 System.out.println("se elimino correctamente");
	 }
	    
	}
	public static void leertecnico()throws DAOException
	{
		TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
	 
	   Tecnico tec=daote.leerxid(3);
	 System.out.println(" "+tec.toString());
	    
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

}
