package com.example.abhirami.rollcaller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.voiceit.voiceit2.VoiceItAPI2;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class give extends MainActivity {

    String value="";
    TextView location;
    JSONArray loc;
    private VoiceItAPI2 myVoiceIt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);

        FirebaseDatabase fbr=FirebaseDatabase.getInstance();
        DatabaseReference dbr=fbr.getReference().child("User");

        dbr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value = dataSnapshot.getValue(String.class);
                Log.v("Fiind", "Value is: " + value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.v("Fiind", "Failed to read value.", error.toException());
            }
        });

        TextView mtextuser=findViewById(R.id.ETstart);
        mtextuser.setText(" userid "+value);
    }


    public void startvoiceit(View view)
    {
        if(username.isEmpty())
        {
            Toast.makeText(give.this,"No username",Toast.LENGTH_LONG);
            return;

        }



        myVoiceIt = new VoiceItAPI2("key_a6523fd2aace403c8b9c2089dd04c59c","tok_906ed07bb59b4422b3748df43733c025");



        myVoiceIt.encapsulatedVoiceEnrollment(give.this, value, "en-US", "Never forget tomorrow is a new day", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(give.this,response.toString(),
                        Toast.LENGTH_LONG).show();
                //System.out.println("JSONResult : " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    Log.v("JSONResult : ", errorResponse.toString());
                }
            }
        });


    }

    public void verifyvoiceit(View view)
    {
        myVoiceIt = new VoiceItAPI2("key_a6523fd2aace403c8b9c2089dd04c59c","tok_906ed07bb59b4422b3748df43733c025");

        myVoiceIt.encapsulatedVoiceVerification(give.this, value, "en-US", "Never forget tomorrow is a new day", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(give.this,response.toString(),
                        Toast.LENGTH_LONG).show();
                //System.out.println("JSONResult : " + response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    Log.v("JSONResult : ", errorResponse.toString());
                }
            }
        });
    }


}
