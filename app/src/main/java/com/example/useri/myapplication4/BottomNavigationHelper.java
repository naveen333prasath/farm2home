package com.example.useri.myapplication4;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import com.example.useri.myapplication4.R;
import com.example.useri.myapplication4.home;
import com.example.useri.myapplication4.profile;
import com.example.useri.myapplication4.marketplaceactivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by USERi on 03-01-2018.
 */

public class BottomNavigationHelper {

    public static void setupBottonNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        Intent i = new Intent(context, profile.class);
                        context.startActivity(i);
                        break;
                    case R.id.navigation_home:
                        Intent j = new Intent(context, home.class);
                        context.startActivity(j);
                        break;
                    case R.id.marketplace:
                        Intent k = new Intent(context, marketplaceactivity.class);
                        context.startActivity(k);
                        break;
                }
                return false;

            }
        });

    }

}



