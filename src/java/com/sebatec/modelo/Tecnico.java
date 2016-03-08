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
public class Tecnico {
    private int idTecnico;
    private Persona persona;
    private String profesion;
    private String especialidad;
    private Estados estado;

    public Tecnico(int idTecnico, Persona persona, String profesion, String especialidad, Estados estado) {
        this.idTecnico = idTecnico;
        this.persona = persona;
        this.profesion = profesion;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Tecnico() {
    }

    @Override
    public String toString() {
        return "Tecnico{" + "idTecnico=" + getIdTecnico() + ", persona=" + getPersona() + ", profesion=" + getProfesion() + ", especialidad=" + getEspecialidad() + ", estado=" + getEstado() + '}';
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

   
    
    
}
