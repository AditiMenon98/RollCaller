package com.example.abhirami.rollcaller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.loopj.android.http.JsonHttpResponseHandler;
import cz.msebera.android.httpclient.Header;

import org.json.JSONArray;
import org.json.JSONObject;
import com.voiceit.voiceit2.VoiceItAPI2;

import java.util.Timer;
import java.util.TimerTask;


public class start extends AppCompatActivity {
    public String username = "";
    public String value = "";
    TextView location;
    JSONArray loc;
    private VoiceItAPI2 myVoiceIt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start11);


        }
    public void userlogin(View view)
    {


        EditText textuser=(EditText)findViewById(R.id.ETstart);
        username=textuser.getText().toString();
        Intent j=new Intent(start.this,option.class);
        j.putExtra("userid",username);
        startActivity(j);





    }


}


