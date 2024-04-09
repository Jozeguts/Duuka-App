package com.example.trial2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminViewItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_item);


        // Get product details from intent
        Product product = getIntent().getParcelableExtra("product");

        // Set product details to views
        ImageView productImageView = findViewById(R.id.productImage);
        TextView productNameTextView = findViewById(R.id.productName);
        TextView productDescriptionTextView = findViewById(R.id.productDescription);
        TextView productPriceTextView = findViewById(R.id.productPrice);
        TextView productQuantityTextView = findViewById(R.id.productQuantity);

        productImageView.setImageResource(product.getImageResource());
        productNameTextView.setText(product.getName());
        productDescriptionTextView.setText(product.getDescription());
        productPriceTextView.setText("UGX: "+product.getPrice());
        productQuantityTextView.setText(product.getQuantity()+"Items Left");


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Navigate back to previous activity
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}