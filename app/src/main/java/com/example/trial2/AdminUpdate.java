package com.example.trial2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdminUpdate extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_update_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize Product List
        productList = new ArrayList<>();

        // Adding 10 dummy products
        for (int i = 1; i <= 10; i++) {
            productList.add(new Product("Product " + i, "Description " + i, 100 * i));
        }

        // Initialize Adapter
        productAdapter = new ProductAdapter(productList);

        // Set Adapter to RecyclerView
        recyclerView.setAdapter(productAdapter);
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

    // ProductAdapter class
    private class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

        private List<Product> productList;

        public ProductAdapter(List<Product> productList) {
            this.productList = productList;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.admin_update_product_card, parent, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            Product product = productList.get(position);
            holder.productName.setText(product.getName());
            holder.productDescription.setText(product.getDescription());
            holder.productPrice.setText(String.valueOf(product.getPrice()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle item click, pass data to admin_update_item.xml
                    // Start AdminUpdateItemActivity with product details
                    Intent intent = new Intent(AdminUpdate.this, AdminUpdateItemActivity.class);
                    intent.putExtra("productName", product.getName());
                    intent.putExtra("productDescription", product.getDescription());
                    intent.putExtra("productPrice", product.getPrice());
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

        // ProductViewHolder class
        public class ProductViewHolder extends RecyclerView.ViewHolder {

            TextView productName, productDescription, productPrice;

            public ProductViewHolder(@NonNull View itemView) {
                super(itemView);
                productName = itemView.findViewById(R.id.productName);
                productDescription = itemView.findViewById(R.id.productDescription);
                productPrice = itemView.findViewById(R.id.productPrice);
            }
        }
    }

    // Product class
    private class Product {
        private String name;
        private String description;
        private double price;

        public Product(String name, String description, double price) {
            this.name = name;
            this.description = description;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }
    }
}
