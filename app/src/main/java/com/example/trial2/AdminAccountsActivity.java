package com.example.trial2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class AdminAccountsActivity extends AppCompatActivity {

    private ListView adminListView;
    private ArrayAdapter<String> adapter;
    private List<String> adminAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_accounts);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Initialize views
        adminListView = findViewById(R.id.admin_accounts_list);

        // Initialize admin accounts list
        adminAccounts = new ArrayList<>();
        adminAccounts.add("Admin Account 1");
        adminAccounts.add("Admin Account 2");
        adminAccounts.add("Admin Account 3");
        adminAccounts.add("Admin Account 4");
        adminAccounts.add("Admin Account 5");
        adminAccounts.add("Admin Account 6");
        adminAccounts.add("Admin Account 7");
        adminAccounts.add("Admin Account 8");
        adminAccounts.add("Admin Account 9");

        // Set up adapter for ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, adminAccounts);
        adminListView.setAdapter(adapter);

        // Set item click listener
        adminListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click
                String selectedAccount = adminAccounts.get(position);
                // Show option to delete account
                showDeleteConfirmation(selectedAccount, position);
            }
        });
    }

    // Method to show delete confirmation dialog
    private void showDeleteConfirmation(final String account, final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Delete " + account + "?")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Delete the item from the list
                        adminAccounts.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(AdminAccountsActivity.this, "Deleted " + account, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and show it
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
