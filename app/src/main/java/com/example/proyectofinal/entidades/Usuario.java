package com.example.proyectofinal.entidades;

import android.database.Cursor;
import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String clave;
    private String correo;
    private String telefono;
    private char tipoUsuario;

    public Usuario(Cursor cursor) {
        this.id = Integer.parseInt(cursor.getString(0));
        this.nombre = cursor.getString(1);
        this.apellidos = cursor.getString(2);
        this.clave = cursor.getString(3);
        this.correo = cursor.getString(4);
        this.telefono = cursor.getString(5);
        this.tipoUsuario = cursor.getString(6).charAt(0);
    }

    public Usuario(){ }

    public Integer getiD() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public char getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(char tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
