package com.example.tplaboratorio;

import java.util.Date;

public class JugadorModel {
    private String id;
    private String nombre;
    private String apellido;
    private String nacionalidad;
    private String club;
    private String posicion;
    private String pie;
    private Integer numero;
    private String imagen;
    private String fecha_nacimiento;
    private Float estatura;


    public JugadorModel() {
    }

    public JugadorModel(String id, String nombre, String apellido, String nacionalidad, String club, String posicion, String pie, Integer numero, String imagen, String fecha_nacimiento, Float estatura) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.club = club;
        this.posicion = posicion;
        this.pie = pie;
        this.numero = numero;
        this.imagen = imagen;
        this.fecha_nacimiento = fecha_nacimiento;
        this.estatura = estatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getPie() {
        return pie;
    }

    public void setPie(String pie) {
        this.pie = pie;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Float getEstatura() {
        return estatura;
    }

    public void setEstatura(Float estatura) {
        this.estatura = estatura;
    }
}
