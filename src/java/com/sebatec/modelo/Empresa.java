/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.modelo;

import com.sebatec.enums.Estados;

/**
 *
 * @author Mi Laptop
 */
public class Empresa {
    
    private int idEmpresa;
    private String razon;
    private String ruc;
    private String direccion;
   

    public Empresa() {
    }

    public Empresa(int idEmpresa, String razon, String ruc, String direccion) {
        this.idEmpresa = idEmpresa;
        this.razon = razon;
        this.ruc = ruc;
        this.direccion = direccion;
        
    }

    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", razon=" + razon + ", ruc=" + ruc + ", direccion=" + direccion +  '}';
    }

    
    
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   

    
    
    
}
