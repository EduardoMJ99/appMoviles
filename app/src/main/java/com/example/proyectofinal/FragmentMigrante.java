package com.example.proyectofinal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinal.entidades.Migrante;
import com.example.proyectofinal.utilidades.ConexionSQLiteHelper;
import com.example.proyectofinal.utilidades.MigranteAdaptador;
import com.example.proyectofinal.utilidades.Utilidades;
import com.example.proyectofinal.utilidades.UtilsMigrante;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentMigrante extends Fragment {

    MigranteAdaptador adapter;
    RecyclerView recyclerView;
    FloatingActionButton btnBotonMas;
    ConexionSQLiteHelper conn;
    List<Migrante> listaMigrantes;
    Button btnBuscar;
    List<Migrante> list;
    EditText txtBuscar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utilidades.ocultarTeclado((AppCompatActivity) getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Utilidades.ocultarTeclado((AppCompatActivity) getActivity());
        return inflater.inflate(R.layout.fragment_migrante, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Utilidades.ocultarTeclado((AppCompatActivity) getActivity());
        conn = new ConexionSQLiteHelper(getView().getContext(),
                "derechoscopio",
                null,
                1);

        txtBuscar = getView().findViewById(R.id.txtBuscarMigrante);
        recyclerView = getView().findViewById(R.id.recyclerMigrante);
        list = new ArrayList<>();
        list = getData();
        llenarRecycler();
        btnBuscar = getView().findViewById(R.id.btnBuscarMigrante);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Utilidades.estanLlenados(new EditText[]{txtBuscar})){
                    list = new ArrayList<>();
                    list = getDataSearching(txtBuscar.getText().toString());
                    llenarRecycler();
                } else{
                    list = new ArrayList<>();
                    list = getData();
                    llenarRecycler();
                }
                if(list.size()<=0){
                    Utilidades.lanzarToast((AppCompatActivity) getActivity(),
                            Utilidades.mensajeToastHash.get("sinResultados"),
                            Utilidades.imagenToastHash.get("error"));
                } else {
                    Utilidades.lanzarToast((AppCompatActivity) getActivity(),
                            Utilidades.mensajeToastHash.get("correct"),
                            Utilidades.imagenToastHash.get("correct"));
                }
                Utilidades.ocultarTeclado((AppCompatActivity) getActivity());
            }
        });
        btnBotonMas = getView().findViewById(R.id.fabMigrante);
        btnBotonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent = new Intent(getView().getContext(),AgregarMigrante.class);
                startActivity(objIntent);
            }
        });
    }

    private List<Migrante> getData(){
        SQLiteDatabase db = conn.getReadableDatabase();
        listaMigrantes = new ArrayList<Migrante>();
        Cursor cursor = UtilsMigrante.consultarMigrantes(db);
        while (cursor.moveToNext()){
            listaMigrantes.add(new Migrante(cursor));
        }
        return listaMigrantes;
    }

    private List<Migrante> getDataSearching(String nombre){
        SQLiteDatabase db = conn.getReadableDatabase();
        listaMigrantes = new ArrayList<Migrante>();
        Cursor cursor = UtilsMigrante.consultarMigrante(db, nombre);
        while (cursor.moveToNext()){
            listaMigrantes.add(new Migrante(cursor));
        }
        return listaMigrantes;
    }

    @Override
    public void onResume() {
        super.onResume();
        list = new ArrayList<>();
        list = getData();
        llenarRecycler();
    }

    private void llenarRecycler(){
        adapter = new MigranteAdaptador(list,getView().getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getView().getContext()));
    }
}