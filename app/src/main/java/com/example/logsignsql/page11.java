package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class page11 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page11);

        // Retrieve data from previous page
        Intent intent = getIntent();
        String from = intent.getStringExtra("from");
        String to = intent.getStringExtra("to");
        int quantity = intent.getIntExtra("quantity", 1);

        // Set data in TextViews
        TextView textFrom = findViewById(R.id.textFrom);
        TextView textTo = findViewById(R.id.textTo);
        TextView textQuantity = findViewById(R.id.textQuantity);

        textFrom.setText("From: " + from);
        textTo.setText("To: " + to);
        textQuantity.setText("Quantity: " + quantity);

        // Next Button Click
//        Button btnNextPage = findViewById(R.id.btnNextPage);
//        btnNextPage.setOnClickListener(v -> {
//            Intent nextIntent = new Intent(page11.this, page12.class);
//            startActivity(nextIntent);
//        });
    }
}
