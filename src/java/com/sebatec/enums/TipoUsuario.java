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
public enum TipoUsuario {
    
   A("ADMINISTRADOR"),
   U("USUARIO");
   
    private String nom;

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    private TipoUsuario(String nom) {
        this.nom = nom;
    }

   

    
}
