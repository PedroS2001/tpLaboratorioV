package com.example.tplaboratorio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PerfilJugador extends AppCompatActivity {

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

    }
}