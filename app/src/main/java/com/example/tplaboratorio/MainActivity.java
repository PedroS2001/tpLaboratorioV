package com.example.tplaboratorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    TextView tv;
    ImageView img;
    JugadorAdapter jugadorAdapter;

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
        //this.tv.setText(message.obj.toString());

        try {
            JSONArray respuestaArray = new JSONArray(respuesta);
            //JSONObject respuestaJSON =  new JSONObject(respuesta);      //Parseo la respuesta a JSON
            Log.d("--------", ""+ respuestaArray);

            List<JugadorModel> lista = new ArrayList<>();

            for(int i=0; i<respuestaArray.length(); i++)
            {
                JSONObject jsObj = respuestaArray.getJSONObject(i);
                JugadorModel jugador = new JugadorModel();
                jugador.setNombre(jsObj.getString("nombre"));
                jugador.setApellido(jsObj.getString("apellido"));
                jugador.setNacionalidad(jsObj.getString("nacionalidad"));
                jugador.setClub(jsObj.getString("club"));
                jugador.setPosicion(jsObj.getString("posicion"));
                jugador.setPie(jsObj.getString("pie"));
                jugador.setNumero( Integer.valueOf(jsObj.getString("numero")) );
                jugador.setImagen(jsObj.getString("imagen"));
                jugador.setFecha_nacimiento(jsObj.getString("fecha_nacimiento"));
                jugador.setEstatura( Float.valueOf(jsObj.getString("estatura")) );

                lista.add( jugador );
                Log.d("----", "Se anadio" +jugador);
            }

            this.jugadorAdapter = new JugadorAdapter(lista);
            RecyclerView rv = super.findViewById(R.id.rvJugadores);
            rv.setAdapter(this.jugadorAdapter);
            rv.setLayoutManager(new GridLayoutManager(this,1));
            /*
            JSONObject unEquipo = respuestaArray.getJSONObject(message.arg1);
            Log.d("PEDRO", ""+unEquipo);
            this.tv.setText(unEquipo.toString());*/
            /*JSONArray drinks = respuestaJSON.getJSONArray("") ;
            JSONObject unObjeto = drinks.getJSONObject(0);
            Log.d("-----", "" + unObjeto.getString("strDrink"));*/



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

