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
                 Persona per=new Persona();
                 per.setIdPersona(1);
                 per.setNombre("edeher");
		 per.setApellido("nuevo ponce");
		 per.setDni("46546545");
		 per.setRazon("sdffsd");
		 per.setRuc("6546545");
		 per.setDireccion("dfdgfdg");
		 per.setTelefono("546546");
		 per.setEmail("fsdfdfsdsdf");
		 per.setEstado(Estados.A);
		tec.setPersona (per);
                tec.setProfesion("ing. Sistemas ");
                tec.setEspecialidad("programador");
                tec.setEstado(Estados.A);
                
		 
		 daote.crear(tec);
		   
		
		}
	public static void modificartecnico()throws DAOException
	{
		TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
                  
		Tecnico tec= new Tecnico();
                Persona per=new Persona();
                 per.setIdPersona(1);
                 per.setNombre("edeher ");
		 per.setApellido("nuevo ponce");
		 per.setDni("46546545");
		 per.setRazon("sdffsd");
		 per.setRuc("6546545");
		 per.setDireccion("dfdgfdg");
		 per.setTelefono("546546");
		 per.setEmail("fsdfdfsdsdf");
		 per.setEstado(Estados.A);
                tec.setIdTecnico(7);
                tec.setPersona(per);
                tec.setProfesion("ing. Sistemas y civil tecnico");
                tec.setEspecialidad("programador");
                tec.setEstado(Estados.A);
                
		 
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
