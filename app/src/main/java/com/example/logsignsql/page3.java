package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class page3 extends AppCompatActivity {

    private ImageView myImageView;
    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        // Initialize ImageView
        myImageView = findViewById(R.id.myImageView);
        myImageView.setImageResource(R.drawable.timetable);

        // Initialize back arrow ImageView
        backArrow = findViewById(R.id.backArrow); // Make sure your layout has this ID
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to home page (MainActivity)
                Intent intent = new Intent(page3.this, homepage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // Optional
            }
        });
    }
}
