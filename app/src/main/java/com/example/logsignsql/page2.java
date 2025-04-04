package com.example.logsignsql;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2); // Use your XML file name here

        // Find ImageView
        ImageView metroMap = findViewById(R.id.metroMapImage);

        // Set the metro map image (optional, since it's already in XML)
        metroMap.setImageResource(R.drawable.metro_map);
    }
}
