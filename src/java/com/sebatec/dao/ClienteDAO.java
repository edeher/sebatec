/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Cliente;


/**
 *
 * @author Mi Laptop
 */
public interface ClienteDAO {
    public boolean crear( Cliente objcli) throws DAOException;//asocia la excepcion para usar las ecepciones
    public boolean modificar(Cliente objcli)throws DAOException;
    public boolean eliminar(int idCliente)throws DAOException;
    public Cliente leerxid(int idCliente)throws DAOException;
    public Cliente[] leertodo()throws DAOException;
}
