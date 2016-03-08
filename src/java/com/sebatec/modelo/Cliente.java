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
public class Cliente {
    
    private int idCliente;
    private Persona persona;
    private Estados estado;

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the persona
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * @return the estado
     */
    public Estados getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Cliente(int idCliente, Persona persona, Estados estado) {
        this.idCliente = idCliente;
        this.persona = persona;
        this.estado = estado;
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", persona=" + persona + ", estado=" + estado + '}';
    }

    
    
}
