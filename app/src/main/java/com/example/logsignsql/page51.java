package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class page51 extends AppCompatActivity {

    private TextView textFromTo, textFare;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page51);

        textFromTo = findViewById(R.id.textFromTo);
        textFare = findViewById(R.id.textFare);
        btnNext = findViewById(R.id.btnNext);

        // Get Data from Intent
        Intent intent = getIntent();
        String fromStation = intent.getStringExtra("fromStation");
        String toStation = intent.getStringExtra("toStation");
        int fare = intent.getIntExtra("fare", 5);

        // Set Data in TextViews
        textFromTo.setText("From: " + fromStation + "\nTo: " + toStation);
        textFare.setText("Total Fare: ₹" + fare);

        // Button Click Redirect
        btnNext.setOnClickListener(v -> {
            Intent nextIntent = new Intent(page51.this, page51.class);
            startActivity(nextIntent);
        });
    }
}
