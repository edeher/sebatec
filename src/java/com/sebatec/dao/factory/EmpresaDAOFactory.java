/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.factory;

import com.sebatec.dao.jdbc.EmpresaDAOJDBC;
import com.sebatec.dao.interfaces.EmpresaDAO;

/**
 *
 * @author Mi Laptop
 */
public class EmpresaDAOFactory {
    
    public EmpresaDAO metodoDAO()
   {
    return new EmpresaDAOJDBC();
   }
    
}
