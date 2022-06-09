package com.example.proyectofinal.entidades;

import android.database.Cursor;

import java.sql.Date;
import java.sql.Time;

public class Migrante {

    private Integer id;
    private String nombre;
    private String telefono;
    private Date fechaNac;
    private String idNacion;
    private Date fechaLlegada;
    private Time horaLlegada;
    private Date fechaConsulado;
    private Time horaConsulado;
    private Date fechaRegistro;

    public Migrante(Cursor cursor) {
        this.id = Integer.parseInt(cursor.getString(0));
        this.nombre = cursor.getString(1);
        this.telefono = cursor.getString(2);
        this.fechaNac = Date.valueOf(cursor.getString(3));
        this.idNacion = cursor.getString(4);
        this.fechaLlegada = Date.valueOf(cursor.getString(5));
        this.horaLlegada = Time.valueOf(cursor.getString(6));
        this.fechaConsulado = Date.valueOf(cursor.getString(7));
        this.horaConsulado = Time.valueOf(cursor.getString(8));
        this.fechaRegistro = Date.valueOf(cursor.getString(9));
    }

    public Migrante() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getIdNacion() {
        return idNacion;
    }

    public void setIdNacion(String idNacion) {
        this.idNacion = idNacion;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getFechaConsulado() {
        return fechaConsulado;
    }

    public void setFechaConsulado(Date fechaConsulado) {
        this.fechaConsulado = fechaConsulado;
    }

    public Time getHoraConsulado() {
        return horaConsulado;
    }

    public void setHoraConsulado(Time horaConsulado) {
        this.horaConsulado = horaConsulado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
