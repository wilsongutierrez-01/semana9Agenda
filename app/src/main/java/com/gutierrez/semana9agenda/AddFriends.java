package com.gutierrez.semana9agenda;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddFriends extends AppCompatActivity {
    FloatingActionButton btnAtras;
    String idAmigo, accion="nuevo";
    Button btn;
    DB miDB;
    TextView tempVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);
        miDB = new DB (getApplicationContext(),"",null,1);

        btnAtras = findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(v -> {
            mostrarVistaPrincipal();
        });


        btn = findViewById(R.id.btnGuardarAmigo);
        btn.setOnClickListener(v->{
            agregarAmigo();
        });
        mostrarDatosAmigos();
    }

    //Metodo para agregar amigos
    private void agregarAmigo () {

        tempVal = findViewById(R.id.txtName);
        String nombre = tempVal.getText().toString();

        tempVal = findViewById(R.id.txtNumber);
        String numero = tempVal.getText().toString();

        tempVal = findViewById(R.id.txtEmail);
        String email = tempVal.getText().toString();


        try {
            String [] datos = {idAmigo,nombre, numero, email};
            miDB.admin_amigo(accion,datos);
            mostrarMsgToast("Amigo guardado con exito");
            mostrarVistaPrincipal();
            mostrarDatosAmigos();

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

    private void mostrarDatosAmigos() {
        try {
            Bundle parametros= getIntent().getExtras();
            accion = parametros.getString("accion");
            if (accion.equals("modificar")){
                String[] datos = parametros.getStringArray("datos");
                idAmigo = datos[0];
                tempVal = findViewById(R.id.txtName);
                tempVal.setText(datos[1]);
                tempVal = findViewById(R.id.txtNumber);
                tempVal.setText(datos[2]);
                tempVal = findViewById(R.id.txtEmail);


            }

        }catch (Exception e){
            mostrarMsgToast(e.getMessage());

        }

    }


}