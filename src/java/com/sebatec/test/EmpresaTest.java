/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.factory.EmpresaDAOFactory;
import com.sebatec.dao.factory.DAOException;
import com.sebatec.enums.Estados;

import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Empresa;
import com.sebatec.dao.interfaces.EmpresaDAO;



/**
 *
 * @author Mi Laptop
 */
public class EmpresaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws DAOException{
//             crearempresa();
//             modificarempresa();
//eliminarempresa();
//        leerempresa();
        leertodo();

    }
    
    public static void crearempresa() throws DAOException
    {
        EmpresaDAOFactory fabricate= new EmpresaDAOFactory();
        EmpresaDAO daote= fabricate.metodoDAO();
       
        
        
       
           Empresa empre= new Empresa();
                
		empre.setDireccion("dfdgfdg");
		
                empre.setRazon("sdffsd");
		 empre.setRuc("99999999999");
		 
		 
        
        Empresa empresa= daote.crear(empre);
	 System.out.println(" "+empresa.toString());
       
        
    }
    public static void modificarempresa()throws DAOException
    {
        EmpresaDAOFactory fabricate= new EmpresaDAOFactory();
         EmpresaDAO daote= fabricate.metodoDAO();
         
        
       
        Empresa cli=new Empresa();
               
           Empresa empre= new Empresa();
                empre.setIdEmpresa(17);
		empre.setDireccion("suerte");
		
                empre.setRazon("sdffsd");
		 empre.setRuc("99999999999");
		
		 
        
        Empresa empresa= daote.modificar(empre);
	 System.out.println(" "+empresa.toString());
           
    }
    public static void eliminarempresa()throws DAOException
    {
        EmpresaDAOFactory fabricate= new    EmpresaDAOFactory();
                   EmpresaDAO daote= fabricate.metodoDAO();
                   Empresa objE= new    Empresa();
		 objE.setIdEmpresa(17);
                
	 daote.eliminar(objE);
	 System.out.println("se elimino correctamente");
           
    }
    public static void leerempresa()throws DAOException
    {
        EmpresaDAOFactory fabricate= new EmpresaDAOFactory();
         EmpresaDAO daote= fabricate.metodoDAO();
        Empresa objempre=new Empresa();
         objempre.setIdEmpresa(9);
          Empresa empresa=daote.leerxid(objempre);
        System.out.println(" "+empresa.toString());
           
    }

    public static void leertodo()throws DAOException
    {
       EmpresaDAOFactory fabricate= new EmpresaDAOFactory();
         EmpresaDAO daote= fabricate.metodoDAO();
        
         Empresa[] empre=daote.leertodo();
         
         for(Empresa empresa:empre)
         {
             
             System.out.println(" "+empresa.toString());
         
         }
        
        
           
    }
}
