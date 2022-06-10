package com.example.proyectofinal.utilidades;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.R;

public class MigranteViewHolder extends RecyclerView.ViewHolder {
    ImageView imgUsuario;
    TextView txtNombre, txtTelefono, txtFechaNac, txtNacion;
    TextView txtFechaLlega, txtHoraLlega, txtFechaConsul, txtHoraConsul;
    Button btnEditar, btnEliminar;
    View view;
    public MigranteViewHolder(@NonNull View itemView) {
        super(itemView);
        imgUsuario = itemView.findViewById(R.id.imgCardMigrante);
        txtNombre = itemView.findViewById(R.id.txtNombreCardMigrante);
        txtTelefono = itemView.findViewById(R.id.txtTelefonoCardMigrante);
        txtFechaNac = itemView.findViewById(R.id.txtFechaNacCardMigrante);
        txtNacion = itemView.findViewById(R.id.txtNacionCardMigrante);
        txtFechaLlega = itemView.findViewById(R.id.txtFechaLlegaCardMigrante);
        txtHoraLlega = itemView.findViewById(R.id.txtHoraLlegadaCardMigrante);
        txtFechaConsul = itemView.findViewById(R.id.txtFechaConsuladoCardMigrante);
        txtHoraConsul = itemView.findViewById(R.id.txtHoraConsuladoCardMigrante);
        btnEditar = itemView.findViewById(R.id.btnEditarMigrante);
        btnEliminar = itemView.findViewById(R.id.btnEliminarMigrante);
        view = itemView;
    }
}
