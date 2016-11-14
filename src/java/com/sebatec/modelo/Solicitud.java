/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.modelo;

import com.sebatec.enums.EstadoSolicitud;
import java.sql.Date;

/**
 *
 * @author Mi Laptop
 */
public class Solicitud 
{
   private int idSolicitud;
   private Cliente cliente;
   private String descripcion;
   private Date fecha;
   private String observacion;
   private EstadoSolicitud estadoSolicitud;

   
   public Solicitud() {
        this.cliente=new Cliente();
    }
   
    public Solicitud(int idSolicitud, Cliente cliente, String descripcion, Date fecha, String observacion, EstadoSolicitud estadoSolicitud) {
        this.idSolicitud = idSolicitud;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.observacion = observacion;
        this.estadoSolicitud = estadoSolicitud;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", cliente=" + cliente + ", descripcion=" + descripcion + ", fecha=" + fecha + ", observacion=" + observacion + ", estadoSolicitud=" + estadoSolicitud + '}';
    }

   
   
   
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public EstadoSolicitud getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    

    
   
    }
    

