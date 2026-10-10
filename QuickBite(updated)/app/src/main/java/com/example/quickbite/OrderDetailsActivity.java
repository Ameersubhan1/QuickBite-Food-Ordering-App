package com.example.quickbite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class OrderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        Toolbar toolbar = findViewById(R.id.toolbarOrderDetails);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        int total = getIntent().getIntExtra("total", 0);
        ArrayList<String> items = getIntent().getStringArrayListExtra("items");

        TextView tvItems = findViewById(R.id.tvOrderDetailsItems);
        TextView tvTotal = findViewById(R.id.tvOrderDetailsTotal);
        Button btnBackHome = findViewById(R.id.btnBackToHome);
        Button btnTrack = findViewById(R.id.btnTrackOrder);

        if (items != null && !items.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String item : items) {
                sb.append(item).append("\n");
            }
            tvItems.setText(sb.toString());
        }

        tvTotal.setText("Rs " + total);

        btnBackHome.setOnClickListener(v -> {
            Intent intent = new Intent(OrderDetailsActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        btnTrack.setOnClickListener(v -> {
            Intent intent = new Intent(OrderDetailsActivity.this, OrderTrackingActivity.class);
            startActivity(intent);
        });
    }
}