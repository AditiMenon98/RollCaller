package com.example.abhirami.rollcaller;


import android.content.Intent;
import android.os.Handler;
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

import static android.net.sip.SipErrorCode.TIME_OUT;


public class MainActivity extends AppCompatActivity {
    private static int TIME_OUT = 3000;

    String username="";
    String value="";
    TextView location;
    JSONArray loc;
    private VoiceItAPI2 myVoiceIt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome11);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, start.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);

    }

    /*public void usernamesubmit(View view)
    {


        EditText textuser=(EditText)findViewById(R.id.username);
        username=textuser.getText().toString();
        Intent autenteintent=new Intent(MainActivity.this,Authente.class);
        autenteintent.putExtra("userid",username);
        startActivity(autenteintent);





    }

*/
}