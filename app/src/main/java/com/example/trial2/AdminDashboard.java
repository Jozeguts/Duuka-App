package com.example.trial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminDashboard extends AppCompatActivity {

    private Button addProductButton;
    private Button removeProductButton;
    private Button viewProductButton;
    private Button updateButton;
    private Button addAdminButton;
    private Button removeAdminButton;
    private Button viewUsersButton;
    private Button removeUserButton;
    private Button gotoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_dashboard);

        // Enable back button in ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            Toast.makeText(this, "ActionBar is null", Toast.LENGTH_SHORT).show();
        }

        // Initialize buttons
        addProductButton = findViewById(R.id.add_product_button);
        removeProductButton = findViewById(R.id.remove_product_button);
        viewProductButton = findViewById(R.id.view_product_button);
        updateButton = findViewById(R.id.update_button);
        addAdminButton = findViewById(R.id.add_admin_button);
        removeAdminButton = findViewById(R.id.remove_admin_button);
        viewUsersButton = findViewById(R.id.view_users_button);
        removeUserButton = findViewById(R.id.remove_user_button);
        gotoHome = findViewById(R.id.gotoHome);

        // Set click listeners for buttons
        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, AddNewProduct.class));
            }
        });

        removeProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminDashboard.this, DeleteProduct.class));

                // Handle click for removeProductButton
            }
        });

        viewProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for viewProductButton
                startActivity(new Intent(AdminDashboard.this, AdminViewItemMenu.class));

            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for updateButton
                startActivity(new Intent(AdminDashboard.this, AdminUpdateItemActivity.class));

            }
        });

        addAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for addAdminButton

                startActivity(new Intent(AdminDashboard.this, AddAdminAccount.class));


            }
        });

        removeAdminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for removeAdminButton
                startActivity(new Intent(AdminDashboard.this, AdminAccountsActivity.class));

            }
        });

        viewUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for viewUsersButton
                startActivity(new Intent(AdminDashboard.this, AdminViewUser.class));

            }
        });
        gotoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for viewUsersButton
                startActivity(new Intent(AdminDashboard.this, MainActivity.class));

            }
        });


        removeUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for removeUserButton
                startActivity(new Intent(AdminDashboard.this, AdminRemoveUser.class));


            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
