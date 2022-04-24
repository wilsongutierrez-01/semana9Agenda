package com.gutierrez.semana9agenda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Cursor datosCelularesCursor = null;
    Celulares misCelulares;
    DB miDB;
    FloatingActionButton btn;
    ListView ltsCelulares;
    ArrayList<Celulares> celularesArrayList = new ArrayList<Celulares>();
    ArrayList<Celulares> celularesArrayListCopy = new ArrayList<Celulares>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnAgregarCelular);
        try {
            comprobarDatos();
        } catch (Exception e) {
            mostrarMsgToast(e.getMessage());
        }

        btn.setOnClickListener(v -> {
            agregarCelular("nuevo", new String[]{});
        });

        buscarCelular();
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater myMenu = getMenuInflater();
        myMenu.inflate(R.menu.menu, menu);
        AdapterView.AdapterContextMenuInfo mymenuInfo = (AdapterView.AdapterContextMenuInfo) menuInfo;
        datosCelularesCursor.moveToPosition(mymenuInfo.position);
        menu.setHeaderTitle(datosCelularesCursor.getString(1));
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        try {
            switch (item.getItemId()) {
                case R.id.mnxagregar:
                    agregarCelular("nuevo", new String[]{});
                    break;

                case R.id.mnxmodificar:
                    String[] datos = {
                            datosCelularesCursor.getString(0),//idCelular
                            datosCelularesCursor.getString(1),//Gama
                            datosCelularesCursor.getString(2),//Marca
                            datosCelularesCursor.getString(3),//Modelo
                            datosCelularesCursor.getString(4),//Precio
                            datosCelularesCursor.getString(5),//Fecha_venta

                    };
                    agregarCelular("modificar", datos);
                    break;

                case R.id.mnxeliminar:
                    eliminarCelular();
                    break;

            }
        } catch (Exception e) {
            mostrarMsgToast(e.getMessage());
        }
        return super.onContextItemSelected(item);
    }

    private void mostrarMsgToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    private void eliminarCelular() {
        try {
            AlertDialog.Builder confirmacion = new AlertDialog.Builder(MainActivity.this);
            confirmacion.setTitle("¿Seguro desea eliminar?");
            confirmacion.setMessage(datosCelularesCursor.getString(2));
            confirmacion.setPositiveButton("SI", ((dialog, which) -> {
                miDB = new DB(getApplicationContext(), "", null, 1);
                datosCelularesCursor = miDB.admin_amigo("eliminar", new String[]{datosCelularesCursor.getString(0)});
                comprobarDatos();
                mostrarMsgToast("Eliminado correcto");
                dialog.dismiss();
            }));
            confirmacion.setNegativeButton("NO", (dialog, which) -> {
                mostrarMsgToast("Se cancelo eliminar");
                dialog.dismiss();
            });
            confirmacion.create().show();

        } catch (Exception e) {
            mostrarMsgToast(e.getMessage());

        }

    }


    private void buscarCelular() {
        TextView temp = findViewById(R.id.txtBuscarCelulares);
        temp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                celularesArrayList.clear();
                if (temp.getText().toString().length() < 1) {
                    celularesArrayList.addAll(celularesArrayListCopy);
                } else {
                    for (Celulares AO : celularesArrayListCopy) {
                        String Gama = AO.getGama();
                        String Marca = AO.getMarca();
                        String Model = AO.getModelo();
                        String Precio = AO.getPrecio();
                        String Venta = AO.getFecha_venta();
                        String buscando = temp.getText().toString().trim().toLowerCase();
                        if (
                                            Gama.toLowerCase().contains(buscando) ||
                                            Marca.toLowerCase().contains(buscando) ||
                                            Model.toLowerCase().contains(buscando) ||
                                            Precio.toLowerCase().contains(buscando) ||
                                            Venta.toLowerCase().contains(buscando)
                        ) {
                            celularesArrayList.add(AO);
                        }
                    }
                }
                ImageAdapter celularEncontrado = new ImageAdapter(getApplicationContext(), celularesArrayList);
                ltsCelulares.setAdapter(celularEncontrado);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void agregarCelular(String accion, String[] datos) {
        try {
            Bundle parametroCelular = new Bundle();
            parametroCelular.putString("accion", accion);
            parametroCelular.putStringArray("datos", datos);
            Intent nuevoProducto = new Intent(getApplicationContext(), AddCelulares.class);
            nuevoProducto.putExtras(parametroCelular);
            startActivity(nuevoProducto);
        } catch (Exception e) {
            mostrarMsgToast(e.getMessage());
        }

    }

    private void comprobarDatos() {
        miDB = new DB(getApplicationContext(), "", null, 1);
        datosCelularesCursor = miDB.admin_amigo("consultar", null);

        if (datosCelularesCursor.moveToFirst()) {
            mostrarCelular();


        } else {
            mostrarMsgToast("Porfavor agregar datos");
            agregarCelular("nuevo", new String[]{});
        }

    }

    private void mostrarCelular() {
        ltsCelulares = findViewById(R.id.ltscelulares);
        celularesArrayList.clear();
        celularesArrayListCopy.clear();

        do {
            misCelulares = new Celulares(
                    datosCelularesCursor.getString(0),//idCelular
                    datosCelularesCursor.getString(1),//Gama
                    datosCelularesCursor.getString(2),//Marca
                    datosCelularesCursor.getString(3),//Modelo
                    datosCelularesCursor.getString(4),//Precio
                    datosCelularesCursor.getString(5)//Fecha_venta
            );
            celularesArrayList.add(misCelulares);
        } while (datosCelularesCursor.moveToNext());

        try {
            ImageAdapter adaptadorImagenes = new ImageAdapter(getApplicationContext(), celularesArrayList);
            ltsCelulares.setAdapter(adaptadorImagenes);

            registerForContextMenu(ltsCelulares);
            celularesArrayListCopy.addAll(celularesArrayList);

        } catch (Exception e) {
            mostrarMsgToast(e.getMessage());
        }

    };

}