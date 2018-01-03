package com.example.useri.myapplication4;

/**
 * Created by USERi on 03-01-2018.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.squareup.picasso.Picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class marketplaceactivity extends AppCompatActivity {
    private RecyclerView story;
    private DatabaseReference database;
    private static final int Activity_NUM=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retirive);
        setupBottomNavigationView();
        database= FirebaseDatabase.getInstance().getReference().child("Posts");
        story=(RecyclerView)findViewById(R.id.recycle);
        story.setHasFixedSize(true);
        story.setLayoutManager(new LinearLayoutManager(this));

    }
    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx= (BottomNavigationViewEx) findViewById(R.id.navigation);
        BottomNavigationHelper.setupBottonNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(marketplaceactivity.this,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(Activity_NUM);
        menuItem.setChecked(true);
    }

    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<blog,BlogViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<blog,BlogViewHolder>(

                blog.class,
                R.layout.story_activity,
                BlogViewHolder.class,
                database

        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, blog model, int position) {

                viewHolder.setItem(model.getItem());
                viewHolder.setprice(model.getPrice());
                viewHolder.setImage(getApplicationContext(),model.getImage());
            }
        };
        story.setAdapter(firebaseRecyclerAdapter);
    }
    public static class BlogViewHolder extends RecyclerView.ViewHolder{
        View nView;
        public BlogViewHolder(View itemView) {
            super(itemView);
            nView=itemView;

        }
        public void setItem(String item){
            TextView post_item=(TextView)nView.findViewById(R.id.storyitem);
            post_item.setText(item);
        }
        public void setprice(String price){
            TextView post_price=(TextView)nView.findViewById(R.id.storyprice);
            post_price.setText(price);
        }
        public void setImage(Context ctx, String image){
            ImageView post_image=(ImageView)nView.findViewById(R.id.storyimg);
            Picasso.with(ctx).load(image).into(post_image);
        }
    }
}
