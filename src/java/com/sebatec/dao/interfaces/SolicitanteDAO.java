/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.interfaces;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.modelo.Solicitante;


/**
 *
 * @author Mi Laptop
 */
public interface SolicitanteDAO {
    public Solicitante crear( Solicitante objsolite) throws DAOException;//asocia la excepcion para usar las ecepciones
    public Solicitante modificar(Solicitante objsolite)throws DAOException;
    public boolean eliminar(Solicitante objsolite)throws DAOException;
    public Solicitante leerxid(Solicitante objsolite)throws DAOException;
   
    public Solicitante[] leertodo()throws DAOException;
}
