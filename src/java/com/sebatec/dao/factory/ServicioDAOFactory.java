/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.factory;

import com.sebatec.dao.interfaces.ServicioDAO;
import com.sebatec.dao.jdbc.ServicioDAOJDBC;

/**
 *
 * @author Mi Laptop
 */
public class ServicioDAOFactory {
     public ServicioDAO metodoDAO()
	   {
	    return new ServicioDAOJDBC();
	   }
}
