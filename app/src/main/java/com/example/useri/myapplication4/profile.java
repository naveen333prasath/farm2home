package com.example.useri.myapplication4;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class profile extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    ProgressDialog progressDialog;
    private static final int Activity_NUM=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
            setupBottomNavigationView();
        Button btn = (Button) findViewById(R.id.check);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                progressDialog = new ProgressDialog(profile.this,R.style.AppCompatAlertDialogStyle);
                progressDialog.setMessage("Logged Out..."); // Setting Message
                progressDialog.setTitle(""); // Setting Title
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); // Progress Dialog Style Spinner
                progressDialog.show(); // Display Progress Dialog
                progressDialog.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(10000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user == null) {

                    // user auth state is changed - user is null
                    // launch login activity
                    progressDialog.dismiss();
                    Intent intent = new Intent(profile.this, splashscreen.class);
                    startActivity(intent);
                }

//                Intent intent = new Intent(getActivity().getApplication(), MainActivity.class);
//                startActivity(intent);
                else{
                    Toast.makeText(profile.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();

                }}

        });
    }
    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx= (BottomNavigationViewEx) findViewById(R.id.navigation);
        BottomNavigationHelper.setupBottonNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(profile.this,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(Activity_NUM);
        menuItem.setChecked(true);
    }}
