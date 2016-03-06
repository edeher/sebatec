/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Tecnico;

/**
 *
 * @author Mi Laptop
 */
public interface TecnicoDAO {
    public boolean crear( Tecnico objtec) throws DAOException;//asocia la excepcion para usar las ecepciones
    public boolean modificar(Tecnico objtec)throws DAOException;
    public boolean eliminar(int idTecnico)throws DAOException;
    public Tecnico leerxid(int idTecnico)throws DAOException;
    public Tecnico[] leertodo()throws DAOException;
}
