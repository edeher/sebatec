/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.modelo;


import java.util.Date;

/**
 *
 * @author Mi Laptop
 */
public class Servicio {
    private int idServicio;
    private int idSolicitud;
    private int idTecnico;
    private String descripcion;
    private Date fechaEmimsion;
    private Date fechaGestion;
    private double monto;
    private boolean estado;

    /**
     * @return the idServicio
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

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
     * @return the fechaEmimsion
     */
    public Date getFechaEmimsion() {
        return fechaEmimsion;
    }

    /**
     * @param fechaEmimsion the fechaEmimsion to set
     */
    public void setFechaEmimsion(Date fechaEmimsion) {
        this.fechaEmimsion = fechaEmimsion;
    }

    /**
     * @return the fechaGestion
     */
    public Date getFechaGestion() {
        return fechaGestion;
    }

    /**
     * @param fechaGestion the fechaGestion to set
     */
    public void setFechaGestion(Date fechaGestion) {
        this.fechaGestion = fechaGestion;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
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

    public Servicio(int idServicio, int idSolicitud, int idTecnico, String descripcion, Date fechaEmimsion, Date fechaGestion, double monto, boolean estado) {
        this.idServicio = idServicio;
        this.idSolicitud = idSolicitud;
        this.idTecnico = idTecnico;
        this.descripcion = descripcion;
        this.fechaEmimsion = fechaEmimsion;
        this.fechaGestion = fechaGestion;
        this.monto = monto;
        this.estado = estado;
    }

    public Servicio() {
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", idSolicitud=" + idSolicitud + ", idTecnico=" + idTecnico + ", descripcion=" + descripcion + ", fechaEmimsion=" + fechaEmimsion + ", fechaGestion=" + fechaGestion + ", monto=" + monto + ", estado=" + estado + '}';
    }
    
    
    
}
