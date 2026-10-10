package com.example.quickbite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Toolbar toolbar = findViewById(R.id.toolbarCart);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        int total = getIntent().getIntExtra("total", 0);
        ArrayList<String> items = getIntent().getStringArrayListExtra("items");

        TextView itemsListText = findViewById(R.id.itemsListText);
        TextView totalText = findViewById(R.id.totalText);
        Button btnCheckout = findViewById(R.id.btnCheckout);

        if (items != null && !items.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String item : items) {
                sb.append("• ").append(item).append("\n");
            }
            itemsListText.setText(sb.toString());
        }

        totalText.setText("Rs " + total);

        btnCheckout.setOnClickListener(v -> {
            Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
            intent.putExtra("total", total);
            intent.putStringArrayListExtra("items", items);
            startActivity(intent);
        });
    }
}