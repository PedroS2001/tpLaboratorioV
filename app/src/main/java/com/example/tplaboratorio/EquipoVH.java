package com.example.tplaboratorio;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EquipoVH extends RecyclerView.ViewHolder {
    TextView tvNombre;
    ImageView img;
    public EquipoVH(@NonNull View itemView) {
        super(itemView);
        this.tvNombre = itemView.findViewById(R.id.tvNombreEquipo);
        this.img = itemView.findViewById(R.id.imgEquipo);
    }
}
