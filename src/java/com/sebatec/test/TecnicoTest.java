/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.DAOException;

import com.sebatec.dao.TecnicoDAO;
import com.sebatec.dao.TecnicoDAOFactory;
import com.sebatec.modelo.Tecnico;



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
		tec.setIdPersona(1);
                tec.setProfesion("ing. Sistemas ");
                tec.setEspecialidad("programador");
                tec.setEstado(true);
                
		 
		 daote.crear(tec);
		   
		
		}
	public static void modificartecnico()throws DAOException
	{
		TecnicoDAOFactory fabricate= new TecnicoDAOFactory();
		 TecnicoDAO daote= fabricate.metodoDAO();
                  
		Tecnico tec= new Tecnico();
                tec.setIdTecnico(1);
                tec.setIdPersona(1);
                tec.setProfesion("ing. Sistemas y civil ");
                tec.setEspecialidad("programador");
                tec.setEstado(true);
                
		 
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
	  
	  for(int i=0; i<tecv.length;i++)
	  {
	      
	      System.out.println(" "+tecv[i].toString());
	  
	  }
	 
        } 

}
