/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.modelo;

import com.sebatec.enums.Estados;
import com.sebatec.enums.TipoUsuario;

/**
 *
 * @author Mi Laptop
 */
public class Solicitante extends Persona{
    private int idSolicitante;
    private Empresa empresa;
    private String cargo;

    public Solicitante(int idSolicitante, Empresa empresa, String cargo, int idPersona, String nombre, String apellido, String dni, String direccion, String telefono, String email, Estados estado) {
        super(idPersona, nombre, apellido, dni, direccion, telefono, email, estado);
        this.idSolicitante = idSolicitante;
        this.empresa = empresa;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Solicitante{" + "idSolicitante=" + idSolicitante + ", empresa=" + empresa + ", cargo=" + cargo +  ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    public Solicitante() {
        this.empresa=new Empresa();
    }

    public int getIdSolicitante() {
        return idSolicitante;
    }

    public void setIdSolicitante(int idSolicitante) {
        this.idSolicitante = idSolicitante;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
     
    
}
