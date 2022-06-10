package com.example.tplaboratorio;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorVH> {

    public static List<JugadorModel> listaJugadores;
    public static List<JugadorModel> listaJugadoresOriginal;

    public JugadorAdapter(List<JugadorModel> listaJugadores){
        JugadorAdapter.listaJugadores = listaJugadores;
        JugadorAdapter.listaJugadoresOriginal = new ArrayList<>();
        JugadorAdapter.listaJugadoresOriginal.addAll(listaJugadores);
    }

    public void filtrar(String search){
        if(search.length() > 0)
        {
            listaJugadores.clear();
            for(JugadorModel j: listaJugadoresOriginal)
            {
                if(j.getNombre().toLowerCase().contains(search.toLowerCase(Locale.ROOT))
                        || j.getApellido().toLowerCase().contains(search.toLowerCase()) )
                {
                    listaJugadores.add(j);
                }
            }
        }
        else{
            listaJugadores.clear();
            listaJugadores.addAll(listaJugadoresOriginal);
        }
        notifyDataSetChanged();
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

        //if(j.getImgByte() == null && j.isBuscandoImg() == false)

        //si no tenemos el array de bytes lanzamos un hilo para buscarlo.
        //se le pasa la posicion en la que va para cuando vuelva la ponga
        //y cuando vuelva se le manda un notifyItemChanged
        /*if(this.listaJugadores.get(position).img == null)
        {
            //lanzamos el hilo para buscarla
        }
        else{
            //ya estuvo en el VH y ya esta descargada la img asi qeu solo la ponemos
        }*/

        //lanzamos el hilo para buscar la imagen
        this.listaJugadores.get(position).getImagen();

    }

    @Override
    public int getItemCount() {
        return JugadorAdapter.listaJugadores.size();
    }
}
