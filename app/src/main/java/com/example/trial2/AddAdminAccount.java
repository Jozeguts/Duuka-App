package com.example.trial2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddAdminAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_admin_account);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Find the TextView for confirming add account
        TextView confirmAddTextView = findViewById(R.id.confirm_add);
        confirmAddTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get email, password, and confirm password from EditTexts
                EditText emailEditText = findViewById(R.id.email_edit_text);
                EditText passwordEditText = findViewById(R.id.password_edit_text);
                EditText confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text);

                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                // Check if passwords match
                if (!password.equals(confirmPassword)) {
                    // Show toast indicating passwords do not match
                    Toast.makeText(AddAdminAccount.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // If passwords match, proceed with adding account
                // Add your logic here for adding the admin account

                // Show toast indicating successful addition
                Toast.makeText(AddAdminAccount.this, "Admin account added successfully", Toast.LENGTH_LONG).show();

                // Clear input fields
                emailEditText.setText("");
                passwordEditText.setText("");
                confirmPasswordEditText.setText("");
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
