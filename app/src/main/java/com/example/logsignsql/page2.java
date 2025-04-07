package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class page2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2); // Ensure your layout is named activity_page2.xml

        // Set the metro map image (optional if already in XML)
        ImageView metroMap = findViewById(R.id.metroMapImage);
        metroMap.setImageResource(R.drawable.metro_map);

        // Set up the back arrow functionality
        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If you want to go to MainActivity (Home), use this:
                Intent intent = new Intent(page2.this, homepage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // Optional, finishes the current activity

                // If you just want to go to the previous screen:
                // onBackPressed();
            }
        });
    }
}
