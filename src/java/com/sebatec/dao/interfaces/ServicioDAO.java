/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.interfaces;


import com.sebatec.dao.factory.DAOException;
import com.sebatec.modelo.Servicio;

/**
 *
 * @author Mi Laptop
 */
public interface ServicioDAO {
    public Servicio crear( Servicio objSer) throws DAOException;//asocia la excepcion para usar las ecepciones
    public Servicio modificar(Servicio objSer)throws DAOException;
    public boolean eliminar(Servicio objSer)throws DAOException;
    public Servicio leerxid(Servicio objSer)throws DAOException;
    public Servicio[] leertodo()throws DAOException;
    
    
}
