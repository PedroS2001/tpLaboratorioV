package com.example.tplaboratorio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilJugadorActivity extends AppCompatActivity {

    TextView tvNombre;
    TextView tvApellido;

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
        String imagen = bundle.getString("imagen");
        String fecha_nacimiento = bundle.getString("fecha_nacimiento");
        Float estatura = bundle.getFloat("estatura");

        this.tvNombre = findViewById(R.id.tvNombrePerfil);
        this.tvApellido = findViewById(R.id.tvApellidoPerfil);

        this.tvNombre.setText(nombre);
        this.tvApellido.setText(apellido);

        ActionBar acbar = super.getSupportActionBar();
        acbar.setTitle("Perfil del jugador");
        acbar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);
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



}