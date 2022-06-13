package com.example.tplaboratorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.BitmapFactory;
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

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    TextView tv;
    ImageView img;
    EquipoAdapter equipoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler handler = new Handler(this);
        HiloConexion hilo = new HiloConexion(handler, "https://apiequipospedro.herokuapp.com/equipo", 1,1 );
        hilo.start();


        ActionBar acbar = super.getSupportActionBar();
        acbar.setTitle(R.string.app_teams);
        acbar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home)
        {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean handleMessage(@NonNull Message message) {
        String respuesta = message.obj.toString();
        Log.d("MESSAGE", "handleMessage: " + respuesta  );

        if(message.arg1 == 1)
        {
            try {
                JSONArray respuestaArray = new JSONArray(respuesta);
                Log.d("--------", ""+ respuestaArray);

                List<EquipoModel> lista = new ArrayList<>();

                for(int i=0; i<respuestaArray.length(); i++)
                {
                    JSONObject jsObj = respuestaArray.getJSONObject(i);
                    EquipoModel equipo = new EquipoModel();
                    equipo.setNombre(jsObj.getString("nombre"));
                    equipo.setPais(jsObj.getString("pais"));
                    equipo.setLiga(jsObj.getString("liga"));
                    equipo.setUrlImagen(jsObj.getString("imagen"));

                    lista.add( equipo );
                    Log.d("----", "Se anadio" +equipo);
                }

                this.equipoAdapter = new EquipoAdapter(lista, this);
                RecyclerView rv = super.findViewById(R.id.rvEquipos);
                rv.setAdapter(this.equipoAdapter);
                rv.setLayoutManager(new GridLayoutManager(this,2));

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        else if(message.arg1 == 3)     //es imagen
        {
            byte[] img = (byte[]) message.obj;

            this.equipoAdapter.actualizarImagen(message.arg2, img);
            this.equipoAdapter.notifyItemChanged(message.arg2);
        }

        return false;
    }

}

