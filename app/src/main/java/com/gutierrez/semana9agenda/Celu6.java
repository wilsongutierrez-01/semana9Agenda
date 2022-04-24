package com.gutierrez.semana9agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Celu6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celu6);
        Button bt11 = (Button)findViewById(R.id.bt11);

        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si = new Intent(Celu6.this,Celu7.class);
                startActivity(si);
            }
        });
        Button bt12 = (Button)findViewById(R.id.bt12);

        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Celu6.this,Principal.class);
                startActivity(volver);
            }
        });
    }
}