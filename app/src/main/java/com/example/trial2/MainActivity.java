package com.example.trial2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView gotoAdmin, gotoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoAdmin = findViewById(R.id.gotoAdmin);
        gotoUser = findViewById(R.id.gotoUser);

        gotoAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent to navigate to another activity
                Intent intent = new Intent(MainActivity.this, AdminSplash.class);

                // Start the new activity
                startActivity(intent);
            }
        });

        gotoUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new Intent to navigate to another activity
                Intent intent = new Intent(MainActivity.this, UserSplash.class);

                // Start the new activity
                startActivity(intent);
            }
        });

    }
}