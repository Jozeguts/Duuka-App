package com.example.trial2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class AdminViewItemMenu extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_item_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        // Initialize RecyclerView and product list
        recyclerView = findViewById(R.id.recycler_view_item);
        productList = new ArrayList<>();

        // Populate product list (replace with your data)


        // Set up RecyclerView adapter
        AdminViewItemAdapter adapter = new AdminViewItemAdapter(productList, new AdminViewItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {
                // Open AdminViewItem activity with product details
                Intent intent = new Intent(AdminViewItemMenu.this, AdminViewItem.class);
                intent.putExtra("product", (CharSequence) product);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    // Method to initialize random products (replace with your implementation)





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

