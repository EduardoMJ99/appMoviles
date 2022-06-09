package com.example.proyectofinal.utilidades;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinal.R;

import java.util.HashMap;
import java.util.Map;

public class Utilidades {

    public static Boolean estanLlenados(EditText[] views){
        Boolean bandera = true;
        for (EditText view:
             views) {
            if(view.getText().toString().equals("")){
                bandera = false;
                break;
            }
        }
        return bandera;
    }

    public static void lanzarToast(AppCompatActivity cls, String mensaje, Integer idImagen){
        LayoutInflater inflater = cls.getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, cls.findViewById(R.id.customToast));

        Toast toast = new Toast(cls.getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        ImageView imgToast = layout.findViewById(R.id.imgImagenToast);
        TextView txtToast = layout.findViewById(R.id.txtMensajeToast);
        imgToast.setImageResource(idImagen);
        txtToast.setText(mensaje);
        toast.show();
    }

    public static Map<String, String> mensajeToastHash = new HashMap<String, String>(){
        {
            put("vacio","Favor de llenar todos los campos.");
            put("datosLoginIncorrecto","El correo y/o la contraseña son incorrectos.");
            put("correct","Operación ejecutada correctamente.");
            put("sinResultados","Ninguna coincidencia con tu búsqueda.");
        }
    };

    public static Map<String, Integer> imagenToastHash = new HashMap<String, Integer>(){
        {
            put("warning",R.drawable.warning);
            put("error", R.drawable.error);
            put("correct", R.drawable.accept);
        }
    };

    public static void ocultarTeclado(AppCompatActivity activity){
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
