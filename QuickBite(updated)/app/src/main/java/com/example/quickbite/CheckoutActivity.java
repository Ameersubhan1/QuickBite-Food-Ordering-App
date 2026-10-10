package com.example.quickbite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Toolbar toolbar = findViewById(R.id.toolbarCheckout);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        int total = getIntent().getIntExtra("total", 0);
        ArrayList<String> items = getIntent().getStringArrayListExtra("items");

        TextView totalText = findViewById(R.id.totalText);
        EditText etName = findViewById(R.id.etName);
        EditText etAddress = findViewById(R.id.etAddress);
        Button btnPay = findViewById(R.id.btnPay);

        totalText.setText("Rs " + total);

        btnPay.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String address = etAddress.getText().toString();

            if (name.isEmpty() || address.isEmpty()) {
                Toast.makeText(this, "Please fill all details", Toast.LENGTH_SHORT).show();
            } else {
                saveOrderToHistory(items, total);
                Intent intent = new Intent(CheckoutActivity.this, OrderDetailsActivity.class);
                intent.putExtra("total", total);
                intent.putStringArrayListExtra("items", items);
                startActivity(intent);
                finish();
            }
        });
    }

    private void saveOrderToHistory(ArrayList<String> items, int total) {
        android.content.SharedPreferences prefs = getSharedPreferences("QuickBitePrefs", android.content.Context.MODE_PRIVATE);
        java.util.Set<String> history = prefs.getStringSet("order_history", new java.util.HashSet<>());
        java.util.Set<String> newHistory = new java.util.HashSet<>(history);
        
        String orderSummary = "Order: " + (items != null ? items.toString() : "No items") + " - Total: Rs " + total;
        newHistory.add(orderSummary);
        
        prefs.edit().putStringSet("order_history", newHistory).apply();
    }
}