package com.example.useri.myapplication4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main7Activity extends AppCompatActivity {
ImageView pay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main7);
pay=(ImageView)findViewById(R.id.paytm);
pay.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(Main7Activity.this, payment.class));
        finish();
    }
});



}}
