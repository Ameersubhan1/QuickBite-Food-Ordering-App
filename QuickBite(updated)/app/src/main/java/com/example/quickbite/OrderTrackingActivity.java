package com.example.quickbite;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.card.MaterialCardView;

public class OrderTrackingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_tracking);

        Toolbar toolbar = findViewById(R.id.toolbarTracking);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        Button btnBackHome = findViewById(R.id.btnTrackingBackToHome);
        btnBackHome.setOnClickListener(v -> {
            Intent intent = new Intent(OrderTrackingActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        // Feedback Logic
        MaterialCardView cardFeedback = findViewById(R.id.cardFeedback);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        EditText etFeedbackMessage = findViewById(R.id.etFeedbackMessage);
        Button btnSubmitFeedback = findViewById(R.id.btnSubmitFeedback);
        
        android.view.View layoutDelivered = findViewById(R.id.layoutDelivered);
        android.view.View dot4 = findViewById(R.id.dot4);
        android.widget.TextView tvDelivered = findViewById(R.id.tvDelivered);

        // Simulating Order Delivery after 4 seconds
        cardFeedback.postDelayed(() -> {
            // Update UI to show Delivered status
            layoutDelivered.setAlpha(1.0f);
            dot4.setBackgroundResource(R.drawable.circle_green);
            tvDelivered.setTextColor(getResources().getColor(R.color.black));
            tvDelivered.setTypeface(null, android.graphics.Typeface.BOLD);
            
            // Show Feedback Card
            cardFeedback.setVisibility(android.view.View.VISIBLE);
        }, 4000);

        btnSubmitFeedback.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            String message = etFeedbackMessage.getText().toString();

            if (rating == 0) {
                Toast.makeText(this, "Please provide a rating", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Thank you for your feedback! Rating: " + rating, Toast.LENGTH_LONG).show();
                cardFeedback.setVisibility(android.view.View.GONE);
                etFeedbackMessage.setText("");
                ratingBar.setRating(0);
            }
        });

        WebView webView = findViewById(R.id.webViewMap);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        
        // Showing a live OpenStreetMap view of a city area
        String mapUrl = "https://www.openstreetmap.org/export/embed.html?bbox=67.0011%2C24.8607%2C67.0611%2C24.9207&layer=mapnik&marker=24.8907%2C67.0311";
        webView.loadUrl(mapUrl);
    }
}