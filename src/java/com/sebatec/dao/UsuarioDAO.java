/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import com.sebatec.modelo.Persona;
import com.sebatec.modelo.Usuario;

/**
 *
 * @author Mi Laptop
 */
public interface UsuarioDAO {
    public boolean crear( Usuario objusu, int idPersona) throws DAOException;
    public boolean crear( Usuario objusu,Persona objper) throws DAOException;
    public boolean modificar(Usuario objusu, Persona objper)throws DAOException;
    public boolean eliminar(int idUsuario)throws DAOException;
    public Usuario leerxid(int idUsuario)throws DAOException;
    public Usuario[] leertodo()throws DAOException;
}
