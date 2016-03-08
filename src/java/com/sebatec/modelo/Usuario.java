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
public class Usuario {
   private int  idUsuario;
   private int idTecnico;
   private String usuario;
   private String password;
   private String tipo;
   private Estados estado;

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public Usuario(int idUsuario, int idTecnico, String usuario, String password, String tipo, Estados estado) {
        this.idUsuario = idUsuario;
        this.idTecnico = idTecnico;
        this.usuario = usuario;
        this.password = password;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", idTecnico=" + idTecnico + ", usuario=" + usuario + ", password=" + password + ", tipo=" + tipo + ", estado=" + estado + '}';
    }

   
    
}
