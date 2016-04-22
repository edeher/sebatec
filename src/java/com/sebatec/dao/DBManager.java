/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.dao;


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
    
    static private final String url="jdbc:mysql://localhost:3306/sebatec";
    static private final String driver="com.mysql.jdbc.Driver";
    static private final String user="root";
    static private final String pass="poderoso";
    
    static private String error;
    
    public String getError()
    {
        return error;
    }
    public static Connection getConnection(){
        error = null;
        try{
            Class.forName(driver);
            return (DriverManager.getConnection(url,user,pass));            
        }catch (ClassNotFoundException | SQLException e){
            e.toString();
            System.out.println("ERROR DBMANAGER");
            System.out.println(e.getMessage());
        }
        return null;
    } 
    public void closeConnection(Connection con){
        error = null;
        try{
            con.close();
        }catch (SQLException e){error=e.toString();}
    }
    
}