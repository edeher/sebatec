/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.factory;

import com.sebatec.dao.interfaces.TecnicoDAO;
import com.sebatec.dao.jdbc.TecnicoDAOJDBC;

/**
 *
 * @author Mi Laptop
 */
public class TecnicoDAOFactory {
    public TecnicoDAO metodoDAO()
	   {
	    return new TecnicoDAOJDBC();
	   }
}
