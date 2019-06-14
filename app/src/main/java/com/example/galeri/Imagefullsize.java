package com.example.galeri;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Imagefullsize extends AppCompatActivity {
    ImageView fullImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        fullImage = (ImageView)findViewById(R.id.fullimagesize);
        String data = getIntent().getExtras().getString("img");
        fullImage.setImageURI(Uri.parse(data));

    }
}
