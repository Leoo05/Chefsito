package com.proyecto.chefsito.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.chefsito.R;
import com.proyecto.chefsito.model.Receta;

import java.util.ArrayList;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaViewHolder> {
    private ArrayList<Receta> recetaArrayList;
    public RecetaAdapter(ArrayList<Receta> recetaArrayList){
        this.recetaArrayList = recetaArrayList;
    }
    @NonNull
    @Override
    public RecetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.custom_receta_layout, parent,false);
        RecetaViewHolder recetaViewHolder = new RecetaViewHolder(v);
        return recetaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecetaViewHolder holder, int position) {
        Receta receta = recetaArrayList.get(position);

        holder.tv_title.setText(receta.getTitle());
        holder.tv_description.setText(receta.getDescription());
        holder.tv_type.setText(receta.getType());

    }

    @Override
    public int getItemCount() {
        return recetaArrayList.size();
    }
}
