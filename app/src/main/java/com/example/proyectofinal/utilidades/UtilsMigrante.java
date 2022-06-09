package com.example.proyectofinal.utilidades;

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

    public static String crearTablaMigrante(){
        return "CREATE TABLE "+T_MIGRANTE+" ("+
                C_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                C_NOMBRE+" TEXT, "+
                C_TELEFONO+" TEXT, "+
                C_FECHANAC+" DATE, "+
                C_IDNACION+" TEXT,"+
                C_FECHALLEGADA+" DATE,"+
                C_HORALLEGADA+" TIME, "+
                C_FECHACONSULADO+" DATE, "+
                C_HORACONSULADO+" TIME, "+
                C_FECHAREGISTRO+" DATE)";
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
}
