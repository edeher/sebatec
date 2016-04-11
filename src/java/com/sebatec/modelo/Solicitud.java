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
   private Cliente cliente;
   private String descripcion;
   private String observacion;
   private EstadoSo estado;

    public Solicitud(int idSolicitud, Cliente cliente, String descripcion, String observacion) {
        this.idSolicitud = idSolicitud;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.observacion = observacion;
    }

    public Solicitud(int idSolicitud, Cliente cliente, String descripcion, String observacion, EstadoSo estado) {
        this.idSolicitud = idSolicitud;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.estado = estado;
    }
    /////////////////crear cliente
    public Solicitud() {
        this.cliente=new Cliente();
    }
////////////////////////////////////////////
    public Solicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "idSolicitud=" + idSolicitud + ", cliente=" + cliente + ", descripcion=" + descripcion + ", observacion=" + observacion + ", estado=" + estado.getNom() + '}';
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public EstadoSo getEstado() {
        return estado;
    }

    public void setEstado(EstadoSo estado) {
        this.estado = estado;
    }

   
    }
    

