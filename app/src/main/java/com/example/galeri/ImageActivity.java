package com.example.galeri;



import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;



public class ImageActivity extends AppCompatActivity{
    ImageView Imagefullview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Imagefullview=(ImageView) findViewById(R.id.fullimagesize);
        String x = getIntent().getExtras().getString("img");
        Imagefullview.setImageURI(Uri.parse(x));

    }
}

