package com.sebatec.dao.interfaces;


import com.sebatec.dao.factory.DAOException;
import com.sebatec.modelo.TipoServicio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mi Laptop
 */
public interface TipoServicioDAO {
    
    public TipoServicio crear( TipoServicio objSer) throws DAOException;//asocia la excepcion para usar las ecepciones
    public TipoServicio modificar(TipoServicio objSer)throws DAOException;
    public boolean eliminar(TipoServicio objSer)throws DAOException;
    public TipoServicio leerxid(TipoServicio objSer)throws DAOException;
    public TipoServicio[] leertodo()throws DAOException;
    
    
}
