/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Cliente;
import com.sebatec.modelo.Solicitud;



/**
 *
 * @author Mi Laptop
 */
public interface SolicitudDAO {
    public boolean crear( Solicitud objsoli) throws DAOException;//asocia la excepcion para usar las ecepciones
    public boolean crear( Solicitud objsoli, int idCliente) throws DAOException;
    public boolean modificar(Solicitud objsoli)throws DAOException;
    public boolean eliminar(int idSolicitud)throws DAOException;
    public Solicitud leerxid(int idSolicitud)throws DAOException;
    public Solicitud[] leertodo()throws DAOException;
    public Solicitud[] leertodo(int idCliente)throws DAOException;
}
