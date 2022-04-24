package com.gutierrez.semana9agenda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    Context miContext;
    static String nombreDB = "db_celulares";

    static String tbcelus = "CREATE TABLE tbcelus(idCelular INTEGER PRIMARY KEY AUTOINCREMENT, gama TEXT NOT NULL, marca TEXT NOT NULL, modelo TEXT NOT NULL, precio TEXT NOT NULL, fecha_enta TEXT NOT NULL)";

    public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombreDB, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase DataBase) {

        DataBase.execSQL(tbcelus);
    }

    @Override
    public void onUpgrade(SQLiteDatabase Database, int oldVersion, int newVersion) {

    }

    public Cursor admin_amigo (String accion, String [] datos){
        Cursor datosCursor = null;
        SQLiteDatabase sqlDataBaseW = getWritableDatabase();
        SQLiteDatabase sqlDataBaseR = getReadableDatabase();
        switch (accion){
            case "consultar":
                datosCursor = sqlDataBaseR.rawQuery("SELECT * FROM tbcelus ORDER BY gama", null);
                break;

            case "nuevo":
                sqlDataBaseW.execSQL("INSERT INTO tbcelus(gama, marca, modelo, precio, fecha_venta) VALUES ('"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', '"+datos[4]+"', '"+datos[5]+"')");
                break;

            case "modificar":
                try{
                    sqlDataBaseW.execSQL("UPDATE tbcelus SET gama = '"+datos[1]+"', marca = '"+datos[2]+"', modelo = '"+datos[3]+"', precio = '"+datos[4]+"', fecha_venta = '"+datos[5]+"' WHERE idCelular = '"+datos[0]+"'");

                }catch (Exception e){
                    Toast.makeText(miContext.getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                break;

            case "eliminar":
                sqlDataBaseW.execSQL("DELETE FROM tbcelus WHERE idCelular = '"+datos[0]+"'");

        }

        return datosCursor;
    }
}
