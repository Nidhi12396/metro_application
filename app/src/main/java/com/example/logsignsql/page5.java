package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class page5 extends AppCompatActivity {

    private Spinner fromSpinner, toSpinner;
    private Button btnCheckFare;
    private List<String> stationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);

        fromSpinner = findViewById(R.id.fromSpinner);
        toSpinner = findViewById(R.id.toSpinner);
        btnCheckFare = findViewById(R.id.btnCheckFare);

        initializeStations();

        // Adapter for Spinners
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, stationList);
        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        btnCheckFare.setOnClickListener(v -> {
            String fromStation = fromSpinner.getSelectedItem().toString();
            String toStation = toSpinner.getSelectedItem().toString();

            if (!fromStation.equals(toStation)) {
                Intent intent = new Intent(page5.this, page51.class);
                intent.putExtra("fromStation", fromStation);
                intent.putExtra("toStation", toStation);
                intent.putExtra("fare", calculateFare(fromStation, toStation));
                startActivity(intent);
            }
        });
    }

    private void initializeStations() {
        stationList = new ArrayList<>();
        stationList.add("Vastral Gam");
        stationList.add("Nirant Cross Road");
        stationList.add("Vastral");
        stationList.add("Rabari Colony");
        stationList.add("Amraivadi");
        stationList.add("Apparel Park");
        stationList.add("Kankariya East");
        stationList.add("Kalupur Metro Station");
        stationList.add("Gheekanta");
        stationList.add("Shahpur");
        stationList.add("Old High Court");
        stationList.add("S P Stadium");
        stationList.add("Commerce Six Road");
        stationList.add("Gujarat University");
        stationList.add("Gurukul Road");
        stationList.add("Doordarshan Kendra");
        stationList.add("Thaltej");
        stationList.add("Thaltej Gam");
    }

    private int calculateFare(String from, String to) {
        int fromIndex = stationList.indexOf(from);
        int toIndex = stationList.indexOf(to);
        int distance = Math.abs(toIndex - fromIndex);
        return 5 + (distance * 5); // Base fare is 5, increases 5 per station
    }
}
