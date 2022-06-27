package com.example.tplaboratorio;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
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
        Log.d("-----", j.getNombre() +" "+ j.getApellido() + " position: " + position);
        holder.tvNombre.setText(j.getNombre());
        holder.tvApellido.setText(j.getApellido());

        ClickJugador click = new ClickJugador(j);
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
            Resources res = this.a.getResources();
            Drawable draw =  res.getDrawable(R.drawable.ic_search_black_24dp);
            holder.imgJugador.setImageDrawable(draw);
        }

    }

    public void actualizarImagen(Integer indice, byte[] img) {

        try {
            listaJugadores.get(indice).setImgByte(img);
        }catch (Exception e)
        {
            Log.d("ERROR", "actualizarImagen: "+e.getMessage());
        }

        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return JugadorAdapter.listaJugadores.size();
    }
}
