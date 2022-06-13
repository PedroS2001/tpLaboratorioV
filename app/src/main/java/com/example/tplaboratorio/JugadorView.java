package com.example.tplaboratorio;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class JugadorView {

    Activity activity;
    JugadorModel jugador;
    JugadorController controller;

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

    public JugadorView(Activity a, JugadorModel jugador, JugadorController controller){
        this.activity = a;
        this.jugador = jugador;
        this.controller = controller;

        this.image = this.activity.findViewById(R.id.imgPerfil);
        this.tvNombre = this.activity.findViewById(R.id.tvNombrePerfil);
        this.tvApellido = this.activity.findViewById(R.id.tvApellidoPerfil);
        this.tvNacionalidad = this.activity.findViewById(R.id.tvNacionalidad);
        this.tvFNacimiento = this.activity.findViewById(R.id.tvFNacimiento);
        this.tvAltura = this.activity.findViewById(R.id.tvAltura);
        this.tvPie = this.activity.findViewById(R.id.tvPie);
        this.tvClub = this.activity.findViewById(R.id.tvClub);
        this.tvNumero = this.activity.findViewById(R.id.tvNumero);
        this.tvPosicion = this.activity.findViewById(R.id.tvPosicion);

    }

    public void cargarModelo()
    {

    }

    public void mostrarModelo()
    {
        this.image.setImageBitmap(BitmapFactory.decodeByteArray(this.jugador.getImgByte() ,0, this.jugador.getImgByte().length));
        this.tvNombre.setText(this.jugador.getNombre());
        this.tvApellido.setText(this.jugador.getApellido());
        this.tvNacionalidad.setText(this.jugador.getNacionalidad());
        this.tvFNacimiento.setText(this.jugador.getFecha_nacimiento());
        this.tvAltura.setText(this.jugador.getEstatura().toString());
        this.tvPie.setText(this.jugador.getPie());
        this.tvClub.setText(this.jugador.getClub());
        this.tvNumero.setText(this.jugador.getNumero().toString());
        this.tvPosicion.setText(this.jugador.getPosicion());
    }

}
