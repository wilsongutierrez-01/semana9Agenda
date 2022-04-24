package com.gutierrez.semana9agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button btnAgregar = (Button)findViewById(R.id.btnAgregarVenta);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Agre = new Intent(Principal.this,MainActivity2.class);
                startActivity(Agre);
            }
        });
        Button btnAcerca = (Button)findViewById(R.id.btnAcercaDe);

        btnAcerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Acer = new Intent(Principal.this,AcercaDe.class);
                startActivity(Acer);
            }
        });
        Button btnCatal = (Button)findViewById(R.id.btnCatal);

        btnCatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cata = new Intent(Principal.this,Celu1.class);
                startActivity(cata);
            }

        });
    }
}

