package com.example.logsignsql;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.appcompat.app.AppCompatActivity;

public class page6 extends AppCompatActivity {
    private ScrollView scrollViewTwoImages, scrollViewSixImages;
    private Button btnShowTwoImages, btnShowSixImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        btnShowTwoImages = findViewById(R.id.btnShowTwoImages);
        btnShowSixImages = findViewById(R.id.btnShowSixImages);
        scrollViewTwoImages = findViewById(R.id.scrollView);
        scrollViewSixImages = findViewById(R.id.scrollViewSixImages);

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
    }
}
