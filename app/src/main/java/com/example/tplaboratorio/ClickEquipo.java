package com.example.tplaboratorio;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class ClickEquipo implements View.OnClickListener {

    private EquipoModel equipo;
    public ClickEquipo(EquipoModel equipo)
    {
        this.equipo = equipo;
    }
    @Override
    public void onClick(View view) {
        Log.d("ClickEquipo", "CLick Equipo");

        if(equipo.getImgByte()==null)
        {
            Toast toast = Toast.makeText(view.getContext(), R.string.app_loading_image, Toast.LENGTH_LONG);
            toast.show();
        }else{
            Intent i = new Intent(view.getContext(), MenuJugadoresActivity.class);
            i.putExtra("nombre", this.equipo.getNombre());

            Activity a = (Activity) view.getContext();
            a.startActivity(i);
        }

    }
}
