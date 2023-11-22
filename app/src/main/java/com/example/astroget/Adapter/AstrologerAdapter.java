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

public class AstrologerAdapter extends RecyclerView.Adapter<AstrologerAdapter.SingleItemRowHolder> {

    private ArrayList<AstroModel> itemsList;
    private Context mContext;

    String fromScreen;

    public AstrologerAdapter(Context context, ArrayList<AstroModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }


    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.laypout_astrologer, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        AstroModel astroModel = itemsList.get(i);

        holder.tvTitle.setText(astroModel.getAstroName());


        Glide.with(mContext)
                .load(astroModel.getImgid())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle;

        protected ImageView itemImage;


        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle =  view.findViewById(R.id.tvAstroNameVastu);
            this.itemImage =  view.findViewById(R.id.civAstroVastu);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });


        }

    }

}

