package com.example.tplaboratorio;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class JugadorVH extends RecyclerView.ViewHolder {
    TextView tvNombre;
    TextView tvApellido;
    ImageView imgJugador;

    public JugadorVH(@NonNull View itemView) {
        super(itemView);

        this.tvNombre = itemView.findViewById(R.id.tvNombreJugador);
        this.tvApellido = itemView.findViewById(R.id.tvApellidoJugador);
        this.imgJugador = itemView.findViewById(R.id.imageJugador);
    }
}
