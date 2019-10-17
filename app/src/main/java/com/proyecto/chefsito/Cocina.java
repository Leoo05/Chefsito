package com.proyecto.chefsito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cocina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocina);
    }

    public void regresar(View view){
        Intent intent = new Intent(view.getContext(), Inicio.class);
        startActivity(intent);
    }
    public void buscarReceta(View view){
        Intent intent = new Intent(view.getContext(), Receta.class);
        startActivity(intent);
    }


}
