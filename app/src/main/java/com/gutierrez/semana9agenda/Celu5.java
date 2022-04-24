package com.gutierrez.semana9agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Celu5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celu5);
        Button bt9 = (Button)findViewById(R.id.bt9);

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si = new Intent(Celu5.this,Celu6.class);
                startActivity(si);
            }
        });
        Button bt10 = (Button)findViewById(R.id.bt10);

        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Celu5.this,Principal.class);
                startActivity(volver);
            }
        });
    }
}