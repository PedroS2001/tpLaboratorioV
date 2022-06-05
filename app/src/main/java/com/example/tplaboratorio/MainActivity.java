package com.example.tplaboratorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    TextView tv;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tv = findViewById(R.id.testView);
        Handler handler = new Handler(this);

        HiloConexion hilo = new HiloConexion(handler);
        hilo.start();

        //this.findViewById(R.id.testView);
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        String respuesta = message.obj.toString();
        Log.d("MESSAGE", "handleMessage: " + respuesta  );
        this.tv.setText(message.obj.toString());

        try {
            JSONObject respuestaJSON =  new JSONObject(respuesta);      //Parseo la respuesta a JSON

            JSONArray drinks = respuestaJSON.getJSONArray("drinks") ;
            JSONObject unObjeto = drinks.getJSONObject(0);
            Log.d("-----", "" + unObjeto.getString("strDrink"));



        } catch (JSONException e) {
            e.printStackTrace();
        }


        return false;
    }

    public String obtenerUnAtributo()
    {
        String valor = "";




        return valor;
    }

}

