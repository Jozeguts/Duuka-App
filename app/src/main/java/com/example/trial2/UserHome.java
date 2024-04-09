package com.example.trial2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class UserHome extends AppCompatActivity {

    RecyclerView recyclerView;
    Button viewCart;
    private List<Product> productList = new ArrayList<>();
    private ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        recyclerView = findViewById(R.id.productRecyclerView);
        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewCart = findViewById(R.id.gotoViewCart);

        viewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserHome.this, UserViewItem.class);
                startActivity(intent);
            }
        });

    }

    private void generateRandomProducts() {
        // Generate random data for 15 products and add them to the productList
        for (int i = 0; i < 15; i++) {
            Product product = new Product();
            // Set random values for each property
            // Example:
            product.setName("Product " + (i + 1));
            product.setPrice(Math.random() * 100);
            // Add more random data for other properties

            productList.add(product);
        }
        // Notify the adapter that the data set has changed
        productAdapter.notifyDataSetChanged();
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