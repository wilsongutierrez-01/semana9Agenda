package com.gutierrez.semana9agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Celu8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celu8);
        Button bt15 = (Button)findViewById(R.id.bt15);

        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si = new Intent(Celu8.this,Celu9.class);
                startActivity(si);
            }
        });
        Button bt16 = (Button)findViewById(R.id.bt16);

        bt16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Celu8.this,Principal.class);
                startActivity(volver);
            }
        });
    }
}