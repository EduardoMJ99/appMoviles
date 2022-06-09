package com.example.proyectofinal.entidades;

import android.database.Cursor;

public class TipoUsuario {

    private char id;
    private String nombre;
    private Integer nivel;

    public TipoUsuario(Cursor cursor) {
        this.id = cursor.getString(0).charAt(0);
        this.nombre = cursor.getString(1);
        this.nivel = Integer.parseInt(cursor.getString(2));
    }

    public TipoUsuario() { }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
