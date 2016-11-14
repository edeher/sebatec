/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.enums;

/**
 *
 * @author Mi Laptop
 */
public enum Estados {
    
   A("ACTIVO"),
   N("NO ACTIVO");
   
    private String nom;

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    private Estados(String nom) {
        this.nom = nom;
    }

   

    
}
