package com.example.kvssaivarun.firebaset1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


  +public class WelcomeActivity extends AppCompatActivity{
    private static  int SPlASH_TIME_OUT = 4000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_welcome );
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent welcomeintent= new Intent( WelcomeActivity.this,MainActivity.class );
                startActivity( welcomeintent );
            }
        },SPlASH_TIME_OUT );


    }
}

   
