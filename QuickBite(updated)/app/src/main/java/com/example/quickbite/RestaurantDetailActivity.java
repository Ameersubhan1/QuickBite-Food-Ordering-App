package com.example.quickbite;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.ArrayList;

public class RestaurantDetailActivity extends AppCompatActivity {

    private int total = 0;
    private ArrayList<String> selectedItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        String resName = getIntent().getStringExtra("resName");
        String resImage = getIntent().getStringExtra("resImage");
        int resImageId = getIntent().getIntExtra("resImageId", -1);
        
        CollapsingToolbarLayout ctl = findViewById(R.id.collapsing_toolbar);
        if (resName != null) ctl.setTitle(resName);

        ImageView ivHeader = findViewById(R.id.ivRestaurantHeader);
        if (resImageId != -1) {
            ivHeader.setImageResource(resImageId);
        } else if (resImage != null) {
            Glide.with(this).load(resImage).into(ivHeader);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        
        // Click listener ko akhir mein set kiya taake ye override na ho
        toolbar.setNavigationOnClickListener(v -> finish());

        Button btnAdd1 = findViewById(R.id.btnAdd1);
        Button btnAdd2 = findViewById(R.id.btnAdd2);
        Button btnViewCart = findViewById(R.id.btnViewCartDetail);

        btnAdd1.setOnClickListener(v -> {
            total += 850;
            selectedItems.add("Special Deal 1 (Rs 850)");
            Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show();
        });

        btnAdd2.setOnClickListener(v -> {
            total += 2400;
            selectedItems.add("Family Platter (Rs 2400)");
            Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show();
        });

        btnViewCart.setOnClickListener(v -> {
            if (selectedItems.isEmpty()) {
                Toast.makeText(this, "Cart is empty!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, CartActivity.class);
                intent.putExtra("total", total);
                intent.putStringArrayListExtra("items", selectedItems);
                startActivity(intent);
            }
        });

        setupMenu(resName);
    }

    private void setupMenu(String resName) {
        TextView cat1 = findViewById(R.id.tvMenuCategory1);
        TextView cat2 = findViewById(R.id.tvMenuCategory2);
        TextView cat3 = findViewById(R.id.tvMenuCategory3);

        TextView itemName1 = findViewById(R.id.tvMenuItemName1);
        TextView itemPrice1 = findViewById(R.id.tvMenuItemPrice1);
        TextView itemName2 = findViewById(R.id.tvMenuItemName2);
        TextView itemPrice2 = findViewById(R.id.tvMenuItemPrice2);
        TextView itemName3 = findViewById(R.id.tvMenuItemName3);
        TextView itemPrice3 = findViewById(R.id.tvMenuItemPrice3);
        TextView itemName4 = findViewById(R.id.tvMenuItemName4);
        TextView itemPrice4 = findViewById(R.id.tvMenuItemPrice4);

        if ("Student Biryani".equals(resName)) {
            cat1.setText("Appetizers");
            cat2.setText("Main Course");
            cat3.setText("Drinks");

            itemName1.setText("Shami Kabab");
            itemPrice1.setText("Rs 150");
            itemName2.setText("Student Biryani Large");
            itemPrice2.setText("Rs 550");
            itemName3.setText("Chicken Pulao");
            itemPrice3.setText("Rs 450");
            itemName4.setText("Coke 500ml");
            itemPrice4.setText("Rs 120");
        } else if ("Butt Karahi".equals(resName)) {
            cat1.setText("Starters");
            cat2.setText("Mutton & Chicken");
            cat3.setText("Beverages");

            itemName1.setText("Salad & Raita");
            itemPrice1.setText("Rs 200");
            itemName2.setText("Chicken Karahi Full");
            itemPrice2.setText("Rs 2200");
            itemName3.setText("Mutton Karahi Full");
            itemPrice3.setText("Rs 3800");
            itemName4.setText("Fresh Lime");
            itemPrice4.setText("Rs 180");
        } else if ("Pizza Hut".equals(resName)) {
            cat1.setText("Starters");
            cat2.setText("Pizzas");
            cat3.setText("Drinks");

            itemName1.setText("Garlic Bread");
            itemPrice1.setText("Rs 350");
            itemName2.setText("Chicken Tikka Pizza");
            itemPrice2.setText("Rs 1800");
            itemName3.setText("Super Supreme Pizza");
            itemPrice3.setText("Rs 2100");
            itemName4.setText("Pepsi 1.5L");
            itemPrice4.setText("Rs 250");
        } else if ("Burger King".equals(resName)) {
            cat1.setText("Sides");
            cat2.setText("Burgers");
            cat3.setText("Drinks");

            itemName1.setText("French Fries");
            itemPrice1.setText("Rs 300");
            itemName2.setText("Whopper Burger");
            itemPrice2.setText("Rs 950");
            itemName3.setText("Steakhouse Burger");
            itemPrice3.setText("Rs 1200");
            itemName4.setText("Coke Regular");
            itemPrice4.setText("Rs 150");
        } else if ("Fresh Milk".equals(resName)) {
            cat1.setText("Dairy"); cat2.setText("Fresh"); cat3.setText("Others");
            itemName1.setText("1L Milk"); itemPrice1.setText("Rs 220");
            itemName2.setText("Desi Ghee"); itemPrice2.setText("Rs 2500");
            itemName3.setText("Butter"); itemPrice3.setText("Rs 600");
            itemName4.setText("Lassi"); itemPrice4.setText("Rs 150");
        } else if ("Zinger Burger".equals(resName)) {
            cat1.setText("Sides"); cat2.setText("Burgers"); cat3.setText("Drinks");
            itemName1.setText("Nuggets"); itemPrice1.setText("Rs 400");
            itemName2.setText("Zinger Burger"); itemPrice2.setText("Rs 550");
            itemName3.setText("Zinger Cheese Burger"); itemPrice3.setText("Rs 650");
            itemName4.setText("Cold Drink"); itemPrice4.setText("Rs 100");
        } else if ("Chicken Tikka".equals(resName)) {
            cat1.setText("Appetizers"); cat2.setText("BBQ"); cat3.setText("Sides");
            itemName1.setText("Fried Wings"); itemPrice1.setText("Rs 450");
            itemName2.setText("Chicken Tikka Chest"); itemPrice2.setText("Rs 400");
            itemName3.setText("Chicken Tikka Leg"); itemPrice3.setText("Rs 380");
            itemName4.setText("Naan"); itemPrice4.setText("Rs 40");
        } else if ("Chinese Rice".equals(resName)) {
            cat1.setText("Starters"); cat2.setText("Main Course"); cat3.setText("Drinks");
            itemName1.setText("Soup"); itemPrice1.setText("Rs 350");
            itemName2.setText("Egg Fried Rice"); itemPrice2.setText("Rs 600");
            itemName3.setText("Chicken Manchurian"); itemPrice3.setText("Rs 800");
            itemName4.setText("Green Tea"); itemPrice4.setText("Rs 80");
        } else if ("Pasta".equals(resName)) {
            cat1.setText("Salads"); cat2.setText("Pasta"); cat3.setText("Drinks");
            itemName1.setText("Russian Salad"); itemPrice1.setText("Rs 450");
            itemName2.setText("Fettuccine Alfredo"); itemPrice2.setText("Rs 1100");
            itemName3.setText("Penny Pasta"); itemPrice3.setText("Rs 950");
            itemName4.setText("Lemonade"); itemPrice4.setText("Rs 200");
        } else if ("Bread".equals(resName)) {
            cat1.setText("Bakery"); cat2.setText("Bread"); cat3.setText("Biscuits");
            itemName1.setText("Rusk"); itemPrice1.setText("Rs 150");
            itemName2.setText("Large White Bread"); itemPrice2.setText("Rs 210");
            itemName3.setText("Brown Bread"); itemPrice3.setText("Rs 230");
            itemName4.setText("Butter Cookies"); itemPrice4.setText("Rs 300");
        } else if ("Eggs".equals(resName)) {
            cat1.setText("Dairy"); cat2.setText("Eggs"); cat3.setText("Others");
            itemName1.setText("Brown Eggs (6)"); itemPrice1.setText("Rs 250");
            itemName2.setText("White Eggs (Dozen)"); itemPrice2.setText("Rs 400");
            itemName3.setText("Organic Eggs (Dozen)"); itemPrice3.setText("Rs 600");
            itemName4.setText("Honey"); itemPrice4.setText("Rs 1200");
        }
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
        finish();
        return true;
    }
}