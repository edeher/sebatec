/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.factory;

import com.sebatec.dao.interfaces.SolicitanteDAO;

import com.sebatec.dao.jdbc.SolicitanteDAOJDBC;


/**
 *
 * @author Mi Laptop
 */
public class SolicitanteDAOFactory {
    public SolicitanteDAO metodoDAO()
	   {
	    return new SolicitanteDAOJDBC();
	   }
}
