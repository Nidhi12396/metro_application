package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class page1 extends AppCompatActivity {

    private Spinner fromSpinner, toSpinner;
    private TextView textFrom, textTo, textQuantity;
    private Button btnNextPage, btnIncreasePassenger, btnDecreasePassenger;
    private int passengerCount = 1; // Default count
    private HashMap<String, Integer> stationMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        fromSpinner = findViewById(R.id.fromSpinner);
        toSpinner = findViewById(R.id.toSpinner);
        textFrom = findViewById(R.id.textFrom);
        textTo = findViewById(R.id.textTo);
        textQuantity = findViewById(R.id.textPassengerCount);
        btnNextPage = findViewById(R.id.btnNextPage);
        btnIncreasePassenger = findViewById(R.id.btnIncreasePassenger);
        btnDecreasePassenger = findViewById(R.id.btnDecreasePassenger);

        initializeStations();

        // Setup spinner adapters
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, stationMap.keySet().toArray(new String[0]));
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateUserInfo();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        };

        fromSpinner.setOnItemSelectedListener(itemSelectedListener);
        toSpinner.setOnItemSelectedListener(itemSelectedListener);

        // Increase passenger count
        btnIncreasePassenger.setOnClickListener(v -> {
            if (passengerCount < 10) { // Set a max limit (change as needed)
                passengerCount++;
                updateUserInfo();
            }
        });

        // Decrease passenger count
        btnDecreasePassenger.setOnClickListener(v -> {
            if (passengerCount > 1) { // Minimum should be 1
                passengerCount--;
                updateUserInfo();
            }
        });

        // Next Page Button
        btnNextPage.setOnClickListener(v -> {
            String fromStation = fromSpinner.getSelectedItem().toString();
            String toStation = toSpinner.getSelectedItem().toString();

            // Calculate the number of stations between from and to
            int fromIndex = stationMap.get(fromStation);
            int toIndex = stationMap.get(toStation);
            int stationCount = Math.abs(toIndex - fromIndex);
            int price = stationCount * 5 * passengerCount; // ₹5 per station per passenger

            // Fetch user email from login page
            String userEmail = getIntent().getStringExtra("userEmail");

            // Start Ticket Page (page12)
            Intent intent = new Intent(page1.this, page11.class);
            intent.putExtra("fromStation", fromStation);
            intent.putExtra("toStation", toStation);
            intent.putExtra("passengerCount", passengerCount);
            intent.putExtra("ticketPrice", price);
            intent.putExtra("userEmail", userEmail);
            startActivity(intent);
        });

//        btnNextPage.setOnClickListener(v -> {
//            String fromStation = fromSpinner.getSelectedItem().toString();
//            String toStation = toSpinner.getSelectedItem().toString();
//            int fromIndex = stationMap.get(fromStation);
//            int toIndex = stationMap.get(toStation);
//            int stationCount = Math.abs(toIndex - fromIndex);
//            int price = stationCount * 5 * passengerCount; // ₹5 per station per passenger
//            String userEmail = getIntent().getStringExtra("userEmail"); // Fetch user email
//
//            // Create Ticket Object
//            Ticket ticket = new Ticket(userEmail, fromStation, toStation, price, System.currentTimeMillis());
//
//            // Send Ticket Object to Next Activity
//            Intent intent = new Intent(page1.this, page4.class);
//            intent.putExtra("ticket", ticket);  // Pass Ticket
//            startActivity(intent);
//        });





    }

    private void initializeStations() {
        stationMap = new HashMap<>();
        stationMap.put("Vastral Gam", 1);
        stationMap.put("Nirant Cross Road", 2);
        stationMap.put("Vastral", 3);
        stationMap.put("Rabari Colony", 4);
        stationMap.put("Amraivadi", 5);
        stationMap.put("Apparel Park", 6);
        stationMap.put("Kankariya East", 7);
        // Add more stations here...
    }

    private void updateUserInfo() {
        String startStation = fromSpinner.getSelectedItem().toString();
        String endStation = toSpinner.getSelectedItem().toString();

        if (!startStation.equals(endStation)) {
            textFrom.setText("From: " + startStation);
            textTo.setText("To: " + endStation);
            textQuantity.setText(String.valueOf(passengerCount)); // Update passenger count display
        } else {
            textFrom.setText("Select different stations");
            textTo.setText("");
            textQuantity.setText("1");
        }
    }
}
