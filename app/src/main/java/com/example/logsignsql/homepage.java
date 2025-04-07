package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;

public class homepage extends AppCompatActivity {

    Button bookingBtn;
    Button viewTicketBtn;
    Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        // Initialize Buttons
        bookingBtn = findViewById(R.id.booking_button);
        viewTicketBtn = findViewById(R.id.view_ticket_button);
        homeBtn = findViewById(R.id.home_button);

        // Row 1
        LinearLayout booking = findViewById(R.id.booking);
        LinearLayout map = findViewById(R.id.map);

        // Row 2
        LinearLayout timetable = findViewById(R.id.timetable);
        LinearLayout viewticket = findViewById(R.id.viewticket);

        // Row 3
        LinearLayout fareinquiry = findViewById(R.id.fareinquiry);
        LinearLayout checkroute = findViewById(R.id.checkroute);

        // Click Listeners for LinearLayouts
        booking.setOnClickListener(v -> openPage(page1.class));
        map.setOnClickListener(v -> openPage(page2.class));
        timetable.setOnClickListener(v -> openPage(page3.class));
        viewticket.setOnClickListener(v -> openPage(page4.class));
        fareinquiry.setOnClickListener(v -> openPage(page5.class));
        checkroute.setOnClickListener(v -> openPage(page6.class));

        // Click Listeners for Buttons
        bookingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(page1.class);
            }
        });

        viewTicketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(page4.class); // Assuming page4 is for view ticket
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPage(homepage.class); // Reload homepage
            }
        });
    }


    private void openPage(Class<?> activityClass) {
        Intent intent = new Intent(homepage.this, activityClass);
        startActivity(intent);
    }
}
