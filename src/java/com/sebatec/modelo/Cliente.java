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
    private String ruc;
    private String razonSocial;

    public Cliente() {
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", ruc=" + ruc + ", razonSocial=" + razonSocial + "nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }

  
    
    public Cliente(int idCliente, String ruc, String razonSocial, int idPersona, String nombre, String apellido, String dni, String direccion, String telefono, String email) {
        super(idPersona, nombre, apellido, dni, direccion, telefono, email);
        this.idCliente = idCliente;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
    }

    public Cliente(int idCliente, String ruc, String razonSocial, String nombre, String apellido, String dni, String direccion, String telefono, String email) {
        super(nombre, apellido, dni, direccion, telefono, email);
        this.idCliente = idCliente;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    
    
}
