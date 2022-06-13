package com.example.tplaboratorio;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
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
    private Activity a;

    public JugadorAdapter(List<JugadorModel> listaJugadores, Activity a){
        JugadorAdapter.listaJugadores = listaJugadores;
        JugadorAdapter.listaJugadoresOriginal = new ArrayList<>();
        JugadorAdapter.listaJugadoresOriginal.addAll(listaJugadores);
        this.a = a;
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

        if(j.getImgByte() == null && j.isBuscandoImg() == false)
        {
            j.setBuscandoImg(true);
            Handler handler = new Handler((Handler.Callback) this.a);
            HiloConexion hilo = new HiloConexion(handler, j.getImagen(), 3, position);
            hilo.start();
        }

        if(j.getImgByte() != null)
        {
            holder.imgJugador.setImageBitmap(BitmapFactory.decodeByteArray(j.getImgByte(),0, j.getImgByte().length));
        }else{
            holder.imgJugador.setImageBitmap(null);
        }


    }

    public void actualizarImagen(Integer indice, byte[] img)
    {
        listaJugadores.get(indice).setImgByte(img);
    }

    @Override
    public int getItemCount() {
        return JugadorAdapter.listaJugadores.size();
    }
}
