/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.interfaces;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.modelo.Tecnico;

/**
 *
 * @author Mi Laptop
 */
public interface TecnicoDAO {
    public Tecnico crear( Tecnico objTec) throws DAOException;//asocia la excepcion para usar las ecepciones
    public Tecnico modificar(Tecnico objTec)throws DAOException;
    public boolean eliminar(Tecnico objTec)throws DAOException;
    public Tecnico leerxid(Tecnico objTec)throws DAOException;
    public Tecnico validar(Tecnico objTec)throws DAOException;
    public Tecnico[] leertodo()throws DAOException;
}
