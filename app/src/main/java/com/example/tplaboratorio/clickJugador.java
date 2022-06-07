package com.example.tplaboratorio;

import android.util.Log;
import android.view.View;

public class clickJugador implements View.OnClickListener {

    JugadorModel jugador;
    public clickJugador(JugadorModel jugador)
    {
        this.jugador = jugador;
    }
    @Override
    public void onClick(View view) {
        String nombreApellido = this.jugador.getNombre() + " "+ this.jugador.getApellido();
        Log.d("CLICK", nombreApellido);
    }
}
