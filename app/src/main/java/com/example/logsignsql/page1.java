package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class page1 extends AppCompatActivity {

    private int counter = 1;  // Default counter value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        // Find Views
        EditText editFrom = findViewById(R.id.from);
        EditText editTo = findViewById(R.id.to);
        TextView textCounter = findViewById(R.id.Counter);
        Button btnIncrement = findViewById(R.id.inc);
        Button btnDecrement = findViewById(R.id.dec);
        Button btnNext = findViewById(R.id.btnNext);

        // Increment Counter
        btnIncrement.setOnClickListener(v -> {
            counter++;
            textCounter.setText(String.valueOf(counter));
        });

        // Decrement Counter (Minimum 1)
        btnDecrement.setOnClickListener(v -> {
            if (counter > 1) {
                counter--;
                textCounter.setText(String.valueOf(counter));
            }
        });

        // Next Button Click -> Redirect to Another Page
        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(page1.this, page11.class);
            startActivity(intent);
        });
    }
}
