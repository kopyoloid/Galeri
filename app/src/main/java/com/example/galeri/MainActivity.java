package com.example.galeri;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

   ArrayList<File> Image_Storange;
   GridView Viewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Viewer = (GridView) findViewById(R.id.image_stored);
        Image_Storange = Image_View(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/Basic"));
        Viewer.setAdapter(new View_Adapter());
        Viewer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int x, long y) {

                Intent intent = new Intent(MainActivity.this, ImageActivity.class);
                intent.putExtra("img", Image_Storange.get(x).toString());
                startActivity(intent);

            }
        });
    }
        public class View_Adapter extends BaseAdapter{
            @Override
            public int getCount() {
                return Image_Storange.size();
            }
            @Override
            public Object getItem(int x) {
                return Image_Storange.get(x);
            }
            @Override
            public long getItemId(int x) {
                return 0;
            }

            @Override
            public View getView(int x,View view, ViewGroup viewGroup) {
                View convertedImage = null;
                if(convertedImage == null)
                {
                    convertedImage = getLayoutInflater().inflate(R.layout.row_activity,viewGroup,false);
                    ImageView storedimage = convertedImage.findViewById(R.id.image_row);
                    storedimage.setImageURI(Uri.parse(Image_Storange.get(x).toString()));
                }
                return convertedImage;
            }
        }

        private ArrayList<File> Image_View(File externalStorangeDirectory){
            ArrayList<File> direct = new ArrayList<>();
            File[] files = externalStorangeDirectory.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    direct.addAll(Image_View(files[i]));
                } else {
                    if (files[i].getName().endsWith(".jpg")) {

                        direct.add(files[i]);
                    }
                }
            }

            return direct;
        }
    }
