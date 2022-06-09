package com.example.proyectofinal;

import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.proyectofinal.entidades.Migrante;
import com.example.proyectofinal.entidades.Nacionalidad;
import com.example.proyectofinal.utilidades.ConexionSQLiteHelper;
import com.example.proyectofinal.utilidades.DatePickerFragment;
import com.example.proyectofinal.utilidades.TimePickerFragment;
import com.example.proyectofinal.utilidades.Utilidades;
import com.example.proyectofinal.utilidades.UtilsMigrante;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AgregarMigrante extends AppCompatActivity {

    EditText txtFechaNac, txtFechaLlegada, txtFechaConsul;
    EditText txtHoraLlegada, txtHoraConsul;
    EditText txtNombre, txtTelefono;
    Spinner spiNaciones;
    ImageView imgFotografia;
    ArrayList<String> listaSpinner;
    ArrayList<Nacionalidad> listaNaciones;
    ConexionSQLiteHelper conn;
    final int CAPTURA_IMAGEN = 1;
    String rutaFotografia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_migrante);
        setTitle("Registro nuevo migrante");

        txtFechaNac = findViewById(R.id.txtFechaNacAgregarMigrante);
        txtFechaLlegada = findViewById(R.id.txtFechaLlegaAgregarMigrante);
        txtFechaConsul = findViewById(R.id.txtFechaConsulAgregarMigrante);
        txtHoraLlegada = findViewById(R.id.txtHoraLlegadaAgregarMigrante);
        txtHoraConsul = findViewById(R.id.txtHoraConsulAgregarMigrante);
        spiNaciones = findViewById(R.id.spiNacionalidad);
        imgFotografia = findViewById(R.id.imgFotografia);
        imgFotografia.setTag(R.drawable.user);
        txtNombre = findViewById(R.id.txtNombreAgregarMigrante);
        txtTelefono = findViewById(R.id.txtTelefonoAgregarMigrante);

        conn = new ConexionSQLiteHelper(this,
                "derechoscopio",
                null,
                1);
        consultarNacionalidades();
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                listaSpinner);
        spiNaciones.setAdapter(adapter);
        spiNaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        txtFechaNac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFechaNac);
            }
        });
        txtFechaLlegada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFechaLlegada);
            }
        });
        txtFechaConsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFechaConsul);
            }
        });
        txtHoraLlegada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(txtHoraLlegada);
            }
        });
        txtHoraConsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePickerDialog(txtHoraConsul);
            }
        });
    }
    private void showDatePickerDialog(final EditText editText){
        DialogFragment dialogFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = twoDigits(day) +"/"+twoDigits(month)+"/"+year;
                editText.setText(selectedDate);
            }
        });
        dialogFragment.show(getSupportFragmentManager(),"date-picker");
    }

    private void showTimePickerDialog(final EditText editText){
        DialogFragment dialogFragment = TimePickerFragment.newInstance(new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                final String selectedTime = twoDigits(hour)+":"+twoDigits(min);
                editText.setText(selectedTime);
            }
        });
        dialogFragment.show(getSupportFragmentManager(),"time-picker");
    }

    private String twoDigits(int n){
        return (n<=9)?("0"+n):String.valueOf(n);
    }

    public void onClickButtons(View view){
        switch (view.getId()){
            case R.id.btnGuardar:
                guardarMigrante();
                break;
            case R.id.btnCancelar:
                onBackPressed();
                break;
            case R.id.btnTomarFoto:
                tomarFotografia();
                break;
        }
    }

    private void consultarNacionalidades(){
        SQLiteDatabase db = conn.getReadableDatabase();
        listaNaciones = new ArrayList<Nacionalidad>();
        Cursor cursor = UtilsMigrante.consultarNaciones(db);
        while (cursor.moveToNext()){
            listaNaciones.add(new Nacionalidad(cursor));
        }
        obtenerLista();
    }

    private void obtenerLista(){
        listaSpinner = new ArrayList<String>();
        listaSpinner.add("Seleccione");
        for (Nacionalidad nacionalidad:
             listaNaciones) {
            listaSpinner.add(nacionalidad.getId()+" - "+nacionalidad.getNombrePais());
        }
    }

    public void tomarFotografia(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAPTURA_IMAGEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURA_IMAGEN && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            imgFotografia.setImageBitmap(bitmap);
            try {
                FileOutputStream objFile = openFileOutput(crearNombreArchivo(), Context.MODE_PRIVATE);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, objFile);
                objFile.close();
            } catch (Exception e) {
                Toast.makeText(this, "Ocurrio un error.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String crearNombreArchivo() {
        String fecha = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        rutaFotografia = fecha+".jpg";
        return rutaFotografia;
    }

    public void guardarMigrante(){
        if(Utilidades.estanLlenados(new EditText[]{txtNombre, txtTelefono,txtFechaNac,txtFechaLlegada,txtFechaConsul,txtHoraLlegada,txtHoraConsul})){
            SQLiteDatabase db = conn.getWritableDatabase();
            UtilsMigrante.insertarMigrante(db, new Migrante(new String[]{txtNombre.getText().toString(), txtTelefono.getText().toString(), txtFechaNac.getText().toString(), spiNaciones.getSelectedItem().toString().substring(0,2),txtFechaLlegada.getText().toString(), txtHoraLlegada.getText().toString(),txtFechaConsul.getText().toString(), txtHoraConsul.getText().toString(), rutaFotografia}));
            Utilidades.lanzarToast(AgregarMigrante.this,
                    Utilidades.mensajeToastHash.get("correct"),
                    Utilidades.imagenToastHash.get("correct"));
            onBackPressed();
        } else {
            Utilidades.lanzarToast(AgregarMigrante.this,
                    Utilidades.mensajeToastHash.get("vacio"),
                    Utilidades.imagenToastHash.get("warning"));
        }
    }
}