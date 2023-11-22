package com.example.astroget.Screen.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.astroget.R;
import com.example.astroget.Screen.HomePageActivity;
import com.example.astroget.SessionManager;
import com.example.astroget.databinding.ActivityMainBinding;
import com.example.astroget.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {
ActivityOtpBinding b;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b= ActivityOtpBinding.inflate(getLayoutInflater());
        context=getApplicationContext();
        setContentView(b.getRoot());
        listener();
    }

    private void listener(){
        // setting onClickListener on Button
        b.pinViewOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // getting the PinView data
                String otp=b.pinViewOtp.getText().toString();

                // Toast to show the OTP Data
                Toast.makeText(OtpActivity.this, otp, Toast.LENGTH_SHORT).show();

            }
        });



        b.btnOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OtpActivity.this, HomePageActivity.class));
            }
        });
    }

}