package com.example.tplaboratorio;

import android.app.Activity;

public class JugadorController {
    JugadorModel jugador;
    JugadorView vista;
    Activity a;

    public JugadorController(JugadorModel jugador, Activity activity) {
        this.jugador = jugador;
        this.a = activity;
    }

    public void setView(JugadorView v){
        this.vista = v;
    }



}
