/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.factory;

import com.sebatec.dao.interfaces.SolicitudDAO;
import com.sebatec.dao.jdbc.SolicitudDAOJDBC;

/**
 *
 * @author Mi Laptop
 */
public class SolicitudDAOFactory {
     public SolicitudDAO metodoDAO()
	   {
	    return new SolicitudDAOJDBC();
	   }
}
