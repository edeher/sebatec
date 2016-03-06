/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.ClienteDAO;
import com.sebatec.dao.ClienteDAOFactory;
import com.sebatec.dao.DAOException;

import com.sebatec.modelo.Cliente;


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
        cli.setIdPersona(2);
        cli.setEstado(true);
        
        daote.crear(cli);
        
    }
    public static void modificarcliente()throws DAOException
    {
        ClienteDAOFactory fabricate= new ClienteDAOFactory();
         ClienteDAO daote= fabricate.metodoDAO();
         Cliente cli=new Cliente();
        cli.setIdPersona(3);
        cli.setEstado(true);
        cli.setIdCliente(1);
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
        
          Cliente cli=daote.leerxid(3);
        System.out.println(" "+cli.toString());
           
    }
    public static void leertodo()throws DAOException
    {
       ClienteDAOFactory fabricate= new ClienteDAOFactory();
         ClienteDAO daote= fabricate.metodoDAO();
        
         Cliente[] cliv=daote.leertodo();
         
         for(int i=0; i<cliv.length;i++)
         {
             
             System.out.println(" "+cliv[i].toString());
         
         }
        
        
           
    }
}
