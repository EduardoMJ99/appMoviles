package com.example.proyectofinal.utilidades;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.R;
import com.example.proyectofinal.entidades.Migrante;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.List;

public class MigranteAdaptador extends RecyclerView.Adapter<MigranteViewHolder> {

    List<Migrante> list = Collections.emptyList();
    Context context;
    //ClickListiner listiner;

    public MigranteAdaptador(List<Migrante> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MigranteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View migranteView = inflater.inflate(R.layout.card_migrante,parent,false);
        MigranteViewHolder migranteViewHolder = new MigranteViewHolder(migranteView);
        return migranteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MigranteViewHolder holder, int position) {
        holder.txtNombre.setText(list.get(position).getNombre());
        holder.txtTelefono.setText(list.get(position).getTelefono());
        holder.txtFechaNac.setText(list.get(position).getFechaNac());
        holder.txtNacion.setText(list.get(position).getIdNacion());
        holder.txtFechaLlega.setText(list.get(position).getFechaLlegada());
        holder.txtHoraLlega.setText(list.get(position).getHoraLlegada());
        holder.txtFechaConsul.setText(list.get(position).getFechaConsulado());
        holder.txtHoraConsul.setText(list.get(position).getHoraConsulado());
        holder.imgUsuario.setImageBitmap(colocarFoto(list.get(position).getRutaFotografia()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    private Bitmap colocarFoto(String ruta){
        try {
            FileInputStream fileInputStream = context.openFileInput(ruta);
            Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
            return bitmap;
        } catch (Exception e){ return null; }
    }
}
