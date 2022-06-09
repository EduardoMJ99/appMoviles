package com.example.proyectofinal.entidades;

import android.database.Cursor;

import java.sql.Date;

public class Reservacion {

    private Integer id;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer dias;
    private Date fechaCreacion;
    private char tipoHabitacion;
    private char estado;

    public Reservacion(Cursor cursor) {
        this.id = Integer.parseInt(cursor.getString(0));
        this.fechaInicio = Date.valueOf(cursor.getString(1));
        this.fechaFin = Date.valueOf(cursor.getString(2));
        this.dias = Integer.parseInt(cursor.getString(3));
        this.fechaCreacion = Date.valueOf(cursor.getString(4));
        this.tipoHabitacion = cursor.getString(5).charAt(0);
        this.estado = cursor.getString(6).charAt(0);
    }

    public Reservacion(){ }

    public Integer getIdReservacion() {
        return id;
    }

    public void setIdReservacion(Integer idReservacion) {
        this.id = idReservacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public char getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(char tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
