package com.proyecto.chefsito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Registro extends AppCompatActivity {
    private Button register;
    private EditText nombre;
    private EditText nickname;
    private EditText password;
    private EditText correo;
    private EditText apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre=findViewById(R.id.edit_nombrereg);
        nickname=findViewById(R.id.edit_nickname);
        password=findViewById(R.id.edit_password);
        correo=findViewById(R.id.edit_correo);
        register = findViewById(R.id.button_registro);
        apellido = findViewById(R.id.edit_apellido);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callPostService();
                Intent intent = new Intent(view.getContext() , Login.class);
                startActivity(intent);
            }
        });
    }
    public void callPostService () {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlService = new URL ("http://192.168.1.11:8080/register" );
                    HttpURLConnection connection =  (HttpURLConnection) urlService.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setDoOutput(true);
                    String nick=nickname.getText().toString();
                    String name = nombre.getText().toString();
                    String last =apellido.getText().toString();
                    String pass = password.getText().toString();
                    String mail = correo.getText().toString();

                    DataOutputStream wr = new DataOutputStream (connection.getOutputStream());
                    wr.writeBytes("{\"nick\":\""+nickname.getText().toString()+"\"," +
                            "\"password\":\""+password.getText().toString()+"\",\"name\":\""+nombre.getText().toString()+"\",\"last\":\""+apellido.getText().toString()+
                            "\",\"mail\":\""+correo.getText().toString()+"\",\"role\":"+"\"true\""+"}");
                    wr.close();
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
}
