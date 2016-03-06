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
    private int idPersona;
    private String profesion;
    private String especialidad;
    private boolean estado;

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
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Tecnico(int idTecnico, int idPersona, String profesion, String especialidad, boolean estado) {
        this.idTecnico = idTecnico;
        this.idPersona = idPersona;
        this.profesion = profesion;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public Tecnico() {
    }

    @Override
    public String toString() {
        return "Tecnico{" + "idTecnico=" + idTecnico + ", idPersona=" + idPersona + ", profesion=" + profesion + ", especialidad=" + especialidad + ", estado=" + estado + '}';
    }
    
}
