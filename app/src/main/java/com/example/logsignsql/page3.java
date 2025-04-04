package com.example.logsignsql;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class page3 extends AppCompatActivity {

    private ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        // Initialize ImageView
        myImageView = findViewById(R.id.myImageView);

        // Set an image programmatically
        myImageView.setImageResource(R.drawable.tt);
    }
}
