package com.proyecto.chefsito.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.chefsito.R;

import java.util.ArrayList;

public class CocinaAdapter extends RecyclerView.Adapter<CocinaViewHolder> {
    private ArrayList<String> ingredientes;

    public CocinaAdapter(ArrayList<String> ingredientes){
        this.ingredientes=ingredientes;
    }
    @NonNull
    @Override
    public CocinaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_ingrediente_layout,parent,false);
        CocinaViewHolder cocinaViewHolder = new CocinaViewHolder(v);
        return cocinaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CocinaViewHolder holder, int position) {
        String ingrediente = ingredientes.get(position);
        holder.tv_ingrediente.setText(ingrediente);
    }

    @Override
    public int getItemCount() {
        return ingredientes.size();
    }
}
