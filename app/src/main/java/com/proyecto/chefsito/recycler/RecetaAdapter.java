package com.proyecto.chefsito.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.chefsito.R;
import com.proyecto.chefsito.model.Recipe;

import java.util.ArrayList;

public class RecetaAdapter extends RecyclerView.Adapter<RecetaViewHolder> {
    private ArrayList<Recipe> recipeArrayList;
    public RecetaAdapter(ArrayList<Recipe> recipeArrayList){
        this.recipeArrayList = recipeArrayList;
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
        Recipe recipe = recipeArrayList.get(position);

        holder.tv_title.setText(recipe.getTitle());
        holder.tv_description.setText(recipe.getDescription());
        holder.tv_type.setText(recipe.getType());

    }

    @Override
    public int getItemCount() {
        return recipeArrayList.size();
    }
}
