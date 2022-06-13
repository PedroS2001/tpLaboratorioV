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

    TextView tvNombre;
    TextView tvApellido;
    TextView tvNacionalidad;
    TextView tvClub;
    TextView tvPosicion;
    TextView tvPie;
    TextView tvNumero;
    TextView tvFNacimiento;
    TextView tvAltura;
    ImageView image;

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

        this.image = findViewById(R.id.imgPerfil);
        this.tvNombre = findViewById(R.id.tvNombrePerfil);
        this.tvApellido = findViewById(R.id.tvApellidoPerfil);
        this.tvNacionalidad = findViewById(R.id.tvNacionalidad);
        this.tvFNacimiento = findViewById(R.id.tvFNacimiento);

        this.tvAltura = findViewById(R.id.tvAltura);
        this.tvPie = findViewById(R.id.tvPie);
        this.tvClub = findViewById(R.id.tvClub);
        this.tvNumero = findViewById(R.id.tvNumero);
        this.tvPosicion = findViewById(R.id.tvPosicion);


        this.image.setImageBitmap(BitmapFactory.decodeByteArray(imagen ,0, imagen.length));
        this.tvNombre.setText(nombre);
        this.tvApellido.setText(apellido);
        this.tvNacionalidad.setText(nacionalidad);
        this.tvFNacimiento.setText(fecha_nacimiento);
        this.tvAltura.setText(estatura.toString());
        this.tvPie.setText(pie);
        this.tvClub.setText(club);
        this.tvNumero.setText(numero.toString());
        this.tvPosicion.setText(posicion);

        Resources res = getResources();
        int color = res.getColor(R.color.celeste);
        this.findViewById(R.id.pepe).setBackgroundColor(color);



        ActionBar acbar = super.getSupportActionBar();
        acbar.setTitle(R.string.app_player_profile);
        acbar.setDisplayHomeAsUpEnabled(true);
    }

    //@Override
    /*public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }*/


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== android.R.id.home)
        {
            this.finish();   //cierra el activity
        }

        return super.onOptionsItemSelected(item);
    }



}