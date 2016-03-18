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
public class Tecnico extends Persona{
    private int idTecnico;
    private String profesion;
    private String especialidad;

    public Tecnico(int idTecnico, String profesion, String especialidad, int idPersona, String nombre, String apellido, String dni, String razon, String ruc, String direccion, String telefono, String email, Estados estado) {
        super(idPersona, nombre, apellido, dni, razon, ruc, direccion, telefono, email, estado);
        this.idTecnico = idTecnico;
        this.profesion = profesion;
        this.especialidad = especialidad;
    }

    public Tecnico(int idTecnico, String profesion, String especialidad, String nombre, String apellido, String dni, String razon, String ruc, String direccion, String telefono, String email) {
        super(nombre, apellido, dni, razon, ruc, direccion, telefono, email);
        this.idTecnico = idTecnico;
        this.profesion = profesion;
        this.especialidad = especialidad;
    }

    /**
     * @return the idTecnico
     */
    public int getIdTecnico() {
        return idTecnico;
    }

    /**
     * @param idTecnico the idTecnico to set
     */
    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    /**
     * @return the profesion
     */
    public String getProfesion() {
        return profesion;
    }

    /**
     * @param profesion the profesion to set
     */
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    public Tecnico() {
    }

    
  @Override
    public String toString() {
        return "Tecnico{" + "idTecnico=" + idTecnico + ", profesion=" + profesion + ", especialidad=" + especialidad + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", razon=" + razon + ", ruc=" + ruc + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email  +'}';
       
    }
  

        
}
