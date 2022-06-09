package com.example.proyectofinal.entidades;

import android.database.Cursor;

public class TipoHabitacion {

    private char id;
    private String tipo;
    private float costo;

    public TipoHabitacion(Cursor cursor) {
        this.id = cursor.getString(0).charAt(0);
        this.tipo = cursor.getString(1);
        this.costo = cursor.getFloat(2);
    }

    public TipoHabitacion() { }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
