package com.example.tplaboratorio;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorVH> {

    public static List<JugadorModel> listaJugadores;
    public JugadorAdapter(List<JugadorModel> listaJugadores){
        JugadorAdapter.listaJugadores = listaJugadores;
    }

    @NonNull
    @Override
    public JugadorVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jugador_layout, parent, false);
        return new JugadorVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorVH holder, int position) {
        JugadorModel j = JugadorAdapter.listaJugadores.get(position);
        Log.d("-----", "onBindViewHolder: " +j.getNombre() +" "+ j.getApellido());
        holder.tvNombre.setText(j.getNombre());
        holder.tvApellido.setText(j.getApellido());

        clickJugador click = new clickJugador(j);
        holder.itemView.setOnClickListener(click);


    }

    @Override
    public int getItemCount() {
        return JugadorAdapter.listaJugadores.size();
    }
}
