/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.modelo;

/**
 *
 * @author Mi Laptop
 */
public enum EstadoSev {
    A("Asignado"),
    C("Concluido"),
    R("Rechazado");
    
    private String nom;

    private EstadoSev(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
