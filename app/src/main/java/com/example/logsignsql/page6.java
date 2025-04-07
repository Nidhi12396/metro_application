package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

public class page6 extends AppCompatActivity {

    private ScrollView scrollViewTwoImages, scrollViewSixImages;
    private Button btnShowTwoImages, btnShowSixImages;
    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        btnShowTwoImages = findViewById(R.id.btnShowTwoImages);
        btnShowSixImages = findViewById(R.id.btnShowSixImages);
        scrollViewTwoImages = findViewById(R.id.scrollView);
        scrollViewSixImages = findViewById(R.id.scrollViewSixImages);
        backArrow = findViewById(R.id.backArrow);

        btnShowTwoImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollViewTwoImages.setVisibility(View.VISIBLE);
                scrollViewSixImages.setVisibility(View.GONE);
            }
        });

        btnShowSixImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollViewTwoImages.setVisibility(View.GONE);
                scrollViewSixImages.setVisibility(View.VISIBLE);
            }
        });

        // Handle back arrow click
        backArrow.setOnClickListener(v -> {
            Intent intent = new Intent(page6.this, homepage.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }
}
