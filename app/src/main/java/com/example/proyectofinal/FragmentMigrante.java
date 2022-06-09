package com.example.proyectofinal;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyectofinal.entidades.Migrante;
import com.example.proyectofinal.utilidades.MigranteAdaptador;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMigrante#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMigrante extends Fragment {

    MigranteAdaptador adapter;
    RecyclerView recyclerView;
    FloatingActionButton btnBotonMas;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentMigrante() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMigrante.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMigrante newInstance(String param1, String param2) {
        FragmentMigrante fragment = new FragmentMigrante();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_migrante, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<Migrante> list = new ArrayList<>();
        list = getData();
        recyclerView = getView().findViewById(R.id.recyclerMigrante);
        btnBotonMas = getView().findViewById(R.id.fabMigrante);
        btnBotonMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent objIntent = new Intent(getView().getContext(),AgregarMigrante.class);
                startActivity(objIntent);
            }
        });

        adapter = new MigranteAdaptador(list,getView().getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getView().getContext()));
    }

    private List<Migrante> getData(){
        List<Migrante> list = new ArrayList<>();
        list.add(new Migrante(0));
        list.add(new Migrante(0));
        list.add(new Migrante(0));
        return list;
    }
}