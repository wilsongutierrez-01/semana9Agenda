package com.gutierrez.semana9agenda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddCelulares extends AppCompatActivity {
    FloatingActionButton btnAtras;
    String idCelular, accion="nuevo";
    Button btn;
    DB miDB;
    TextView tempVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_celulares);
        Button btnVolver = (Button)findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(AddCelulares.this,Principal.class);
                startActivity(volver);
            }
        });
        miDB = new DB (getApplicationContext(),"",null,1);

        btnAtras = findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(v -> {
            mostrarVistaPrincipal();
        });


        btn = findViewById(R.id.btnGuardarCelular);
        btn.setOnClickListener(v->{
            agregarCelular();
        });
        mostrarDatosCelulares();
    }

    //Metodo para agregar amigos
    private void agregarCelular () {

        tempVal = findViewById(R.id.txtGama);
        String gama = tempVal.getText().toString();

        tempVal = findViewById(R.id.txtMarca);
        String marca = tempVal.getText().toString();

        tempVal = findViewById(R.id.txtModelo);
        String modelo = tempVal.getText().toString();

        tempVal = findViewById(R.id.txtPrecio);
        String precio = tempVal.getText().toString();

        tempVal = findViewById(R.id.txtVenta);
        String fecha_venta = tempVal.getText().toString();


        try {
            String [] datos = {idCelular,gama, marca, modelo, precio, fecha_venta};
            miDB.admin_amigo(accion,datos);
            mostrarMsgToast("Celular guardado con exito");
            mostrarVistaPrincipal();
            mostrarDatosCelulares();

        }catch(Exception e){
            mostrarMsgToast("error aca" + e);
            tempVal = findViewById(R.id.error);
            tempVal.setText("Corregir: " + e);
        }

    }

    //Mostrar pantalla principal
    private void mostrarVistaPrincipal(){
        Intent iprincipal = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(iprincipal);
    }

    //Mensaje Toast para informar errores
    private void mostrarMsgToast(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }

    private void mostrarDatosCelulares() {
        try {
            Bundle parametros= getIntent().getExtras();
            accion = parametros.getString("accion");
            if (accion.equals("modificar")){
                String[] datos = parametros.getStringArray("datos");
                idCelular = datos[0];
                tempVal = findViewById(R.id.txtGama);
                tempVal.setText(datos[1]);
                tempVal = findViewById(R.id.txtMarca);
                tempVal.setText(datos[2]);
                tempVal = findViewById(R.id.txtModelo);
                tempVal.setText(datos[3]);
                tempVal = findViewById(R.id.txtPrecio);
                tempVal.setText(datos[4]);
                tempVal = findViewById(R.id.txtVenta);

            }

        }catch (Exception e){
            mostrarMsgToast(e.getMessage());

        }

    }


}