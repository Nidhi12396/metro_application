package com.example.logsignsql;
public class Ticket {
    private String description;
    private long timestamp;

    public Ticket(String description, long timestamp) {
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
