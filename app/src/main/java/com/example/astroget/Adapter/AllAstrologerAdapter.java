package com.example.astroget.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.astroget.Model.AstroModel;
import com.example.astroget.R;

import java.util.ArrayList;

public class AllAstrologerAdapter extends RecyclerView.Adapter<AllAstrologerAdapter.SingleItemRowHolder> {

    private ArrayList<AstroModel> itemsList;
    private Context mContext;


    public AllAstrologerAdapter(Context context, ArrayList<AstroModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }


    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_astro_all_list , null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        AstroModel astroModel = itemsList.get(i);

      //  holder.tvName.setText(astroModel.getAstroName());



    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvName;
        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

           // this.tvName = (TextView) view.findViewById(R.id.tvAstrologerNage);
//
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(v.getContext(), tvName.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}

