package com.example.astroget.Screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

import com.example.astroget.R;
import com.example.astroget.databinding.ActivityAstrologerProfileBinding;
import com.example.astroget.databinding.ActivityHomePageBinding;

public class AstrologerProfileActivity extends AppCompatActivity {
    ActivityAstrologerProfileBinding b;
    Context context;
    private static final float BLUR_RADIUS = 25f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityAstrologerProfileBinding.inflate(getLayoutInflater());
        context = getApplicationContext();
        setContentView(b.getRoot());

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.images);
//        Bitmap blurredBitmap = blur(bitmap);
//        b.ivAstrologerProfileImage.setImageBitmap(blurredBitmap);


    }


    public Bitmap blur(Bitmap image) {
        if (null == image) return null;

        Bitmap outputBitmap = Bitmap.createBitmap(image);
        final RenderScript renderScript = RenderScript.create(this);
        Allocation tmpIn = Allocation.createFromBitmap(renderScript, image);
        Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);

        //Intrinsic Gausian blur filter
        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);
        return outputBitmap;
    }
}