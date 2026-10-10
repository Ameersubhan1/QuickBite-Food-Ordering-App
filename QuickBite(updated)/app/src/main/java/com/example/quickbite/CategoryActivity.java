package com.example.quickbite;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String category = getIntent().getStringExtra("category");
        TextView tvTitle = findViewById(R.id.tvCategoryTitle);
        if (category != null) tvTitle.setText(category);

        Toolbar toolbar = findViewById(R.id.toolbarCategory);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        
        // Toolbar ke back button par click listener
        toolbar.setNavigationOnClickListener(v -> onBackPressed());

        ListView listView = findViewById(R.id.lvCategoryItems);
        
        // Mock data based on category
        List<SearchItem> items = new ArrayList<>();
        if ("Food".equals(category)) {
            items.add(new SearchItem("Pizza Hut", "Fast Food", "https://images.unsplash.com/photo-1513104890138-7c749659a591?w=500&q=80"));
            items.add(new SearchItem("Burger King", "Fast Food", "https://images.unsplash.com/photo-1571091718767-18b5b1457add?w=500&q=80"));
            items.add(new SearchItem("Zinger Burger", "Burger", "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=500&q=80"));
        } else if ("Grocery".equals(category)) {
            items.add(new SearchItem("Fresh Milk", "Dairy", "https://images.unsplash.com/photo-1563636619-e9143da7973b?w=400&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fG1pbGt8ZW58MHx8MHx8fDA%3D"));
            items.add(new SearchItem("Bread", "Bakery", "https://images.unsplash.com/photo-1509440159596-0249088772ff?w=500&q=80"));
            items.add(new SearchItem("Eggs", "Dairy", "https://images.unsplash.com/photo-1582722872445-44dc5f7e3c8f?w=500&q=80"));
        } else {
            items.add(new SearchItem("Family Deal 1", "Promo", "https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=500&q=80"));
            items.add(new SearchItem("Midnight Deal", "Promo", "https://images.unsplash.com/photo-1543353071-873f17a7a088?w=500&q=80"));
        }

        SearchAdapter adapter = new SearchAdapter(this, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            SearchItem selected = items.get(position);
            Intent intent = new Intent(CategoryActivity.this, RestaurantDetailActivity.class);
            intent.putExtra("resName", selected.getName());
            intent.putExtra("resImage", selected.getImageUrl());
            startActivity(intent);
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}