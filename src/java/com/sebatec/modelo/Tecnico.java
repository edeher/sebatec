/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebatec.modelo;

import com.sebatec.enums.Estados;
import com.sebatec.enums.TipoUsuario;

/**
 *
 * @author Mi Laptop
 */
public class Tecnico extends Persona{
    private int idTecnico;
    private String profesion;
    private String especialidad;
    private String usuario;
    private String pasword;
    private TipoUsuario tipousuario;

    public Tecnico() {
        
    }

    public Tecnico(int idTecnico, String profesion, String especialidad, String usuario, String password, TipoUsuario tipousuario , int idPersona, String nombre, String apellido, String dni, String direccion, String telefono, String email, Estados estado) {
        super(idPersona, nombre, apellido, dni, direccion, telefono, email, estado);
        this.idTecnico = idTecnico;
        this.profesion = profesion;
        this.especialidad = especialidad;
        this.usuario = usuario;
        this.pasword = password;
        this.tipousuario = tipousuario;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "idTecnico=" + idTecnico + ", profesion=" + profesion + ", especialidad=" + especialidad + ", usuario=" + usuario + ", password=" + pasword + ", tipousuario=" + tipousuario +  ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return pasword;
    }

    public void setPassword(String password) {
        this.pasword = password;
    }

    public TipoUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }
    
    


    
}
