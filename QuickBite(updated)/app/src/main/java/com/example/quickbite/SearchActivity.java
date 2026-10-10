package com.example.quickbite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchActivity extends AppCompatActivity {

    private ArrayList<String> recentSearches;
    private ArrayAdapter<String> recentAdapter;
    private SearchAdapter resultsAdapter;
    private ArrayList<SearchItem> filteredResults;
    private SharedPreferences prefs;
    
    private LinearLayout layoutRecent, layoutResults;
    private ListView lvRecent, lvResults;
    private EditText etSearch;
    
    private static final String PREF_NAME = "QuickBitePrefs";
    private static final String KEY_RECENT = "recent_searches";

    // Mock data for search with Categories and Images
    private final List<SearchItem> allItems = Arrays.asList(
            new SearchItem("Pizza Hut", "Fast Food", R.drawable.pizza),
            new SearchItem("Burger King", "Fast Food", R.drawable.burger),
            new SearchItem("Student Biryani", "Main Course", R.drawable.biryani),
            new SearchItem("Butt Karahi", "Desi", R.drawable.karahi),
            new SearchItem("Zinger Burger", "Burger", "https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=500&q=80"),
            new SearchItem("Chicken Tikka", "Desi", "https://images.unsplash.com/photo-1599487488170-d11ec9c172f0?w=500&q=80"),
            new SearchItem("Chinese Rice", "Chinese", "https://images.unsplash.com/photo-1512058560366-cd2429555614?w=500&q=80"),
            new SearchItem("Pasta", "Italian", "https://images.unsplash.com/photo-1473093226795-af9932fe5856?w=500&q=80"),
            new SearchItem("Deal 1", "Promotions", "https://images.unsplash.com/photo-1504674900247-0877df9cc836?w=500&q=80"),
            new SearchItem("Family Platter", "Deals", "https://images.unsplash.com/photo-1543353071-873f17a7a088?w=500&q=80")
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        
        layoutRecent = findViewById(R.id.layoutRecent);
        layoutResults = findViewById(R.id.layoutResults);
        lvRecent = findViewById(R.id.lvRecentSearches);
        lvResults = findViewById(R.id.lvSearchResults);
        etSearch = findViewById(R.id.etSearchInput);
        ImageView btnBack = findViewById(R.id.btnBackSearch);

        loadRecentSearches();

        recentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recentSearches);
        lvRecent.setAdapter(recentAdapter);

        filteredResults = new ArrayList<>();
        resultsAdapter = new SearchAdapter(this, filteredResults);
        lvResults.setAdapter(resultsAdapter);

        btnBack.setOnClickListener(v -> {
            if (layoutResults.getVisibility() == View.VISIBLE) {
                showRecent();
            } else {
                finish();
            }
        });

        etSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                String query = etSearch.getText().toString().trim();
                if (!query.isEmpty()) {
                    performSearch(query);
                }
                return true;
            }
            return false;
        });

        lvRecent.setOnItemClickListener((parent, view, position, id) -> {
            String selected = recentSearches.get(position);
            etSearch.setText(selected);
            performSearch(selected);
        });

        lvResults.setOnItemClickListener((parent, view, position, id) -> {
            SearchItem selected = filteredResults.get(position);
            Intent intent = new Intent(SearchActivity.this, RestaurantDetailActivity.class);
            intent.putExtra("resName", selected.getName());
            intent.putExtra("resImage", selected.getImageUrl());
            intent.putExtra("resImageId", selected.getImageResId());
            startActivity(intent);
        });
    }

    private void loadRecentSearches() {
        Set<String> set = prefs.getStringSet(KEY_RECENT, null);
        if (set == null) {
            recentSearches = new ArrayList<>(Arrays.asList("Pizza", "Burger", "Biryani"));
        } else {
            recentSearches = new ArrayList<>(set);
        }
    }

    private void performSearch(String query) {
        // Save to recent
        if (!recentSearches.contains(query)) {
            recentSearches.add(0, query);
            if (recentSearches.size() > 10) recentSearches.remove(recentSearches.size() - 1);
            recentAdapter.notifyDataSetChanged();
            saveRecentSearches();
        }

        // Filter results
        filteredResults.clear();
        for (SearchItem item : allItems) {
            if (item.getName().toLowerCase().contains(query.toLowerCase()) || 
                item.getCategory().toLowerCase().contains(query.toLowerCase())) {
                filteredResults.add(item);
            }
        }

        layoutRecent.setVisibility(View.GONE);
        layoutResults.setVisibility(View.VISIBLE);
        resultsAdapter.notifyDataSetChanged();
    }

    private void showRecent() {
        layoutResults.setVisibility(View.GONE);
        layoutRecent.setVisibility(View.VISIBLE);
        etSearch.setText("");
    }

    private void saveRecentSearches() {
        SharedPreferences.Editor editor = prefs.edit();
        Set<String> set = new HashSet<>(recentSearches);
        editor.putStringSet(KEY_RECENT, set);
        editor.apply();
    }

    @Override
    public void onBackPressed() {
        if (layoutResults.getVisibility() == View.VISIBLE) {
            showRecent();
        } else {
            super.onBackPressed();
        }
    }
}