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
    private int idPersona;
    private boolean estado;

    public Cliente(int idCliente, int idPersona, boolean estado) {
        this.idCliente = idCliente;
        this.idPersona = idPersona;
        this.estado = estado;
    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", idPersona=" + idPersona + ", estado=" + estado + '}';
    }
    
    

    /**
     * Get the value of idCliente
     *
     * @return the value of idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Set the value of idCliente
     *
     * @param idCliente new value of idCliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

    
}
