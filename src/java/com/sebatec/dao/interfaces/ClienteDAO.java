/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.interfaces;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.modelo.Cliente;


/**
 *
 * @author Mi Laptop
 */
public interface ClienteDAO {
    public Cliente crear( Cliente objcli) throws DAOException;//asocia la excepcion para usar las ecepciones
    public Cliente modificar(Cliente objcli)throws DAOException;
    public boolean eliminar(Cliente objCli)throws DAOException;
    public Cliente leerxid(Cliente objCli)throws DAOException;
    public Cliente[] leertodo()throws DAOException;
}
