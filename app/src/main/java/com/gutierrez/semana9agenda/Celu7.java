package com.gutierrez.semana9agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Celu7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celu7);
        Button bt13 = (Button)findViewById(R.id.bt13);

        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si = new Intent(Celu7.this,Celu8.class);
                startActivity(si);
            }
        });
        Button bt14 = (Button)findViewById(R.id.bt14);

        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Celu7.this,Principal.class);
                startActivity(volver);
            }
        });
    }
}