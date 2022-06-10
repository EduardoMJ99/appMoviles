package com.example.proyectofinal;

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
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EditarMigrante extends AppCompatActivity {

    EditText txtFechaNac, txtFechaLlegada, txtFechaConsul;
    EditText txtHoraLlegada, txtHoraConsul;
    EditText txtNombre, txtTelefono;
    Button btnCancelar, btnGuardar, btnTomarFoto;
    Spinner spiNaciones;
    ImageView imgFotografia;
    ArrayList<String> listaSpinner;
    ArrayList<Nacionalidad> listaNaciones;
    ConexionSQLiteHelper conn;
    final int CAPTURA_IMAGEN = 1;
    String rutaFotografia;
    Boolean fotografiaTomada = false;
    Integer spinnerPosition;
    Migrante migrante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_migrante);
        setTitle("Editando registro existente...");

        conn = new ConexionSQLiteHelper(this,
                "derechoscopio",
                null,
                1);
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

        consultarNacionalidades();
        consultarMigrante();
        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                listaSpinner);
        spiNaciones.setAdapter(adapter);
        spinnerPosition = adapter.getPosition(migrante.getIdNacion());
        llenarViews();
        spiNaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarMigrante();
            }
        });

        btnTomarFoto = findViewById(R.id.btnTomarFoto);
        btnTomarFoto.setText("CAMBIAR FOTO");
        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomarFotografia();
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
            listaSpinner.add(nacionalidad.getId());
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
        fotografiaTomada = true;
        return rutaFotografia;
    }

    public void guardarMigrante(){
        actualizarMigrante();
        if(Utilidades.estanLlenados(new EditText[]{txtNombre, txtTelefono,txtFechaNac,txtFechaLlegada,txtFechaConsul,txtHoraLlegada,txtHoraConsul})){
            SQLiteDatabase db = conn.getWritableDatabase();
            UtilsMigrante.actualizarMigrante(db, migrante);
            Utilidades.lanzarToast(EditarMigrante.this,
                    Utilidades.mensajeToastHash.get("correct"),
                    Utilidades.imagenToastHash.get("correct"));
            onBackPressed();
        } else {
            Utilidades.lanzarToast(EditarMigrante.this,
                    Utilidades.mensajeToastHash.get("vacio"),
                    Utilidades.imagenToastHash.get("warning"));
        }
    }

    public void consultarMigrante(){
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor cursor = UtilsMigrante.consultarMigrante(db, Integer.parseInt(getIntent().getStringExtra("id")));
        cursor.moveToFirst();
        migrante = new Migrante(cursor);
    }

    public void llenarViews(){
        txtNombre.setText(migrante.getNombre());
        txtTelefono.setText(migrante.getTelefono());
        txtFechaNac.setText(migrante.getFechaNac());
        txtFechaLlegada.setText(migrante.getFechaLlegada());
        txtHoraLlegada.setText(migrante.getHoraLlegada());
        txtFechaConsul.setText(migrante.getFechaConsulado());
        txtHoraConsul.setText(migrante.getHoraConsulado());
        imgFotografia.setImageBitmap(colocarFoto(migrante.getRutaFotografia()));
        rutaFotografia = migrante.getRutaFotografia();
        spiNaciones.setSelection(spinnerPosition);
    }

    private Bitmap colocarFoto(String ruta){
        try {
            FileInputStream fileInputStream = getApplicationContext().openFileInput(ruta);
            Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
            return bitmap;
        } catch (Exception e){ return null; }
    }

    public void actualizarMigrante(){
        migrante.setNombre(txtNombre.getText().toString());
        migrante.setTelefono(txtTelefono.getText().toString());
        migrante.setFechaNac(txtFechaNac.getText().toString());
        migrante.setFechaLlegada(txtFechaLlegada.getText().toString());
        migrante.setHoraLlegada(txtHoraLlegada.getText().toString());
        migrante.setFechaConsulado(txtFechaConsul.getText().toString());
        migrante.setHoraConsulado(txtHoraConsul.getText().toString());
        migrante.setIdNacion(spiNaciones.getSelectedItem().toString().substring(0,3));
        migrante.setRutaFotografia(rutaFotografia);
    }
}