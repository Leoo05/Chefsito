package com.proyecto.chefsito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {
    Button cocina;
    private String nick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        cocina= findViewById(R.id.button_kitchen);
        this.nick = getIntent().getStringExtra("nick");
        Toast toast = Toast.makeText(getApplicationContext(),"Bienvenido "+nick,Toast.LENGTH_SHORT);
        toast.show();
    }
    public void irCocina(View view){
        Intent intent = new Intent(view.getContext(), Cocina.class);
        startActivity(intent);
    }
}
