package com.example.tplaboratorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class PerfilJugadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_jugador);

        Bundle bundle = super.getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        String apellido = bundle.getString("apellido");
        String nacionalidad = bundle.getString("nacionalidad");
        String club = bundle.getString("club");
        String posicion = bundle.getString("posicion");
        String pie = bundle.getString("pie");
        Integer numero = bundle.getInt("numero");
        byte[] imagen = bundle.getByteArray("imagen");
        String fecha_nacimiento = bundle.getString("fnacimiento");
        Float estatura = bundle.getFloat("estatura");

        Log.d("PEDRO", "onCreate: "+imagen);

        JugadorModel jugador = new JugadorModel(nombre, apellido, nacionalidad, club, posicion, pie, Integer.valueOf(numero), "imagen", fecha_nacimiento, estatura, imagen);

        JugadorController c = new JugadorController(jugador, this);
        JugadorView v = new JugadorView(this, jugador, c);
        c.setView(v);

        v.mostrarModelo();


        /*Resources res = getResources();
        int color = res.getColor(R.color.celeste);
        this.findViewById(R.id.pepe).setBackgroundColor(color);*/



        ActionBar acbar = super.getSupportActionBar();
        acbar.setTitle(R.string.app_player_profile);
        acbar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home)
        {
            this.finish();   //cierra el activity
        }

        return super.onOptionsItemSelected(item);
    }



}