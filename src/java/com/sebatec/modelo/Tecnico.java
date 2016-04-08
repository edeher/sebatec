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

    public Tecnico(int idTecnico, String profesion, String especialidad, int idPersona, String nombre, String apellido, String dni, String direccion, String telefono, String email) {
        super(idPersona, nombre, apellido, dni, direccion, telefono, email);
        this.idTecnico = idTecnico;
        this.profesion = profesion;
        this.especialidad = especialidad;
    }

    public Tecnico(int idTecnico, String profesion, String especialidad, String nombre, String apellido, String dni, String direccion, String telefono, String email) {
        super(nombre, apellido, dni, direccion, telefono, email);
        this.idTecnico = idTecnico;
        this.profesion = profesion;
        this.especialidad = especialidad;
    }

    public Tecnico() {
    }

    @Override
    public String toString() {
        return "Tecnico{" + "idTecnico=" + idTecnico + ", profesion=" + profesion + ", especialidad=" + especialidad + ", nombre=" + nombre + '}';
    }

  

    public Tecnico(String nombre) {
        super(nombre);
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
}
