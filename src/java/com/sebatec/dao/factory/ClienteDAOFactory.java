/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.factory;

import com.sebatec.dao.interfaces.ClienteDAO;
import com.sebatec.dao.jdbc.ClienteDAOJDBC;

/**
 *
 * @author Mi Laptop
 */
public class ClienteDAOFactory {
    
    public ClienteDAO metodoDAO()
   {
    return new ClienteDAOJDBC();
   }
    
}
