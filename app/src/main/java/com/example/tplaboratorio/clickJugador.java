package com.example.tplaboratorio;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class clickJugador implements View.OnClickListener {

    JugadorModel jugador;
    public clickJugador(JugadorModel jugador) {
        this.jugador = jugador;
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(view.getContext(), PerfilJugadorActivity.class);

        i.putExtra("nombre", this.jugador.getNombre());
        i.putExtra("apellido", this.jugador.getApellido());
        i.putExtra("nacionalidad", this.jugador.getNacionalidad());
        i.putExtra("club", this.jugador.getClub());
        i.putExtra("posicion", this.jugador.getPosicion());
        i.putExtra("pie", this.jugador.getPie());
        i.putExtra("numero", this.jugador.getNumero());
        i.putExtra("imagen", this.jugador.getImgByte());
        i.putExtra("fnacimiento", this.jugador.getFecha_nacimiento());
        i.putExtra("estatura", this.jugador.getEstatura());


        Activity a = (Activity) view.getContext();
        a.startActivity(i);
    }
}
