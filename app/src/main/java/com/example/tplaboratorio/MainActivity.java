package com.example.tplaboratorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback, SearchView.OnQueryTextListener {

    TextView tv;
    ImageView img;
    JugadorAdapter jugadorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.tv = findViewById(R.id.testView);
        Handler handler = new Handler(this);

        HiloConexion hilo = new HiloConexion(handler);
        hilo.start();




        ActionBar acbar = super.getSupportActionBar();
        //acbar.setTitle("Equipos");
        acbar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);

        MenuItem searchItem = menu.findItem(R.id.campoBuscar);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home)
        {
            this.finish();   //cierra el activity
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextChange(String s) {
        Log.d("activity", "cambio texto:" + s);
        jugadorAdapter.filtrar(s);
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        Log.d("activity", "Hago una busqueda con:" + s);
        //jugadorAdapter.filtrar(s);
        return false;
    }



    @Override
    public boolean handleMessage(@NonNull Message message) {
        String respuesta = message.obj.toString();
        Log.d("MESSAGE", "handleMessage: " + respuesta  );

        try {
            JSONArray respuestaArray = new JSONArray(respuesta);
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

        } catch (JSONException e) {
            e.printStackTrace();
        }



        if(message.arg1 == 3) //imagen
        {

        }


        return false;
    }

    public String obtenerUnAtributo()
    {
        String valor = "";

        return valor;
    }

}

