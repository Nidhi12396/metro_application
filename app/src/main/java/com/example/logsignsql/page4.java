package com.example.logsignsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class page4 extends AppCompatActivity {

    private Button btnActiveList, btnPastList;
    private RecyclerView recyclerViewTickets;
    private TicketAdapter ticketAdapter;
    private List<Ticket> allTickets, activeTickets, pastTickets;
    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        // Initialize views
        btnActiveList = findViewById(R.id.btnActiveList);
        btnPastList = findViewById(R.id.btnPastList);
        recyclerViewTickets = findViewById(R.id.recyclerViewTickets);
        backArrow = findViewById(R.id.backArrow);

        // Set back arrow functionality
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page4.this, homepage.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // optional: closes current activity
            }
        });

        // Load ticket data
        allTickets = fetchTickets();
        activeTickets = new ArrayList<>();
        pastTickets = new ArrayList<>();

        // Filter tickets into active and past lists
        long currentTime = System.currentTimeMillis();
        long twoHoursInMillis = 2 * 60 * 60 * 1000;

        for (Ticket ticket : allTickets) {
            if (currentTime - ticket.getTimestamp() <= twoHoursInMillis) {
                activeTickets.add(ticket);
            } else {
                pastTickets.add(ticket);
            }
        }

        // Set up RecyclerView
        ticketAdapter = new TicketAdapter(activeTickets); // Default: show active tickets
        recyclerViewTickets.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTickets.setAdapter(ticketAdapter);

        // Button Click Listeners
        btnActiveList.setOnClickListener(view -> {
            ticketAdapter.updateList(activeTickets);
            Toast.makeText(this, "Showing Active Tickets", Toast.LENGTH_SHORT).show();
        });

        btnPastList.setOnClickListener(view -> {
            ticketAdapter.updateList(pastTickets);
            Toast.makeText(this, "Showing Past Tickets", Toast.LENGTH_SHORT).show();
        });
    }

    // Simulated function to fetch tickets (replace with real database fetch)
    private List<Ticket> fetchTickets() {
        List<Ticket> tickets = new ArrayList<>();
        long currentTime = System.currentTimeMillis();

        // Dummy ticket data
        tickets.add(new Ticket("From A to B", currentTime - 30 * 60 * 1000)); // 30 mins ago
        tickets.add(new Ticket("From C to D", currentTime - 3 * 60 * 60 * 1000)); // 3 hours ago
        tickets.add(new Ticket("From E to F", currentTime - 90 * 60 * 1000)); // 1.5 hours ago
        tickets.add(new Ticket("From G to H", currentTime - 5 * 60 * 60 * 1000)); // 5 hours ago

        return tickets;
    }
}
