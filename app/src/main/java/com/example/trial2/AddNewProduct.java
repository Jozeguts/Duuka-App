package com.example.trial2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class AddNewProduct extends AppCompatActivity {

    // Assume you have references to the input fields for product details
    // For demonstration, let's say you have TextInputLayouts and MaterialAutoCompleteTextViews

    // TextInputLayouts for product details
    private TextInputLayout productTitleInputLayout;
    private TextInputLayout shortDescriptionInputLayout;
    private TextInputLayout productBriefInputLayout;
    private TextInputLayout productPriceInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_add_new_product);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Initialize TextInputLayouts
        productTitleInputLayout = findViewById(R.id.product_title_input_layout);
        shortDescriptionInputLayout = findViewById(R.id.short_description_input_layout);
        productBriefInputLayout = findViewById(R.id.product_brief_input_layout);
        productPriceInputLayout = findViewById(R.id.product_price_input_layout);

        // Get reference to the "Add Product" TextView
        TextView addProductTextView = findViewById(R.id.tvAddProduct);

        // Set click listener for "Add Product" TextView
        addProductTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Collect product details from input fields
                String productTitle = productTitleInputLayout.getEditText().getText().toString().trim();
                String shortDescription = shortDescriptionInputLayout.getEditText().getText().toString().trim();
                String productBrief = productBriefInputLayout.getEditText().getText().toString().trim();
                String productPrice = productPriceInputLayout.getEditText().getText().toString().trim();

                // Validate input data
                if (productTitle.isEmpty() || shortDescription.isEmpty() || productBrief.isEmpty() || productPrice.isEmpty()) {
                    // Show error message if any field is empty
                    Toast.makeText(AddNewProduct.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return; // Exit onClick method if validation fails
                }

                // TODO: Save product details to a database or other storage mechanism
                // For demonstration, let's assume product addition is successful
                boolean productAddedSuccessfully = true; // Replace with actual logic

                if (productAddedSuccessfully) {
                    // Show success message
                    Toast.makeText(AddNewProduct.this, "Product added successfully", Toast.LENGTH_SHORT).show();
                    // Navigate back to the previous activity
                    finish();

                    startActivity(new Intent(AddNewProduct.this, AdminDashboard.class));

                } else {
                    // Show error message if product addition fails
                    Toast.makeText(AddNewProduct.this, "Failed to add product", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
