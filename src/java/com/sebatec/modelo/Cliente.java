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

    public Cliente(int idCliente, String nombre, String apellido, String dni, String razon, String ruc, String direccion, String telefono, String email) {
        super(nombre, apellido, dni, razon, ruc, direccion, telefono, email);
        this.idCliente = idCliente;
    }

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(String nombre) {
        super(nombre);
    }

    
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

     
    
}
