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
public class PersonaDAOFactory {
    public PersonaDAO metodoDAO()
	   {
	    return new PersonaDAOJDBC();
	   }
}
