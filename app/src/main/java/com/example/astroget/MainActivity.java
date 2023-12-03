package com.example.astroget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.astroget.Screen.HomePageActivity;
import com.example.astroget.Screen.Login.LoginActivity;
import com.example.astroget.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding b;
SessionManager sessionManager;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=ActivityMainBinding.inflate(getLayoutInflater());
        context=getApplicationContext();
        sessionManager = new SessionManager(context);
        setContentView(b.getRoot());


        start();
    }
    private void start(){
     new Handler().postDelayed(new Runnable() {
                              @Override
                              public void run() {
                                  if (sessionManager.isLoggedIn()) {
                                      startActivity(new Intent(context, HomePageActivity.class));
                                  } else {
                                      startActivity(new Intent(context, LoginActivity.class));
                                      finish();
                                  }
                              }
                          },1300);
    }

}