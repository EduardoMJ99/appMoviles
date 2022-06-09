package com.example.proyectofinal.entidades;

import android.database.Cursor;

public class Estado {

    private char id;
    private String estado;

    public Estado(Cursor cursor) {
        this.id = cursor.getString(0).charAt(0);
        this.estado = cursor.getString(1);
    }

    public Estado() {}

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
