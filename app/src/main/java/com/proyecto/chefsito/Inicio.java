package com.proyecto.chefsito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    Button cocina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        cocina= findViewById(R.id.button_kitchen);

    }
    public void irCocina(View view){
        Intent intent = new Intent(view.getContext(), Cocina.class);
        startActivity(intent);
    }
}
