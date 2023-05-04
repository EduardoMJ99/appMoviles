package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyectofinal.entidades.Usuario;
import com.example.proyectofinal.utilidades.ConexionSQLiteHelper;
import com.example.proyectofinal.utilidades.Utilidades;
import com.example.proyectofinal.utilidades.UtilsUsuario;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    ConexionSQLiteHelper conn;
    EditText txtCorreo, txtClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        txtCorreo = findViewById(R.id.txtCorreo);
        txtClave = findViewById(R.id.txtClave);
        conn = new ConexionSQLiteHelper(this,
                "derechoscopio",
                null,
                1);
    }

    public void onClick(View view){
        if(Utilidades.estanLlenados(new EditText[]{txtCorreo, txtClave})) {
            SQLiteDatabase db = conn.getReadableDatabase();
            try {
                Cursor cursor = UtilsUsuario.consultarUsuario(db, new String[]{txtCorreo.getText().toString()});
                cursor.moveToFirst();
                if(cursor.getString(3).equals(txtClave.getText().toString())){
                    Usuario objUsuario = new Usuario(cursor);
                    Intent objIntent = new Intent(MainActivity.this,TabbedActivity.class);
                    objIntent.putExtra("usuario",objUsuario);
                    startActivity(objIntent);
                } else {
                    Utilidades.lanzarToast(MainActivity.this,
                            Utilidades.mensajeToastHash.get("datosLoginIncorrecto"),
                            Utilidades.imagenToastHash.get("error"));
                }
            } catch (Exception e){
                Utilidades.lanzarToast(MainActivity.this,
                        Utilidades.mensajeToastHash.get("datosLoginIncorrecto"),
                        Utilidades.imagenToastHash.get("error"));
            }

        }else{
            Utilidades.lanzarToast(MainActivity.this,
                    Utilidades.mensajeToastHash.get("vacio"),
                    Utilidades.imagenToastHash.get("warning"));
        }
    }
}