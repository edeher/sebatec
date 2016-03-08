/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;


import com.sebatec.dao.DAOException;
import com.sebatec.dao.PersonaDAO;
import com.sebatec.dao.PersonaDAOFactory;
import com.sebatec.modelo.Estados;
import com.sebatec.modelo.Persona;
/**
 *
 * @author Mi Laptop
 */
public class PersonaTest {

    /**
     * @param args the command line arguments
     * @throws com.sebatec.dao.DAOException
     */
    public static void main(String[] args) throws DAOException{
//      		crearpersona();
//     modificarpersona();
//eliminarpersona();
//leerpersona();
 leertodo();

}

	public static void crearpersona() throws DAOException
	{
		 PersonaDAOFactory fabricate= new PersonaDAOFactory();
		 PersonaDAO daote= fabricate.metodoDAO();
		 
		 Persona per= new Persona();
		 per.setNombre("edeher");
		 per.setApellido("ponce");
		 per.setDni("46546545");
		 per.setRazon("sdffsd");
		 per.setRuc("6546545");
		 per.setDireccion("dfdgfdg");
		 per.setTelefono("546546");
		 per.setEmail("fsdfdfsdsdf");
		 per.setEstado(Estados.A);
		 
		 daote.crear(per);
		 
		}
	public static void modificarpersona()throws DAOException
	{
		PersonaDAOFactory fabricate= new PersonaDAOFactory();
		 PersonaDAO daote= fabricate.metodoDAO();
		 Persona per= new Persona();
		 per.setIdPersona(2);
		 per.setNombre("edeher");
		 per.setApellido("ponce morales");
		 per.setDni("46546545");
		 per.setRazon("sdffsd");
		 per.setRuc("6546545");
		 per.setDireccion("dfdgfdg");
		 per.setTelefono("546546");
		 per.setEmail("fsdfdfsdsdf");
		 per.setEstado(Estados.A);
		 
		 daote.modificar(per);
	    
	}
	public static void eliminarpersona()throws DAOException
	{
		PersonaDAOFactory fabricate= new PersonaDAOFactory();
		 PersonaDAO daote= fabricate.metodoDAO();
	 
	 if(daote.leerxid(3)==null)
	 {
	     System.out.println("no existe una persona con el codigo "+7 +" en la base de datos");
	 }
	 else
	 {
	 daote.eliminar(3);
	 System.out.println("se elimino correctamente");
	 }
	    
	}
	public static void leerpersona()throws DAOException
	{
		PersonaDAOFactory fabricate= new PersonaDAOFactory();
		 PersonaDAO daote= fabricate.metodoDAO();
	 
	   Persona per=daote.leerxid(3);
	 System.out.println(" "+per.toString());
	    
	}
	public static void leertodo()throws DAOException
	{
		PersonaDAOFactory fabricate= new PersonaDAOFactory();
		 PersonaDAO daote= fabricate.metodoDAO();
	 
	  Persona[] perv=daote.leertodo();
	  
	  for(Persona perv1:perv)
	  {
	      
	      System.out.println(" "+perv1.toString());
	  
	  }
	 
	 
	    
	}
}
