package com.example.proyectofinal.entidades;

import android.database.Cursor;

public class Nacionalidad {

    private String id;
    private String nombrePais;

    public Nacionalidad(Cursor cursor) {
        this.id = cursor.getString(0);
        this.nombrePais = cursor.getString(1);
    }

    public Nacionalidad(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
}
