package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.proyectofinal.entidades.Usuario;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Usuario objUsuario = (Usuario)getIntent().getSerializableExtra("usuario");
        //setTitle("Bienvenido, "+objUsuario.getNombre()+" "+objUsuario.getApellidos());
        setTitle("Bienvenido, Eduardo Morgado");
    }
}