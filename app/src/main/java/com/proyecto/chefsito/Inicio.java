package com.proyecto.chefsito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import com.proyecto.chefsito.model.Receta;
import com.proyecto.chefsito.recycler.RecetaAdapter;

public class Inicio extends AppCompatActivity {
    Button cocina;
    private String nick;
    private String JsonString;
    private JSONArray jsonArray;
    private ArrayList<Receta> recetaArrayList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        cocina= findViewById(R.id.button_kitchen);
        this.nick = getIntent().getStringExtra("nick");
        Toast toast = Toast.makeText(getApplicationContext(),"Bienvenido "+nick,Toast.LENGTH_SHORT);
        toast.show();
        recetaArrayList=new ArrayList<>();
        callWebService();
        while (recetaArrayList.size()==0){
        }
        recyclerView  = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recAdapter = new RecetaAdapter(recetaArrayList);
        recyclerView.setAdapter(recAdapter);
    }
    public void irCocina(View view){
        Intent intent = new Intent(view.getContext(), Cocina.class);
        startActivity(intent);
    }
    public static String getStringFromInputStream(InputStream stream) throws IOException {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer))) writer.write(buffer, 0, n);
        return writer.toString();
    }
    public void callWebService(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlService = new URL("http://192.168.1.11:8080/keep/"+nick);
                    HttpURLConnection connection = (HttpURLConnection) urlService.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream responseBody = connection.getInputStream();
                    if (connection.getResponseCode() == 200) {
                        // Success
                        JsonString = getStringFromInputStream(responseBody);
                        jsonArray = new JSONArray(JsonString);
                        agregarRecetas(jsonArray);
                    } else {
                        // Error handling code goes here
                        Log.v("ERROR", "ERROR");
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void agregarRecetas(JSONArray jsonArray){
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject receta = jsonArray.getJSONObject(i);
                this.recetaArrayList.add(new Receta(receta.getString("title"),
                        receta.getString("type"),
                        receta.getString("tag"),
                        receta.getString("description"),
                        receta.getString("instructions"),
                        receta.getString("video")));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }


    }
}
