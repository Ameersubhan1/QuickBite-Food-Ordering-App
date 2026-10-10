package com.example.quickbite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class OrderHistoryAdapter extends ArrayAdapter<String> {

    public OrderHistoryAdapter(@NonNull Context context, @NonNull List<String> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_order_history, parent, false);
        }

        String orderData = getItem(position);
        TextView tvItems = convertView.findViewById(R.id.tvOrderItems);
        TextView tvAmount = convertView.findViewById(R.id.tvOrderAmount);
        TextView tvDate = convertView.findViewById(R.id.tvOrderDate);

        // Mock parsing for demonstration as we are currently storing order summary as strings
        // Format assumed: "Items: ... | Total: Rs ..."
        if (orderData != null && orderData.contains("|")) {
            String[] parts = orderData.split("\\|");
            tvItems.setText(parts[0].replace("Items: ", "").trim());
            tvAmount.setText(parts[1].replace("Total: ", "").trim());
        } else {
            tvItems.setText(orderData);
            tvAmount.setText("");
        }
        
        // Setting a fixed date for mock entries
        tvDate.setText(getContext().getString(R.string.order_date_today));

        return convertView;
    }
}