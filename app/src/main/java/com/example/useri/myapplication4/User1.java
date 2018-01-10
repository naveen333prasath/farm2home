package com.example.useri.myapplication4;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Ravi Tamada on 07/10/16.
 * www.androidhive.info
 */

@IgnoreExtraProperties
public class User1 {

    public String name;

    public String Quantity;
    public String crops;
    public String mnum;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User1() {
    }



    public User1(String name, String Quantity,String crops,String mnum) {
        this.name = name;
        this.Quantity=Quantity;
        this.crops=crops;
        this.mnum=mnum;


    }
}