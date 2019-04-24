package com.example.abhirami.rollcaller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.voiceit.voiceit2.VoiceItAPI2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class give extends AppCompatActivity {

    String username="";
    String voiceID="";
    JSONObject loc;

    private VoiceItAPI2 myVoiceIt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give);
        username=getIntent().getExtras().getString("userid");
        voiceID=getIntent().getExtras().getString("voiceID");

        verifyvoiceit();
//        FirebaseDatabase fbr=FirebaseDatabase.getInstance();
//        DatabaseReference dbr=fbr.getReference().child("StudentDetails").child(username);
//
//        dbr.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                value = dataSnapshot.getValue(String.class);
//                Log.v("Fiind", "Value is: " + value);
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.v("Fiind", "Failed to read value.", error.toException());
//            }
//        });
//
//        TextView mtextuser=findViewById(R.id.ETstart);
//        mtextuser.setText(" userid "+value);
    }


//    public void startvoiceit(View view)
//    {
//        if(username.isEmpty())
//        {
//            Toast.makeText(give.this,"No username",Toast.LENGTH_LONG);
//            return;
//
//        }
//
//
//
//        myVoiceIt = new VoiceItAPI2("key_a6523fd2aace403c8b9c2089dd04c59c","tok_906ed07bb59b4422b3748df43733c025");
//
//
//
//        myVoiceIt.encapsulatedVoiceEnrollment(give.this, voiceID, "en-US", "Never forget tomorrow is a new day", new JsonHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                Toast.makeText(give.this,response.toString(),
//                        Toast.LENGTH_LONG).show();
//                //System.out.println("JSONResult : " + response.toString());
//
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                if (errorResponse != null) {
//                    Log.v("JSONResult : ", errorResponse.toString());
//                }
//            }
//        });
//
//
//    }

    public void verifyvoiceit()
    {
        myVoiceIt = new VoiceItAPI2("key_a6523fd2aace403c8b9c2089dd04c59c","tok_906ed07bb59b4422b3748df43733c025");

        myVoiceIt.encapsulatedVoiceVerification(give.this, voiceID, "en-US", "Never forget tomorrow is a new day", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Toast.makeText(give.this,response.toString(),
                        Toast.LENGTH_LONG).show();
                getlocation();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                if (errorResponse != null) {
                    Log.v("JSONResult : ", errorResponse.toString());
                }
            }
        });


        
    }

    public void getlocation()
    {


        String uname=username.toLowerCase();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = null;
        url = "https://cloud.internalpositioning.com/api/v1/location/nov19/nandha";
//            url = "https://cloud.internalpositioning.com/ping";v

  //      location=findViewById(R.id.locationtext);
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
////                        mTextView.setText("Response is: "+ response.substring(0,4));
//
//                        location.setText("Response is: "+ response);
//
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                location.setText("That didn't work!"+error);
//            }
//        });
//
//        queue.add(stringRequest);



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response){
                        try {
                            String loc1=response.getJSONObject("analysis").getJSONArray("guesses").getJSONObject(0).getString("location");
                            Toast.makeText(give.this,loc1.toString(),Toast.LENGTH_LONG);
                            Log.d("locationthing",loc1.toString());
                            if(loc1.equals("114")){
                                DatabaseReference myRef=FirebaseDatabase.getInstance().getReference();
                                myRef.child("RollList").child(username).setValue("YES");
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error
                        Toast.makeText(give.this,"Errorin Json",Toast.LENGTH_LONG);

                    }
                });

// Access the RequestQueue through your singleton class.
       queue.add(jsonObjectRequest);

        //Assuming all goes well
//        DatabaseReference myRef=FirebaseDatabase.getInstance().getReference();
//        myRef.child("RollList").child(username).setValue("YES");
    }


}
