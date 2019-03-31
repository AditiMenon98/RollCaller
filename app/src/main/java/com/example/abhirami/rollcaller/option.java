package com.example.abhirami.rollcaller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class option extends MainActivity {
   @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.option);
    }

    public void rollcall(View view){
        Intent i=new Intent(option.this,roll.class);
        startActivity(i);
    }
    public void home(View view){
       Intent j= new Intent(option.this,home.class);
       startActivity(j);
    }
}