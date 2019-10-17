package com.proyecto.chefsito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Login extends AppCompatActivity {
    ImageView logo;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.image_logo);
        logo.setImageResource(R.drawable.chefsito);
        login = findViewById(R.id.boton_login);

    }
    public void ingreso(View view){
        Intent intent = new Intent(view.getContext(),Inicio.class);
        startActivity(intent);
    }


}
