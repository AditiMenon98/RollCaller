package com.example.abhirami.rollcaller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.voiceit.voiceit2.VoiceItAPI2;

import org.json.JSONArray;

public class roll extends MainActivity {
    String username="";
    String value="";
    TextView location;
    JSONArray loc;
    private VoiceItAPI2 myVoiceIt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enroll);
        Intent created=getIntent();
        username=created.getStringExtra("ETstart");
    }
    public void enroll(View view){
        Intent i=new Intent(roll.this,give.class);
        startActivity(i);
    }

}
