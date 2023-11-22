package com.example.astroget.Screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;

import com.example.astroget.Adapter.AllAstrologerAdapter;
import com.example.astroget.Model.AstroModel;
import com.example.astroget.R;
import com.example.astroget.databinding.ActivityAllAstrologerListBinding;

import java.util.ArrayList;

public class AllAstrologerListActivity extends AppCompatActivity {

    ActivityAllAstrologerListBinding b;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityAllAstrologerListBinding.inflate(getLayoutInflater());
        context = getApplicationContext();
        setContentView(b.getRoot());

        onlineAstro();
    }


    private void onlineAstro() {

        ArrayList<AstroModel> astrologerModelArrayList = new ArrayList<AstroModel>();

        astrologerModelArrayList.add(new AstroModel("DSA", R.drawable.chatting));
        astrologerModelArrayList.add(new AstroModel("JAVA", R.drawable.walletl));
        astrologerModelArrayList.add(new AstroModel("C++", R.drawable.whatsapp));
        astrologerModelArrayList.add(new AstroModel("Python", R.drawable.india));
        astrologerModelArrayList.add(new AstroModel("Javascript", R.drawable.instagram));
        astrologerModelArrayList.add(new AstroModel("DSA", R.drawable.facebook));

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        b.rvAllAstro.setLayoutManager(layoutManager);
        b.rvAllAstro.setHasFixedSize(true);
        b.rvAllAstro.setNestedScrollingEnabled(true);
        AllAstrologerAdapter adapter = new AllAstrologerAdapter(context,astrologerModelArrayList);
        b.rvAllAstro.setAdapter(adapter);
    }

}