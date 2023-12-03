package com.example.astroget.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.astroget.MainActivity;
import com.example.astroget.Model.AstroModel;
import com.example.astroget.R;
import com.example.astroget.Screen.AstrologerProfileActivity;

import java.util.ArrayList;

public class AllAstrologerAdapter extends RecyclerView.Adapter<AllAstrologerAdapter.MyViewHolder> {

     ArrayList<AstroModel> itemsList;
     Context context;


    public AllAstrologerAdapter(Context context, ArrayList<AstroModel> itemsList) {
        this.itemsList = itemsList;
        this.context = context;
    }


    @Override
    public AllAstrologerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_astro_all_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllAstrologerAdapter.MyViewHolder holder, int position) {
        AstroModel astroModel = itemsList.get(position);

        holder.tvName.setText(astroModel.getAstroName());
        
        Glide.with(holder.astroImage)
                .load(astroModel.getImgid())
                .into(holder.astroImage);


        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), AstrologerProfileActivity.class);
            view.getContext().startActivity(intent);
        });


    }



    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView tvName;
        protected ImageView astroImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            astroImage = itemView.findViewById(R.id.civAstroImageList);
            tvName = itemView.findViewById(R.id.tvAstrologerNameList);
        }
    }

}

