/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.interfaces;

import com.sebatec.dao.factory.DAOException;
import com.sebatec.modelo.Empresa;
import com.sebatec.modelo.Solicitud;



/**
 *
 * @author Mi Laptop
 */
public interface SolicitudDAO {
    public Solicitud crear( Solicitud objSoli) throws DAOException;//asocia la excepcion para usar las ecepciones
    
    public Solicitud modificar(Solicitud objSoli)throws DAOException;
    public boolean eliminar(Solicitud objSoli)throws DAOException;
    public Solicitud leerxid(Solicitud objSoli)throws DAOException;
    public Solicitud[] leertodo()throws DAOException;
   
}
