package com.example.proyectofinal.entidades;

import android.database.Cursor;

public class Migrante {

    private Integer id;
    private String nombre;
    private String telefono;
    private String fechaNac;
    private String idNacion;
    private String fechaLlegada;
    private String horaLlegada;
    private String fechaConsulado;
    private String horaConsulado;
    private String fechaRegistro;
    private String rutaFotografia;

    public Migrante(Cursor cursor) {
        this.id = Integer.parseInt(cursor.getString(0));
        this.nombre = cursor.getString(1);
        this.telefono = cursor.getString(2);
        this.fechaNac = cursor.getString(3);
        this.idNacion = cursor.getString(4);
        this.fechaLlegada = cursor.getString(5);
        this.horaLlegada = cursor.getString(6);
        this.fechaConsulado = cursor.getString(7);
        this.horaConsulado = cursor.getString(8);
        this.fechaRegistro = cursor.getString(9);
        this.rutaFotografia = cursor.getString(10);
    }

    public Migrante(int i) {
        this.id = 0;
        this.nombre = "Eduardo";
        this.telefono = "6640000000";
        this.fechaNac = "1999-03-05";
        this.idNacion = "MEX";
        this.fechaLlegada = "1999-03-05";
        this.horaLlegada = "04:04:04";
        this.fechaConsulado = "1999-03-05";
        this.horaConsulado = "04:04:04";
        this.fechaRegistro = "1999-03-05";
    }

    public Migrante(String[] valores) {
        this.id = 0;
        this.nombre = valores[0];
        this.telefono = valores[1];
        this.fechaNac = valores[2];
        this.idNacion = valores[3];
        this.fechaLlegada = valores[4];
        this.horaLlegada = valores[5];
        this.fechaConsulado = valores[6];
        this.horaConsulado = valores[7];
        this.rutaFotografia = valores[8];
    }

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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getIdNacion() {
        return idNacion;
    }

    public void setIdNacion(String idNacion) {
        this.idNacion = idNacion;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getFechaConsulado() {
        return fechaConsulado;
    }

    public void setFechaConsulado(String fechaConsulado) {
        this.fechaConsulado = fechaConsulado;
    }

    public String getHoraConsulado() {
        return horaConsulado;
    }

    public void setHoraConsulado(String horaConsulado) {
        this.horaConsulado = horaConsulado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getRutaFotografia() {
        return rutaFotografia;
    }

    public void setRutaFotografia(String rutaFotografia) {
        this.rutaFotografia = rutaFotografia;
    }
}
