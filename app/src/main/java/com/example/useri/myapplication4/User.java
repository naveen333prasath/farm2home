package com.example.useri.myapplication4;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Ravi Tamada on 07/10/16.
 * www.androidhive.info
 */

@IgnoreExtraProperties
public class User {

    public String name;
    public String dp;
    public String location;
    public String crops;
    public String mnum;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }



    public User(String name, String location,String crops,String mnum,String dp) {
        this.name = name;
        this.location=location;
        this.crops=crops;
        this.mnum=mnum;
        this.dp=dp;



    }
}