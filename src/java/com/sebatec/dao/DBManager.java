/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;

import java.sql.*;

/**
 *
 * @author Ing Edeher
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fn
 */
public class DBManager {
    static String url = "jdbc:mysql://localhost:3306/sebatec";
    static String username = "root";
    static String password = "poderoso";
    
        
    static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            System.out.println("Error obtaining connection with the database: " + se);
            System.exit(-1);
        }
    return null;
    }    
}