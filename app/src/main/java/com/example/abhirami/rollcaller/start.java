package com.example.abhirami.rollcaller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;





public class start extends AppCompatActivity {
    public String username = "";
    private FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start11);


        }
    public void userlogin(View view)
    {


        EditText textuser=(EditText)findViewById(R.id.ETstart);
        username=textuser.getText().toString();
        DatabaseReference myRef = database.getReference().child("StudentDetails");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                processData(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        Log.d("databasethingvalue",value);
//        if(value.equals("Nr"))
//        {
//            Toast.makeText(start.this, "Username not found", Toast.LENGTH_SHORT).show();
//            finishActivity(0);
//        }
//        else {
//            Intent j = new Intent(start.this, option.class);
//            j.putExtra("userid", username);
//            startActivity(j);
//        }




    }

    public void processData(DataSnapshot dataSnapshot)
    {


        if(dataSnapshot.child(username).exists())
        {
            Intent j = new Intent(start.this, option.class);
            j.putExtra("userid", username);
            j.putExtra("voiceID",dataSnapshot.child(username).child("voiceID").getValue().toString());
            startActivity(j);
            finish();

        }
        else
        {
            Toast.makeText(start.this, "Username not found", Toast.LENGTH_SHORT).show();
            finish();
        }


    }


}


