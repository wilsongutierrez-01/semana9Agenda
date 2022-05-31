package com.gutierrez.semana9agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RegistraPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_pedido);

        Button btvuelve = (Button)findViewById(R.id.btvuelve);

        btvuelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vol = new Intent(RegistraPedido.this,Principal.class);
                startActivity(vol);
            }

        });
    }

    public void eventoBoton(View view) {
        Toast.makeText(getApplicationContext(), "Su compra se realizó con éxito", Toast.LENGTH_LONG).show();
    }
}