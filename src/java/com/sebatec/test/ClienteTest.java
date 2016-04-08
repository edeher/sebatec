/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.ClienteDAO;

import com.sebatec.dao.ClienteDAOFactory;
import com.sebatec.dao.DAOException;

import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Cliente;
import com.sebatec.modelo.Estados;


/**
 *
 * @author Mi Laptop
 */
public class ClienteTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws DAOException{
//             crearcliente();
//             modificarcliente();
//eliminarcliente();
//        leercliente();
        leertodo();
        
    }
    
    public static void crearcliente() throws DAOException
    {
        ClienteDAOFactory fabricate= new ClienteDAOFactory();
        ClienteDAO daote= fabricate.metodoDAO();
       
        
        
       
           Cliente cli= new Cliente();
                
                 cli.setNombre("edeher cliente");
		cli.setApellido("nuevo ponce");
		 cli.setDni("46546545");
		cli.setDireccion("dfdgfdg");
		 cli.setTelefono("546546");
		cli.setEmail("fsdfdfsdsdf");
                
                cli.setRazonSocial("sdffsd");
		 cli.setRuc("6546545");
		 
		 
        
      
        daote.crear(cli);
        
    }
    public static void modificarcliente()throws DAOException
    {
        ClienteDAOFactory fabricate= new ClienteDAOFactory();
         ClienteDAO daote= fabricate.metodoDAO();
         
        
       
        Cliente cli=new Cliente();
               
                 cli.setNombre("edeher modifficandoxxxxxxx");
		 cli.setApellido("modificado");
		 cli.setDni("43056714");
		 cli.setDireccion("modificado");
		 cli.setTelefono("modificado");
		 cli.setEmail("modificado");
                 
                 cli.setRuc("12345678978");
                 cli.setRazonSocial("modificadoxxxxxx");
		 
		 
        cli.setIdCliente(22);
        daote.modificar(cli);
           
    }
    public static void eliminarcliente()throws DAOException
    {
       ClienteDAOFactory fabricate= new ClienteDAOFactory();
         ClienteDAO daote= fabricate.metodoDAO();
        
        if(daote.leerxid(7)==null)
        {
            System.out.println("no existe en la base de datos");
        }
        else
        {
        daote.eliminar(2);
        }
           
    }
    public static void leercliente()throws DAOException
    {
        ClienteDAOFactory fabricate= new ClienteDAOFactory();
         ClienteDAO daote= fabricate.metodoDAO();
        
          Cliente cli=daote.leerxid(1);
        System.out.println(" "+cli.toString());
           
    }
    public static void leertodo()throws DAOException
    {
       ClienteDAOFactory fabricate= new ClienteDAOFactory();
         ClienteDAO daote= fabricate.metodoDAO();
        
         Cliente[] cliv=daote.leertodo();
         
         for(Cliente cliv1:cliv)
         {
             
             System.out.println(" "+cliv1.toString());
         
         }
        
        
           
    }
}
