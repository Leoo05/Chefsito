package com.proyecto.chefsito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.proyecto.chefsito.recycler.CocinaAdapter;
import com.proyecto.chefsito.recycler.RecetaAdapter;

import java.util.ArrayList;

public class Cocina extends AppCompatActivity {
    private RecyclerView recyclerViewCocina;
    private EditText ingrediente;
    private String nick;
    private Button agregar;
    private ArrayList<String> ingredientes;
    private RecyclerView.Adapter cocinaAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocina);
        nick = getIntent().getStringExtra("nick");
        agregar=findViewById(R.id.boton_agregar);
        recyclerViewCocina = findViewById(R.id.recycler_ingredientes);
        ingrediente = findViewById(R.id.ed_ingrediente);
        ingredientes = new ArrayList<>();
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes.add(ingrediente.getText().toString());
                initAdapter(view);
            }
        });
    }

    public void regresar(View view){
        Intent intent = new Intent(view.getContext(), Inicio.class);
        intent.putExtra("nick",nick);
        startActivity(intent);
    }
    public void buscarReceta(View view){
        Intent intent = new Intent(view.getContext(), Receta.class);
        intent.putExtra("nick",nick);
        intent.putExtra("title",ingrediente.getText().toString());
        startActivity(intent);
    }
    public void initAdapter(View view){
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerViewCocina.setLayoutManager(layoutManager);
        cocinaAdapter = new CocinaAdapter(ingredientes);
        recyclerViewCocina.setAdapter(cocinaAdapter);
    }

}
