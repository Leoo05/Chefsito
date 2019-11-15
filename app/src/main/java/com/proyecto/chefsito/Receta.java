package com.proyecto.chefsito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.proyecto.chefsito.model.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Receta extends AppCompatActivity {
    private Button volver;
    private Button agregarReceta;
    private String nick;
    private String ingrediente;
    private Recipe recipe;
    private TextView descripcion;
    private TextView title;
    private TextView instrucciones;
    private TextView ingredientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);
        nick=getIntent().getStringExtra("nick");
        ingrediente=getIntent().getStringExtra("title");
        volver = findViewById(R.id.boton_volver);
        agregarReceta= findViewById(R.id.boton_agregarReceta);
        descripcion = findViewById(R.id.textView_descripcion);
        title = findViewById(R.id.textView_title);
        ingredientes = findViewById(R.id.textView_ingredientes);
        instrucciones = findViewById(R.id.textView_instrucciones);
        callWebService();
        while(recipe==null){
        }
        descripcion.setText(recipe.getDescription());
        title.setText(recipe.getTitle());
        instrucciones.setText(recipe.getInstructions());
        ingredientes.setText(recipe.getTag());
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Cocina.class);
                intent.putExtra("nick",nick);
                startActivity(intent);
            }
        });
        agregarReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPostService();
            }
        });
    }

    public void callPostService () {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlService = new URL ("http://192.168.1.11:8080/keep/"+nick+"/"+recipe.getTitle());
                    HttpURLConnection connection =  (HttpURLConnection) urlService.openConnection();
                    connection.setRequestMethod("POST");
                    InputStream responseBody = connection.getInputStream();
                    Toast toast = Toast.makeText(getApplicationContext(),"USUARIO CREADO",Toast.LENGTH_LONG);
                    if (connection.getResponseCode() == 200) {
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
    public void callWebService(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlService = new URL("http://192.168.1.11:8080/search/title/"+ingrediente.toLowerCase());
                    HttpURLConnection connection = (HttpURLConnection) urlService.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream responseBody = connection.getInputStream();
                    if (connection.getResponseCode() == 200) {
                        // Success
                        String JsonString = getStringFromInputStream(responseBody);
                        JSONArray jsonArray = new JSONArray(JsonString);
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
    public static String getStringFromInputStream(InputStream stream) throws IOException {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer))) writer.write(buffer, 0, n);
        return writer.toString();
    }
    public void agregarRecetas(JSONArray jsonArray){
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject receta = jsonArray.getJSONObject(i);
                recipe =new Recipe(receta.getString("title"),
                        receta.getString("type"),
                        receta.getString("tag"),
                        receta.getString("description"),
                        receta.getString("instructions"),
                        receta.getString("video"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }


    }
}
