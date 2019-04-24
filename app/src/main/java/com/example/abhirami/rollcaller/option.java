package com.example.abhirami.rollcaller;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class option extends AppCompatActivity {

   @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.option);



    }

    public void rollcall(View view){
        Intent i=new Intent(option.this,give.class);
        i.putExtra("userid",getIntent().getExtras().getString("userid"));
        i.putExtra("voiceID",getIntent().getExtras().getString("voiceID"));
        startActivity(i);
        finish();
    }
    public void home(View view){

       String username=getIntent().getExtras().getString("userid");

       writehometodb(username);
      setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();

            }
        }, 3000);

    }
    public void writehometodb(String username)
    {
        DatabaseReference myRef=FirebaseDatabase.getInstance().getReference();
        myRef.child("RollList").child(username).setValue("HOME");


    }

}