package com.example.tplaboratorio;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EquipoVH extends RecyclerView.ViewHolder {
    ImageView img;
    public EquipoVH(@NonNull View itemView) {
        super(itemView);
        this.img = itemView.findViewById(R.id.imgEquipo);
    }
}
