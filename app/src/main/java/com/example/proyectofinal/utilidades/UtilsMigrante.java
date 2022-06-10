package com.example.proyectofinal.utilidades;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofinal.entidades.Migrante;

public class UtilsMigrante {

    public static final String T_MIGRANTE="migrante";
    public static final String T_NACIONALIDAD="nacionalidad";

    public static final String C_ID="id";
    public static final String C_NOMBRE="nombre";
    public static final String C_TELEFONO="telefono";
    public static final String C_FECHANAC="fechanac";
    public static final String C_IDNACION="idnacion";
    public static final String C_FECHALLEGADA="fechallegada";
    public static final String C_HORALLEGADA="horallegada";
    public static final String C_FECHACONSULADO="fechaconsulado";
    public static final String C_HORACONSULADO="horaconsulado";
    public static final String C_FECHAREGISTRO="fecharegistro";
    public static final String C_NOMBREPAIS="nombrepais";
    public static final String C_RUTAFOTO="rutafoto";

    public static String crearTablaMigrante(){
        return "CREATE TABLE "+T_MIGRANTE+" ("+
                C_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                C_NOMBRE+" TEXT, "+
                C_TELEFONO+" TEXT, "+
                C_FECHANAC+" TEXT, "+
                C_IDNACION+" TEXT,"+
                C_FECHALLEGADA+" TEXT,"+
                C_HORALLEGADA+" TEXT, "+
                C_FECHACONSULADO+" TEXT, "+
                C_HORACONSULADO+" TEXT, "+
                C_FECHAREGISTRO+" TEXT, "+
                C_RUTAFOTO+" TEXT)";
    }

    public static String crearTablaNacionalidad(){
        return "CREATE TABLE "+T_NACIONALIDAD+" ("+
                C_ID+" TEXT, "+
                C_NOMBREPAIS+" TEXT)";
    }
    
    public static String insertarNaciones(){
        return "INSERT INTO "+T_NACIONALIDAD+" ("+C_ID+", "+C_NOMBREPAIS+") VALUES " +
                "('ARG', 'Argentina')," +
                "('ATG', 'Antigua y Barbuda')," +
                "('BHS', 'Bahamas')," +
                "('BLM', 'San Bartolome')," +
                "('BLZ', 'Belice')," +
                "('BOL', 'Bolivia')," +
                "('BRA', 'Brasil')," +
                "('BRB', 'Barbados')," +
                "('CHL', 'Chile')," +
                "('COL', 'Colombia')," +
                "('CRI', 'Costa Rica')," +
                "('CUB', 'Cuba')," +
                "('DMA', 'Dominica')," +
                "('ECU', 'Ecuador')," +
                "('GLP', 'Guadalupe')," +
                "('GRD', 'Granada')," +
                "('GTM', 'Guatemala')," +
                "('GUF', 'Guyana Francesa')," +
                "('HND', 'Honduras')," +
                "('HTI', 'Haití')," +
                "('JAM', 'Jamaica')," +
                "('KNA', 'San Cristobal y Nieves')," +
                "('LCA', 'Santa Lucia')," +
                "('MEX', 'Mexico')," +
                "('MTQ', 'Martinica')," +
                "('NIC', 'Nicaragua')," +
                "('PAN', 'Panama')," +
                "('PER', 'Peru')," +
                "('PRI', 'Puerto Rico')," +
                "('PRY', 'Paraguay')," +
                "('RDO', 'Republica Dominicana')," +
                "('SLV', 'El Salvador')," +
                "('SUR', 'Surinam')," +
                "('SXM', 'San Martin')," +
                "('TTO', 'Trinidad y Tobago')," +
                "('URY', 'Uruguay')," +
                "('VCT', 'San Vicente y las Granadinas')," +
                "('VEN', 'Venezuela')";
    }

    public static Cursor consultarNaciones(SQLiteDatabase db){
        Cursor cursor = db.rawQuery("SELECT * FROM "+T_NACIONALIDAD,null);
        return cursor;
    }

    public static Cursor consultarMigrantes(SQLiteDatabase db){
        Cursor cursor = db.rawQuery("SELECT * FROM "+T_MIGRANTE,null);
        return cursor;
    }

    public static Cursor consultarMigrante(SQLiteDatabase db, String nombre){
        Cursor cursor = db.rawQuery("SELECT * FROM "+T_MIGRANTE+" WHERE "+C_NOMBRE+" LIKE '%"+nombre+"%'",null);
        return cursor;
    }

    public static void insertarMigrante(SQLiteDatabase db, Migrante migrante){
        String insert="INSERT INTO "+T_MIGRANTE+" ("+
                C_NOMBRE+", "+
                C_TELEFONO+", "+
                C_FECHANAC+", "+
                C_IDNACION+", "+
                C_FECHALLEGADA+", "+
                C_HORALLEGADA+", "+
                C_FECHACONSULADO+", "+
                C_HORACONSULADO+", "+
                C_RUTAFOTO+") VALUES ('"+
                migrante.getNombre()+"', '"+
                migrante.getTelefono()+"', '"+
                migrante.getFechaNac()+"', '"+
                migrante.getIdNacion()+"', '"+
                migrante.getFechaLlegada()+"', '"+
                migrante.getHoraLlegada()+"', '"+
                migrante.getFechaConsulado()+"', '"+
                migrante.getHoraConsulado()+"', '"+
                migrante.getRutaFotografia()+"')";
        db.execSQL(insert);
    }

    public static void eliminarMigrante(SQLiteDatabase db, String id){
        String[] parametros = {id};
        db.delete(T_MIGRANTE, C_ID+"=?",parametros);
    }
}
