/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;


import com.sebatec.modelo.Servicio;

/**
 *
 * @author Mi Laptop
 */
public interface ServicioDAO {
    public boolean crear( Servicio objservi,int idSolicitud, int idTecnico) throws DAOException;//asocia la excepcion para usar las ecepciones
    public boolean modificar(Servicio objservi,int idSolicitud, int idTecnico)throws DAOException;
    public boolean eliminar(int idServicio)throws DAOException;
    public Servicio leerxid(int idServicio)throws DAOException;
    public Servicio[] leertodo()throws DAOException;
    public Servicio[] leerxxid(int idServicio)throws DAOException;
     public Servicio[] leerTodoTecnico(int idTecnico)throws DAOException;
    public Servicio crearLeer(Servicio objSer)throws DAOException;
    public Servicio modificarLeer(Servicio objSer)throws DAOException;
    
}
