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
public class Solicitud 
{
   private int idSolicitud;
   private int idPersona;
   private String descripcion;
   private String observacion;
   private boolean estado;

    /**
     * @return the idSolicitud
     */
    public int getIdSolicitud() {
        return idSolicitud;
    }

    /**
     * @param idSolicitud the idSolicitud to set
     */
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the observaciones
     */
    public String getObservacion() {
        return observacion;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public Solicitud(int idSolicitud, int idPersona, String descripcion, String observacions, boolean estado) {
        this.idSolicitud = idSolicitud;
        this.idPersona = idPersona;
        this.descripcion = descripcion;
        this.observacion= observacion;
        this.estado = estado;
    }

    public Solicitud() {
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", idPersona=" + idPersona + ", descripcion=" + descripcion + ", observacion=" + observacion + ", estado=" + estado + '}';
    }

    
    }
    

