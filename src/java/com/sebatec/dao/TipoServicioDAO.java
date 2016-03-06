package com.sebatec.dao;


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
    
    public boolean crear( TipoServicio objser) throws DAOException;//asocia la excepcion para usar las ecepciones
    public boolean modificar(TipoServicio objser)throws DAOException;
    public boolean eliminar(int idtipoServicio)throws DAOException;
    public TipoServicio leerxid(int idTipoServicio)throws DAOException;
    public TipoServicio[] leertodo()throws DAOException;
    
    
}
