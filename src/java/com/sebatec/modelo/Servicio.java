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
    private Solicitud solicitud;
    private Tecnico tecnico;
    private String descripcion;
    private Date fechaEmimsion;
    private Date fechaGestion;
    private double monto;
    private EstadoSev estado;

    public Servicio(int idServicio, Solicitud solicitud, Tecnico tecnico, String descripcion, Date fechaEmimsion, Date fechaGestion, double monto) {
        this.idServicio = idServicio;
        this.solicitud = solicitud;
        this.tecnico = tecnico;
        this.descripcion = descripcion;
        this.fechaEmimsion = fechaEmimsion;
        this.fechaGestion = fechaGestion;
        this.monto = monto;
    }

    public Servicio() {
        this.solicitud=new Solicitud();
        this.tecnico=new Tecnico();
    }

    public Servicio(int idServicio, Solicitud solicitud, Tecnico tecnico, String descripcion, Date fechaEmimsion, Date fechaGestion, double monto, EstadoSev estado) {
        this.idServicio = idServicio;
        this.solicitud = solicitud;
        this.tecnico = tecnico;
        this.descripcion = descripcion;
        this.fechaEmimsion = fechaEmimsion;
        this.fechaGestion = fechaGestion;
        this.monto = monto;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", solicitud=" + solicitud + ", tecnico=" + tecnico + ", descripcion=" + descripcion + ", fechaEmimsion=" + fechaEmimsion + ", fechaGestion=" + fechaGestion + ", monto=" + monto + ", estado=" + estado.getNom() + '}';
    }
    
    

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEmimsion() {
        return fechaEmimsion;
    }

    public void setFechaEmimsion(Date fechaEmimsion) {
        this.fechaEmimsion = fechaEmimsion;
    }

    public Date getFechaGestion() {
        return fechaGestion;
    }

    public void setFechaGestion(Date fechaGestion) {
        this.fechaGestion = fechaGestion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public EstadoSev getEstado() {
        return estado;
    }

    public void setEstado(EstadoSev estado) {
        this.estado = estado;
    }

    
}
