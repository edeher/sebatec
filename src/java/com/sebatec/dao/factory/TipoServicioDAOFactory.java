/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao.factory;

import com.sebatec.dao.interfaces.TipoServicioDAO;
import com.sebatec.dao.jdbc.TipoServicioDAOJDBC;

/**
 *
 * @author Mi Laptop
 */
public class TipoServicioDAOFactory {

   public TipoServicioDAO metodoDAO()
   {
    return new TipoServicioDAOJDBC();
   }
   
   
    
}
