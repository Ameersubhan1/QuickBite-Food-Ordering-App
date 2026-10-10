package com.example.quickbite;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OrderHistoryActivity extends AppCompatActivity {

    private static final String PREF_NAME = "QuickBitePrefs";
    private static final String KEY_HISTORY = "order_history";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        Toolbar toolbar = findViewById(R.id.toolbarHistory);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        ListView lvHistory = findViewById(R.id.lvOrderHistory);
        TextView tvEmpty = findViewById(R.id.tvEmptyHistory);

        SharedPreferences prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Set<String> historySet = prefs.getStringSet(KEY_HISTORY, new HashSet<>());
        ArrayList<String> historyList = new ArrayList<>(historySet);

        if (historyList.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            lvHistory.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            lvHistory.setVisibility(View.VISIBLE);
            OrderHistoryAdapter adapter = new OrderHistoryAdapter(this, historyList);
            lvHistory.setAdapter(adapter);
        }
    }
}