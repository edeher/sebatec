/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.modelo;


import com.sebatec.enums.EstadoServicio;
import java.sql.Date;

/**
 *
 * @author Mi Laptop
 */
public class Servicio {

    
    private int idServicio;
    private Solicitud solicitud;
    private Tecnico tecnico;
    private TipoServicio tiposervicio;
    private String descripcion;
    private Date fechaAsignacion;
    private Date fechaGestion;
    private double monto;
    private EstadoServicio estadoservicio;

    public Servicio(int idServicio, Solicitud solicitud, Tecnico tecnico, TipoServicio tiposervicio, String descripcion, Date fechaAsignacion, Date fechaGestion, double monto, EstadoServicio estado) {
        this.idServicio = idServicio;
        this.solicitud = solicitud;
        this.tecnico = tecnico;
        this.tiposervicio = tiposervicio;
        this.descripcion = descripcion;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaGestion = fechaGestion;
        this.monto = monto;
        this.estadoservicio = estado;
    }

    public Servicio() {
        this.solicitud=new Solicitud();
        this.tecnico=new Tecnico();
        this.tiposervicio=new TipoServicio();
    }

    @Override
    public String toString() {
        return "Servicio{" + "idServicio=" + idServicio + ", solicitud=" + solicitud + ", tecnico=" + tecnico + ", tiposervicio=" + tiposervicio + ", descripcion=" + descripcion + ", fechaAsignacion=" + fechaAsignacion + ", fechaGestion=" + fechaGestion + ", monto=" + monto + ", estado=" + getEstadoservicio() + '}';
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

    public TipoServicio getTiposervicio() {
        return tiposervicio;
    }

    public void setTiposervicio(TipoServicio tiposervicio) {
        this.tiposervicio = tiposervicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
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
/**
     * @return the estadoservicio
     */
    public EstadoServicio getEstadoservicio() {
        return estadoservicio;
    }

    /**
     * @param estadoservicio the estadoservicio to set
     */
    public void setEstadoservicio(EstadoServicio estadoservicio) {
        this.estadoservicio = estadoservicio;
    }
   

    
    
    
}
