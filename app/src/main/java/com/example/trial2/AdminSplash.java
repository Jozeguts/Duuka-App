package com.example.trial2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;



public class AdminSplash extends AppCompatActivity {

    // Splash screen duration in milliseconds
    private static final long SPLASH_DURATION = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_splash);

        // Delay for SPLASH_DURATION milliseconds, then start the main activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent mainIntent = new Intent(AdminSplash.this, AdminLogin.class);
                startActivity(mainIntent);

                // Finish the current activity
                finish();
            }
        }, SPLASH_DURATION);
    }
}
