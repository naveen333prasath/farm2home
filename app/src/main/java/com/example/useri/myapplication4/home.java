package com.example.useri.myapplication4;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


public class home extends AppCompatActivity {
    private ImageButton image;
    private EditText name;
    private EditText price;
    private Button submit;
    private Uri image1=null;
    private StorageReference storage;
    private static final int GALLERY_REQUEST=1;
    private DatabaseReference database;
    private static final int Activity_NUM=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        image=(ImageButton)findViewById(R.id.img);
        name=(EditText)findViewById(R.id.item);
        price=(EditText)findViewById(R.id.price);
        submit=(Button)findViewById(R.id.post);
        setupBottomNavigationView();



        storage= FirebaseStorage.getInstance().getReference();
        database= FirebaseDatabase.getInstance().getReference().child("Posts");

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gallery=new Intent(Intent.ACTION_GET_CONTENT);
                gallery.setType("image/*");
                startActivityForResult(gallery,GALLERY_REQUEST);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startPosting();

            }
        });}
    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx= (BottomNavigationViewEx) findViewById(R.id.navigation);
        BottomNavigationHelper.setupBottonNavigationView(bottomNavigationViewEx);
        BottomNavigationHelper.enableNavigation(home.this,bottomNavigationViewEx);
        Menu menu=bottomNavigationViewEx.getMenu();
        MenuItem menuItem=menu.getItem(Activity_NUM);
        menuItem.setChecked(true);
    }
        private void startPosting() {

            final String item=name.getText().toString().trim();
            final String cost=price.getText().toString().trim();

            if(!TextUtils.isEmpty(item) && !TextUtils.isEmpty(cost) && image1!=null) {
                Toast.makeText(home.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                StorageReference filepath=storage.child("Posts").child(image1.getLastPathSegment());


                filepath.putFile(image1).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Uri downloadurl=taskSnapshot.getDownloadUrl();
                        DatabaseReference post=database.push();
                        post.child("item").setValue(item);
                        post.child("price").setValue(cost);
                        post.child("image").setValue(downloadurl.toString());


                    }
                });
            }
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == GALLERY_REQUEST && resultCode == Activity.RESULT_OK);
            image1=data.getData();
            image.setImageURI(image1);
        }

    }

