package com.example.astroget.Screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.astroget.Adapter.AstroAdapter;
import com.example.astroget.Adapter.AstrologerAdapter;
import com.example.astroget.Adapter.SliderAdapter;
import com.example.astroget.Model.AstroModel;
import com.example.astroget.Model.SliderModel;
import com.example.astroget.R;
import com.example.astroget.Screen.Paytm.WalletActivity;
import com.example.astroget.databinding.ActivityHomePageBinding;
import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {
    ActivityHomePageBinding b;
    // initializing the slider view.

    // on below line creating variables for image urls.
    String url1 = "https://dqvh7oj3vu3ch.cloudfront.net/720x,webp/fxmedia.s3.amazonaws.com/articles/How_to_backtest_a_trading_strategy.jpg";
    String url2 = "https://www.dhanistocks.com/blog/wp-content/uploads/2019/05/Important-functions-of-stock-market.jpg";
    String url3 = "https://tradingstrategyguides.com/wp-content/uploads/2018/03/backtest-trading-strategy.jpg";
    Context context;
    SliderView  slider;

    public DrawerLayout myDrawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityHomePageBinding.inflate(getLayoutInflater());
        context = getApplicationContext();
        setContentView(b.getRoot());

        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.secondaryColor));
        }

       /* actionBarDrawerToggle = new ActionBarDrawerToggle(this, b.myDrawerLayout, R.string.nav_open, R.string.nav_close);
        b.myDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();*/
       imageSlider();
       listener();
       onlineAstro();

       vastuAstro();

    }



    private  void listener(){

        b.btnDrawer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(!b.myDrawerLayout.isOpen()){
                    b.myDrawerLayout.openDrawer(GravityCompat.START);
                   // b.myDrawerLayout.closeDrawer(GravityCompat.START);
                }
            }
        });



        b.tvAstroVastuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomePageActivity.this, AllAstrologerListActivity.class));
            }
        });



        b.nvHeader.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = (item.getItemId());

                if (id == R.id.navMenuWallet) {
                    Intent intent = new Intent(context, WalletActivity.class);
                    startActivity(intent);
                    b.myDrawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }else  if (id == R.id.mnuProfile) {
                    Intent intent = new Intent(context, ProfileActivity.class);
                    startActivity(intent);
                    b.myDrawerLayout.closeDrawer(GravityCompat.START);
                    return true;
                }
                return false;
            }
        });


    }
    private void imageSlider() {

        // we are creating array list for storing our image urls.
        ArrayList<SliderModel> sliderDataArrayList = new ArrayList<>();


        // adding the urls inside array list
        sliderDataArrayList.add(new SliderModel(url1));
       // sliderDataArrayList.add(new SliderModel(url2));
        sliderDataArrayList.add(new SliderModel(url3));
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);
        b.slider.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);
        b.slider.setSliderAdapter(adapter);
        b.slider.setScrollTimeInSec(3);
        b.slider.setAutoCycle(true);
        b.slider.startAutoCycle();
    }

    private void onlineAstro(){

        ArrayList<AstroModel> courseModelArrayList = new ArrayList<AstroModel>();

        courseModelArrayList.add(new AstroModel("DSA", R.drawable.chatting));
        courseModelArrayList.add(new AstroModel("JAVA", R.drawable.walletl));
        courseModelArrayList.add(new AstroModel("C++", R.drawable.whatsapp));
        courseModelArrayList.add(new AstroModel("Python", R.drawable.india));
        courseModelArrayList.add(new AstroModel("Javascript", R.drawable.instagram));
        courseModelArrayList.add(new AstroModel("DSA", R.drawable.facebook));


        GridLayoutManager layoutManager = new GridLayoutManager(context, 1, LinearLayoutManager.HORIZONTAL, false);
        //  LinearLayoutManager layoutManager = new LinearLayoutManager ( context );
        b.recyclerViewList.setLayoutManager ( layoutManager );
        b.recyclerViewList.setHasFixedSize ( true );
        b.recyclerViewList.setNestedScrollingEnabled ( false );
        AstroAdapter adapter = new AstroAdapter ( context , courseModelArrayList);
        b.recyclerViewList.setAdapter (adapter);
    }


    private void vastuAstro(){
        ArrayList<AstroModel> courseModelArrayList = new ArrayList<AstroModel>();

        courseModelArrayList.add(new AstroModel("DSA", R.drawable.chatting));
        courseModelArrayList.add(new AstroModel("JAVA", R.drawable.walletl));
        courseModelArrayList.add(new AstroModel("C++", R.drawable.whatsapp));
        courseModelArrayList.add(new AstroModel("Python", R.drawable.india));
        courseModelArrayList.add(new AstroModel("Javascript", R.drawable.instagram));
        courseModelArrayList.add(new AstroModel("DSA", R.drawable.facebook));


        GridLayoutManager layoutManager = new GridLayoutManager(context, 1, LinearLayoutManager.HORIZONTAL, false);
        //  LinearLayoutManager layoutManager = new LinearLayoutManager ( context );
        b.recyclerViewVastuAstro.setLayoutManager ( layoutManager );
        b.recyclerViewVastuAstro.setHasFixedSize ( true );
        b.recyclerViewVastuAstro.setNestedScrollingEnabled ( false );
        AstrologerAdapter adapter = new AstrologerAdapter (context , courseModelArrayList);
        b.recyclerViewVastuAstro.setAdapter (adapter);
    }
    }
