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
public enum EstadoServicio {
    AS("ASIGNADO"),
    AC("ACEPTADO"),
    AT("ATENDIDO"),
    RE("RECHAZADO");
    
    
    private String nom;

    private EstadoServicio(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
