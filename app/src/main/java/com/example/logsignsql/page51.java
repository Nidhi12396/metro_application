package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class page51 extends AppCompatActivity {

    private TextView textFromTo, textFare;
    private Button btnNext;
    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page51);

        textFromTo = findViewById(R.id.textFromTo);
        textFare = findViewById(R.id.textFare);
        btnNext = findViewById(R.id.btnNext);
        backArrow = findViewById(R.id.backArrow); // Make sure this ID is in your XML layout

        // Get Data from Intent
        Intent intent = getIntent();
        String fromStation = intent.getStringExtra("fromStation");
        String toStation = intent.getStringExtra("toStation");
        int fare = intent.getIntExtra("fare", 5);

        // Set Data in TextViews
        textFromTo.setText("From: " + fromStation + "\nTo: " + toStation);
        textFare.setText("Total Fare: ₹" + fare);

        // Next Button (Replace or Modify to Go to Next Page)
        btnNext.setOnClickListener(v -> {
            // Example: Just reload this activity
            Intent nextIntent = new Intent(page51.this, page51.class);
            startActivity(nextIntent);
        });

        // Back Arrow functionality
        backArrow.setOnClickListener(v -> {
            Intent homeIntent = new Intent(page51.this, page5.class);
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(homeIntent);
            finish();
        });
    }
}
