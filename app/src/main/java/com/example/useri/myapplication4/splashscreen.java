package com.example.useri.myapplication4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Window;

public class splashscreen extends Activity {

    // Set Duration of the Splash Screen
    long Delay = 4000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Remove the Title Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Get the view from splash_screen.xml
        setContentView(R.layout.activity_splashscreen);

        // Create a Timer
        Timer RunSplash = new Timer();

        // Task to do when the timer ends
        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run() {
                // Close SplashScreenActivity.class
                finish();

                // Start MainActivity.class
                Intent myIntent = new Intent(splashscreen.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        };

        // Start the timer
        RunSplash.schedule(ShowSplash, Delay);
    }
}
