/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.modelo;

import com.sebatec.enums.Estados;



/**
 *
 * @author Mi Laptop
 */
public class TipoServicio {
    private int idTipoServicio;
    private String descripcion;
    private Estados estado;

    /**
     * @return the idTipoServicio
     */
    public int getIdTipoServicio() {
        return idTipoServicio;
    }

    /**
     * @param idTipoServicio the idTipoServicio to set
     */
    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
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

    public TipoServicio(int idTipoServicio, String descripcion, Estados estado) {
        this.idTipoServicio = idTipoServicio;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public TipoServicio() {
    }

    @Override
    public String toString() {
        return "TipoServicio{" + "idTipoServicio=" + idTipoServicio + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

    
}
