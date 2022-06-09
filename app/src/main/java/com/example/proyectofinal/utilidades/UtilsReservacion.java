package com.example.proyectofinal.utilidades;

public class UtilsReservacion {

    public static final String T_RESERVACION="reservacion";
    public static final String T_ESTADO="estado";
    public static final String T_TIPOHABITACION="tipohabitacion";
    public static final String T_RESERVACIONMIGRANTE="reservacion_migrante";

    public static final String C_ID="id";
    public static final String C_FECHAINICIO="fechainicio";
    public static final String C_FECHAFIN="fechafin";
    public static final String C_DIAS="dias";
    public static final String C_FECHACREACION="fechacreacion";
    public static final String C_TIPOHABITACION="tipohabitacion";
    public static final String C_ESTADO="estado";
    public static final String C_TIPO="tipo";
    public static final String C_COSTO="costo";
    public static final String C_IDRESER="idreser";
    public static final String C_IDMIGRA="idmigra";

    public static String crearTablaReservacion(){
        return "CREATE TABLE "+T_RESERVACION+" ("+
                C_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                C_FECHAINICIO+" DATE, "+
                C_FECHAFIN+" DATE, "+
                C_DIAS+" INTEGER, "+
                C_FECHACREACION+" DATE, "+
                C_TIPOHABITACION+" CHAR(1), "+
                C_ESTADO+" CHAR(1))";
    }

    public static String crearTablaEstado(){
        return "CREATE TABLE "+T_ESTADO+" ("+
                C_ID+" CHAR(1), "+
                C_ESTADO+" TEXT)";
    }

    public static String crearTablaTipoHabitacion(){
        return "CREATE TABLE "+T_TIPOHABITACION+" ("+
                C_ID+" CHAR(1), "+
                C_TIPO+" TEXT, "+
                C_COSTO+" FLOAT)";
    }

    public static String crearTablaReservacionMigrante(){
        return "CREATE TABLE "+T_RESERVACIONMIGRANTE+" ("+
                C_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                C_IDRESER+" INTEGER, "+
                C_IDMIGRA+" INTEGER)";
    }
    
    public static String insertarTipoHabitaciones(){
        return "INSERT INTO "+T_TIPOHABITACION+" ("+C_ID+", "+C_TIPO+", "+C_COSTO+") VALUES " +
                "('I', 'Indvidual', 300)," +
                "('D', 'Doble', 400)," +
                "('T', 'Triple', 500)," +
                "('O', 'Otro', 0)";
    }

    public static String insertarEstados(){
        return "INSERT INTO "+T_ESTADO+" ("+C_ID+", "+C_ESTADO+") VALUES " +
                "('E', 'En espera')," +
                "('F', 'Finalizada')," +
                "('P', 'En progreso')";
    }
}
