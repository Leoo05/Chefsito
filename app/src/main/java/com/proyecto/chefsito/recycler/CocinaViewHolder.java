package com.proyecto.chefsito.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.chefsito.R;


public class CocinaViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_ingrediente;

    public CocinaViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tv_ingrediente=itemView.findViewById(R.id.tv_ingrediente);

    }
}
