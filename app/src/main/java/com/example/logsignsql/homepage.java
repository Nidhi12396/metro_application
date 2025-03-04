package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.logsignsql.page1;
import com.example.logsignsql.page2;
import com.example.logsignsql.page3;
import com.example.logsignsql.page4;
import com.example.logsignsql.page5;
import com.example.logsignsql.page6;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Find all 6 blocks
        TextView box1 = findViewById(R.id.b1);
        TextView box2 = findViewById(R.id.b2);
        TextView box3 = findViewById(R.id.b3);
        TextView box4 = findViewById(R.id.b4);
        TextView box5 = findViewById(R.id.b5);
        TextView box6 = findViewById(R.id.b6);

        // Set click listeners to open different pages
        box1.setOnClickListener(v -> openPage(page1.class));
        box2.setOnClickListener(v -> openPage(page2.class));
        box3.setOnClickListener(v -> openPage(page3.class));
        box4.setOnClickListener(v -> openPage(page4.class));
        box5.setOnClickListener(v -> openPage(page5.class));
        box6.setOnClickListener(v -> openPage(page6.class));
    }

    // Helper method to open pages
    private void openPage(Class<?> activityClass) {
        Intent intent = new Intent(homepage.this, activityClass);
        startActivity(intent);
    }
}
