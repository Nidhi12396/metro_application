//package com.example.logsignsql;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {
//
//    private List<Ticket> ticketList;
//
//    public TicketAdapter(List<Ticket> ticketList) {
//        this.ticketList = ticketList;
//    }
//
//    @NonNull
//    @Override
//    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_ticket, parent, false);
//        return new TicketViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
//        Ticket ticket = ticketList.get(position);
//        holder.textDescription.setText(ticket.getDescription());
//
//        // Format timestamp to readable date/time
//        String timeString = new SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
//                .format(new Date(ticket.getTimestamp()));
//        holder.textTime.setText("Booked on: " + timeString);
//    }
//
//    @Override
//    public int getItemCount() {
//        return ticketList.size();
//    }
//
//    public void updateList(List<Ticket> newTickets) {
//        this.ticketList = newTickets;
//        notifyDataSetChanged();
//    }
//
//    static class TicketViewHolder extends RecyclerView.ViewHolder {
//        TextView textDescription, textTime;
//
//        public TicketViewHolder(@NonNull View itemView) {
//            super(itemView);
//            textDescription = itemView.findViewById(R.id.textDescription);
//            textTime = itemView.findViewById(R.id.textTime);
//        }
//    }
//}
