package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class page11 extends AppCompatActivity {

    private TextView textFrom, textTo, textPassengers, textPrice, textEmail;
    private ImageView imageLogo, backArrow;
    private Button btnNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page11);

        textEmail = findViewById(R.id.textEmail);
        textFrom = findViewById(R.id.textFrom);
        textTo = findViewById(R.id.textTo);
        textPassengers = findViewById(R.id.textPassengers);
        textPrice = findViewById(R.id.textPrice);
        imageLogo = findViewById(R.id.imageLogo);
        btnNextPage = findViewById(R.id.btnNextPage);
        backArrow = findViewById(R.id.backArrow); // Make sure you have this in your XML layout

        // Get data from Intent
        String fromStation = getIntent().getStringExtra("fromStation");
        String toStation = getIntent().getStringExtra("toStation");
        int passengerCount = getIntent().getIntExtra("passengerCount", 1);
        int ticketPrice = getIntent().getIntExtra("ticketPrice", 0);
        String userEmail = getIntent().getStringExtra("userEmail");

        // Set ticket details
        textEmail.setText("Email: " + userEmail);
        textFrom.setText("From: " + fromStation);
        textTo.setText("To: " + toStation);
        textPassengers.setText("Passengers: " + passengerCount);
        textPrice.setText("Total Price: ₹" + ticketPrice);

        // Next Page Button (Go to Page12 and Pass Data)
        btnNextPage.setOnClickListener(v -> {
            Log.d("DEBUG", "Button clicked, starting page12");

            Intent intent = new Intent(page11.this, page12.class);
            intent.putExtra("fromStation", fromStation);
            intent.putExtra("toStation", toStation);
            intent.putExtra("passengerCount", passengerCount);
            intent.putExtra("ticketPrice", ticketPrice);
            intent.putExtra("userEmail", userEmail);

            startActivity(intent);
        });

        // Back arrow functionality
        backArrow.setOnClickListener(v -> {
            Intent intent = new Intent(page11.this, page1.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            finish();
        });
    }
}
