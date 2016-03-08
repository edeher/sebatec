/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.test;

import com.sebatec.dao.DAOException;
import com.sebatec.dao.TipoServicioDAO;
import com.sebatec.dao.TipoServicioDAOFactory;
import com.sebatec.modelo.Estados;
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
        TipoServicioDAO daote= fabricate.crearTiposervicioDAO();
        
        TipoServicio tiposer= new TipoServicio();
        tiposer.setDescripcion("mantenimiento");
        tiposer.setEstado(Estados.A);
        
        daote.crear(tiposer);
        
    }
    public static void modificarTipoServicio()throws DAOException
    {
        TipoServicioDAOFactory fabricate= new TipoServicioDAOFactory();
        TipoServicioDAO daote= fabricate.crearTiposervicioDAO();
        TipoServicio tiposer=new TipoServicio();
        tiposer.setDescripcion("correcionn");
        tiposer.setEstado(Estados.A);
        tiposer.setIdTipoServicio(12);
        daote.modificar(tiposer);
           
    }
    public static void eliminarTipoServicio()throws DAOException
    {
        TipoServicioDAOFactory fabricate= new TipoServicioDAOFactory();
        TipoServicioDAO daote= fabricate.crearTiposervicioDAO();
        
        if(daote.leerxid(8)==null)
        {
            System.out.println("no existe en la base de datos");
        }
        else
        {
        daote.eliminar(8);
        }
           
    }
    public static void leerTipoServicio()throws DAOException
    {
        TipoServicioDAOFactory fabricate= new TipoServicioDAOFactory();
        TipoServicioDAO daote= fabricate.crearTiposervicioDAO();
        
        TipoServicio tiposer=daote.leerxid(3);
        
        System.out.println("codigo "+tiposer.getIdTipoServicio());
        System.out.println("descripcion "+tiposer.getDescripcion());
        System.out.println("estado "+tiposer.getEstado().name());
           
    }
    public static void leertodo()throws DAOException
    {
        TipoServicioDAOFactory fabricate= new TipoServicioDAOFactory();
        TipoServicioDAO daote= fabricate.crearTiposervicioDAO();
        
         TipoServicio[] tiposerv=daote.leertodo();
         
         for(TipoServicio tiposerv1:tiposerv)
         {
             
             System.out.println(" "+tiposerv1.toString());
         
         }
        
        
           
    }
}
