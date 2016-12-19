/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.interfaces;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.modelo.Empresa;


/**
 *
 * @author Mi Laptop
 */
public interface EmpresaDAO {
    public Empresa crear( Empresa objEmpre) throws DAOException;//asocia la excepcion para usar las ecepciones
    public Empresa modificar(Empresa objEmpre)throws DAOException;
    public boolean eliminar(Empresa objEmpre)throws DAOException;
    public Empresa leerxid(Empresa objEmpre)throws DAOException;
    public Empresa[] leertodo()throws DAOException;
}
