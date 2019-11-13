package com.proyecto.chefsito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Login extends AppCompatActivity {
    private Button login;
    private Button registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.boton_login);
        registro = findViewById(R.id.boton_registrarse);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Registro.class);
                startActivity(intent);
            }
        });
    }
    public void ingreso(View view){
        Intent intent = new Intent(view.getContext(),Inicio.class);
        startActivity(intent);
    }


}
