/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.dao.interfaces.TipoServicioDAO;
import com.sebatec.dao.factory.TipoServicioDAOFactory;
import com.sebatec.enums.Estados;

import com.sebatec.modelo.TipoServicio;


/**
 *
 * @author Mi Laptop
 */
public class TipoServicioTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws DAOException {
//       crearTipoSErvicio();
//       modificarTipoServicio();
//        eliminarTipoServicio();
//        leerTipoServicio();
        leertodo();
        
    }
    
    public static void crearTipoSErvicio() throws DAOException
    {
        TipoServicioDAOFactory fabricate= new TipoServicioDAOFactory();
        TipoServicioDAO daote= fabricate.metodoDAO();
        
        TipoServicio tiposer= new TipoServicio();
        tiposer.setDescripcion("mantenimientos");
        tiposer.setEstado(Estados.A);
        
       TipoServicio tipo= daote.crear(tiposer);
        System.out.println(" tipo servicio :"+tipo.toString());
        
    }
    public static void modificarTipoServicio()throws DAOException
    {
        TipoServicioDAOFactory fabricate= new TipoServicioDAOFactory();
        TipoServicioDAO daote= fabricate.metodoDAO();
        TipoServicio tiposer=new TipoServicio();
        tiposer.setDescripcion("correcionnessss");
        tiposer.setEstado(Estados.A);
        tiposer.setIdTipoServicio(12);
        
         TipoServicio tipo=daote.modificar(tiposer);
           System.out.println(" tipo servicio :"+tipo.toString());
    }
    public static void eliminarTipoServicio()throws DAOException
    {
       TipoServicioDAOFactory fabricate= new TipoServicioDAOFactory();
        TipoServicioDAO daote= fabricate.metodoDAO();
                  
		TipoServicio tec= new TipoServicio();
                tec.setIdTipoServicio(16);
                
	 daote.eliminar(tec);
	 System.out.println("se elimino correctamente");
           
    }
    public static void leerTipoServicio()throws DAOException
    {
        TipoServicioDAOFactory fabricate= new TipoServicioDAOFactory();
        TipoServicioDAO daote= fabricate.metodoDAO();
        TipoServicio tec= new TipoServicio();
                tec.setIdTipoServicio(15);
        
        TipoServicio tiposer=daote.leerxid(tec);
        
        System.out.println("codigo "+tiposer );
 
           
    }
    public static void leertodo()throws DAOException
    {
        TipoServicioDAOFactory fabricate= new TipoServicioDAOFactory();
        TipoServicioDAO daote= fabricate.metodoDAO();
        
         TipoServicio[] tiposerv=daote.leertodo();
         
         for(TipoServicio tiposerv1:tiposerv)
         {
             
             System.out.println(" "+tiposerv1.toString());
         
         }
        
        
           
    }
}
