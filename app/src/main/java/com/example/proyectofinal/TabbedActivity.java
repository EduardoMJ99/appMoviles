package com.example.proyectofinal;

import android.os.Bundle;

import com.example.proyectofinal.entidades.Usuario;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.proyectofinal.ui.main.SectionsPagerAdapter;
import com.example.proyectofinal.databinding.ActivityTabbedBinding;

import org.w3c.dom.Text;

public class TabbedActivity extends AppCompatActivity {

    private ActivityTabbedBinding binding;
    Usuario usuario;
    private TabLayout tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTabbedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        ponerIconos();
        usuario = (Usuario) getIntent().getSerializableExtra("usuario");
        TextView txtTitulo = findViewById(R.id.txtTituloTabbed);
        txtTitulo.setText("Bienvenido, "+usuario.getNombre()+" "+usuario.getApellidos());
    }

    private void ponerIconos(){
        tabs.getTabAt(0).setIcon(R.drawable.home);
        tabs.getTabAt(1).setIcon(R.drawable.backpack);
        tabs.getTabAt(2).setIcon(R.drawable.booking);

    }
}