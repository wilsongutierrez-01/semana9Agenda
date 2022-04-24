package com.gutierrez.semana9agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnregraLogin = (Button)findViewById(R.id.btnregresaLogin);

        btnregraLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(MainActivity2.this,Principal.class);
                startActivity(volver);
            }

        });



        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo) ;
        Login = (Button) findViewById(R.id.btnLogin);

        Info.setText("Numero de intentos restantes : 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });




    }

    private void validate (String userName, String userPassword){

        if ((userName.equals("admin")) && (userPassword.equals("1234"))){

            Intent intent = new Intent(MainActivity2.this, AddCelulares.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("Número de intentos restantes :"+ String.valueOf(counter));

            if (counter ==0){
                Login.setEnabled(false);
            }



        }







    }
}

