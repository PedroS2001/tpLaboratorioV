package com.example.tplaboratorio;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EquipoAdapter extends RecyclerView.Adapter<EquipoVH> {

    private List<EquipoModel> listaEquipos;
    Activity a;
    public EquipoAdapter(List<EquipoModel> lista, Activity a){
        this.listaEquipos = lista;
        this.a = a;
    }
    @NonNull
    @Override
    public EquipoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.equipo_layout, parent, false);
        return new EquipoVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EquipoVH holder, int position) {
        EquipoModel equipo = listaEquipos.get(position);

        ClickEquipo click = new ClickEquipo(equipo.getNombre());
        holder.itemView.setOnClickListener(click);
        holder.tvNombre.setText(equipo.getNombre());
    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }

    public void actualizarImagen(Integer indice, byte[] img) {
        listaEquipos.get(indice).setImgByte(img);
    }
}
