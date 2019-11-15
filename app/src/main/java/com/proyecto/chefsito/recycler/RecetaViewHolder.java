package com.proyecto.chefsito.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.proyecto.chefsito.R;

public class RecetaViewHolder extends RecyclerView.ViewHolder {
    public TextView tv_title;
    public TextView tv_description;
    public TextView tv_type;

    public RecetaViewHolder(@NonNull View itemView) {
        super(itemView);
        this.tv_title=itemView.findViewById(R.id.tv_title);
        this.tv_type=itemView.findViewById(R.id.tv_type);
        this.tv_description = itemView.findViewById(R.id.tv_description);
    }

}
