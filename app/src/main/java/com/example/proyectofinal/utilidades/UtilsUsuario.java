package com.example.proyectofinal.utilidades;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofinal.entidades.Usuario;

public class UtilsUsuario {

    public static final String T_USUARIO="usuario";
    public static final String T_TIPOUSUARIO="tipousuario";

    public static final String C_ID="id";
    public static final String C_NOMBRE="nombre";
    public static final String C_APELLIDOS="apellidos";
    public static final String C_CLAVE="clave";
    public static final String C_CORREO="correo";
    public static final String C_TELEFONO="telefono";
    public static final String C_TIPOUSUARIO="tipousuario";
    public static final String C_NIVEL="nivel";

    public static String crearTablaUsuario(){
        return "CREATE TABLE "+T_USUARIO+" ("+
                C_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                C_NOMBRE+" TEXT, "+
                C_APELLIDOS+" TEXT, "+
                C_CLAVE+" TEXT, "+
                C_CORREO+" TEXT, "+
                C_TELEFONO+" TEXT, "+
                C_TIPOUSUARIO+" CHAR(1))";
    }

    public static String crearTablaTipoUsuario(){
        return "CREATE TABLE "+T_TIPOUSUARIO+" ("+
                C_ID+" CHAR(1), "+
                C_NOMBRE+" TEXT, "+
                C_NIVEL+" INTEGER)";
    }

    public static String insertarUsuarios(){
        return "INSERT INTO "+T_USUARIO+" ("+C_NOMBRE+", "+C_APELLIDOS+", "+C_CLAVE+", "+C_CORREO+", "+C_TELEFONO+", "+C_TIPOUSUARIO+") VALUES" +
                "('Usuario', 'Principal', 'clave1234', 'usurio@hotmail.com', '664-000-0000', 'S')," +
                "('Eduardo', 'Castro', 'prueba12', 'prueba@hotmail.com', '664-000-0000', 'A')," +
                "('Abner', 'Jesus', 'prueba12', 'prueba3@gmail.com', '664-000-0000', 'A')," +
                "('Griselda', 'Jacome', 'prueba12', 'prueba4@gmail.com', '664-000-0000', 'A')," +
                "('Eduardo', 'Morgado', 'clave1234', 'derechoscopio@gmail.com', '664-000-0000', 'S')";
    }
    
    public static String insertarTipoUsuarios(){
        return "INSERT INTO "+T_TIPOUSUARIO+" ("+C_ID+", "+C_NOMBRE+", "+C_NIVEL+") VALUES " +
                "('A', 'Administrador', 2)," +
                "('S', 'Superusuario', 1)";
    }

   public static Cursor consultarUsuario(SQLiteDatabase db, String[] correo){
        String[] campos = {C_ID, C_NOMBRE, C_APELLIDOS, C_CLAVE, C_CORREO, C_TELEFONO, C_TIPOUSUARIO};
        Cursor cursor = db.query(T_USUARIO,campos,C_CORREO+"=?",correo,null,null,null);
        return cursor;
   }
}
