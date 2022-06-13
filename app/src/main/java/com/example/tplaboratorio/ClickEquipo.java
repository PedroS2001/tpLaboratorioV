package com.example.tplaboratorio;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class ClickEquipo implements View.OnClickListener {

    private String nombre;
    public ClickEquipo(String nombre)
    {
        this.nombre = nombre;
    }
    @Override
    public void onClick(View view) {
        Log.d("ClickEquipo", "CLick Equipo");
        Intent i = new Intent(view.getContext(), MenuJugadoresActivity.class);
        i.putExtra("nombre", this.nombre);

        Activity a = (Activity) view.getContext();
        a.startActivity(i);
    }
}
