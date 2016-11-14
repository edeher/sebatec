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
public enum EstadoSolicitud {
    ES("ESPERA"),
   AS("ASIGANADO"),
    AN("ANULADO");
    
    private String nom;

    private EstadoSolicitud(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
