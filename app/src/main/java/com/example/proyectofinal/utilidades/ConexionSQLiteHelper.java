package com.example.proyectofinal.utilidades;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public ConexionSQLiteHelper(@Nullable Context context,
                                @Nullable String name,
                                @Nullable SQLiteDatabase.CursorFactory factory,
                                int version){
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UtilsUsuario.crearTablaUsuario());
        sqLiteDatabase.execSQL(UtilsUsuario.crearTablaTipoUsuario());
        sqLiteDatabase.execSQL(UtilsReservacion.crearTablaReservacion());
        sqLiteDatabase.execSQL(UtilsReservacion.crearTablaReservacionMigrante());
        sqLiteDatabase.execSQL(UtilsReservacion.crearTablaEstado());
        sqLiteDatabase.execSQL(UtilsReservacion.crearTablaTipoHabitacion());
        sqLiteDatabase.execSQL(UtilsMigrante.crearTablaMigrante());
        sqLiteDatabase.execSQL(UtilsMigrante.crearTablaNacionalidad());
        Log.i("SQL","Creacion correcta de la DB.");
        sqLiteDatabase.execSQL(UtilsMigrante.insertarNaciones());
        sqLiteDatabase.execSQL(UtilsUsuario.insertarUsuarios());
        sqLiteDatabase.execSQL(UtilsUsuario.insertarTipoUsuarios());
        sqLiteDatabase.execSQL(UtilsReservacion.insertarTipoHabitaciones());
        sqLiteDatabase.execSQL(UtilsReservacion.insertarEstados());
        Log.i("SQL","Insercion correcta en la DB.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UtilsUsuario.T_USUARIO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UtilsUsuario.T_TIPOUSUARIO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UtilsReservacion.T_RESERVACION);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UtilsReservacion.T_RESERVACIONMIGRANTE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UtilsReservacion.T_ESTADO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UtilsReservacion.T_TIPOHABITACION);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UtilsMigrante.T_MIGRANTE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+UtilsMigrante.T_NACIONALIDAD);
        onCreate(sqLiteDatabase);
    }
}
