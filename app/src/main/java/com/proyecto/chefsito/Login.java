package com.proyecto.chefsito;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Login extends AppCompatActivity {
    private Button login;
    private Button registro;
    private final String URL_LOGIN = "http://192.168.1.11:8080/logging/";//URL del servicio del login
    private String JsonString;
    private JSONObject jsonObject;
    private EditText nickname;
    private EditText password;
    private static String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nickname = findViewById(R.id.edit_Nickname);
        password = findViewById(R.id.edit_Password);
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

    public void ingreso(View view) throws JSONException {
        state=null;
        callWebService(URL_LOGIN);
        while(state==null){
        }
        ingresar(state);
    }

    public static String getStringFromInputStream(InputStream stream) throws IOException {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer))) writer.write(buffer, 0, n);
        return writer.toString();
    }

    public void callWebService(final String serviceEndPoint) throws JSONException {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    URL urlService = new URL(serviceEndPoint+nickname.getText().toString()+"/"+password.getText().toString());
                    HttpURLConnection connection = (HttpURLConnection) urlService.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream responseBody = connection.getInputStream();
                    if (connection.getResponseCode() == 200) {
                        // Success
                        JsonString = getStringFromInputStream(responseBody);
                        System.out.println(JsonString);
                        if(JsonString.equals("true")){
                            state="true";
                        }
                        else{
                            state="false";
                        }

                       // jsonObject = new JSONObject(JsonString);

                    } else {
                        // Error handling code goes here
                        Log.v("ERROR", "ERROR");
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void ingresar(String success){
        if(success.equals("true")){
                Intent intent = new Intent(getApplicationContext(), Inicio.class);
                intent.putExtra("nick",nickname.getText().toString());
                startActivity(intent);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}


