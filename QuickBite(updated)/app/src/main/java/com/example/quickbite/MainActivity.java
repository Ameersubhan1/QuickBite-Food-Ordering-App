package com.example.quickbite;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialCardView pizzaHut = findViewById(R.id.resPizzaHut);
        MaterialCardView burgerKing = findViewById(R.id.resBurgerKing);
        MaterialCardView studentBiryani = findViewById(R.id.resStudentBiryani);
        MaterialCardView buttKarahi = findViewById(R.id.resButtKarahi);

        // Navigation Items
        ImageView navHome = findViewById(R.id.navHome);
        ImageView navSearch = findViewById(R.id.navSearch);
        ImageView navCart = findViewById(R.id.navCart);
        ImageView navProfile = findViewById(R.id.navProfile);

        pizzaHut.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RestaurantDetailActivity.class);
            intent.putExtra("resName", "Pizza Hut");
            intent.putExtra("resImageId", R.drawable.pizza);
            startActivity(intent);
        });

        burgerKing.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RestaurantDetailActivity.class);
            intent.putExtra("resName", "Burger King");
            intent.putExtra("resImageId", R.drawable.burger);
            startActivity(intent);
        });

        studentBiryani.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RestaurantDetailActivity.class);
            intent.putExtra("resName", "Student Biryani");
            intent.putExtra("resImageId", R.drawable.biryani);
            startActivity(intent);
        });

        buttKarahi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RestaurantDetailActivity.class);
            intent.putExtra("resName", "Butt Karahi");
            intent.putExtra("resImageId", R.drawable.karahi);
            startActivity(intent);
        });

        navSearch.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, SearchActivity.class));
        });

        navCart.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, CartActivity.class));
        });

        navProfile.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        });

        LinearLayout btnFood = findViewById(R.id.btnCategoryFood);
        LinearLayout btnGrocery = findViewById(R.id.btnCategoryGrocery);
        LinearLayout btnDeals = findViewById(R.id.btnCategoryDeals);

        btnFood.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("category", "Food");
            startActivity(intent);
        });

        btnGrocery.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("category", "Grocery");
            startActivity(intent);
        });

        btnDeals.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra("category", "Deals");
            startActivity(intent);
        });
    }
}