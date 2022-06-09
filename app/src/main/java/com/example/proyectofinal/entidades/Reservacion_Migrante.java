package com.example.proyectofinal.entidades;

import android.database.Cursor;

public class Reservacion_Migrante {

    private Integer id;
    private Integer idReser;
    private Integer idMigra;

    public Reservacion_Migrante(Cursor cursor) {
        this.id = Integer.parseInt(cursor.getString(0));
        this.idReser =Integer.parseInt(cursor.getString(1));
        this.idMigra = Integer.parseInt(cursor.getString(2));
    }

    public Reservacion_Migrante() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdReser() {
        return idReser;
    }

    public void setIdReser(Integer idReser) {
        this.idReser = idReser;
    }

    public Integer getIdMigra() {
        return idMigra;
    }

    public void setIdMigra(Integer idMigra) {
        this.idMigra = idMigra;
    }
}
