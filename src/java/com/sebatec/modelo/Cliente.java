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
public class Cliente extends Persona{
    
    private int idCliente;

    public Cliente(int idCliente, int idPersona, String nombre, String apellido, String dni, String razon, String ruc, String direccion, String telefono, String email, Estados estado) {
        super(idPersona, nombre, apellido, dni, razon, ruc, direccion, telefono, email, estado);
        this.idCliente = idCliente;
    }

    public Cliente(int idCliente, String nombre, String apellido, String dni, String razon, String ruc, String direccion, String telefono, String email) {
        super(nombre, apellido, dni, razon, ruc, direccion, telefono, email);
        this.idCliente = idCliente;
    }

    public Cliente() {
    }

    
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

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", razon=" + razon + ", ruc=" + ruc + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email  +'}';
 
    }
    
   
    
}
