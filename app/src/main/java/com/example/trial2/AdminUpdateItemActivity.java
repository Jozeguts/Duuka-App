package com.example.trial2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AdminUpdateItemActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_update_item);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get product details from intent extras
        int quantity;
        String productName = getIntent().getStringExtra("productName");
        String productDescription = getIntent().getStringExtra("productDescription");
        double productPrice = getIntent().getDoubleExtra("productPrice", 0);
        quantity = getIntent().getIntExtra("productQuantity", 0); // Added line to get quantity

        // Set product details to TextViews
        TextView productNameTextView = findViewById(R.id.productName);
        // TextView productDescriptionTextView = findViewById(R.id.productDescriptionTextView); No ID with this name in the XML
        TextView productPriceTextView = findViewById(R.id.productPrice);
        TextView productQuantityTextView = findViewById(R.id.productQuantity); // Added line to get TextView for quantity

    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle back button press
        onBackPressed();
        return true;
    }
}
