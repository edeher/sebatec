/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

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
