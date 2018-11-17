package com.example.kvssaivarun.firebaset1;

import android.content.Intent;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText name,skill,phonenumber;
    Button save,search;
    DatabaseReference databaseworker;
    List<Worker> workerlist;
    ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        name=findViewById( R.id.name_et );
        skill=findViewById( R.id.skill_et );
        phonenumber=findViewById( R.id.phnumber_et );
        save=findViewById( R.id.save_bt );
        search=findViewById( R.id.search );
        workerlist= new ArrayList<>(  );

    int images[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,};


    viewFlipper=findViewById( R.id.v_flipper );

    for (int image: images){
        flipperImages( image );
        }


        databaseworker= FirebaseDatabase.getInstance().getReference("Worker");

        save.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
addworker();
            }
        } );

        }


    public void flipperImages(int image){
        ImageView imageView=new ImageView( this );
        imageView.setBackgroundResource( image );
        viewFlipper.addView( imageView );
        viewFlipper.setFlipInterval( 2000 );
        viewFlipper.setAutoStart( true );

        viewFlipper.setInAnimation( this,android.R.anim.slide_in_left );
        viewFlipper.setOutAnimation( this,android.R.anim.slide_out_right );


    }


    @Override
    protected void onStart() {
        super.onStart();
        databaseworker.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                workerlist.clear();

                for (DataSnapshot workersnapshot : dataSnapshot.getChildren() ){
                    Worker worker =workersnapshot.getValue(Worker.class);
                    workerlist.add( worker );

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        } );
    }

    private void addworker(){
        String W_name=name.getText().toString().trim();
        String W_skill=skill.getText().toString();
        String W_phone=phonenumber.getText().toString().trim();

        if (!TextUtils.isEmpty( W_name )){
          String id=  databaseworker.push().getKey();

          Worker worker= new Worker(id,W_name,W_skill,W_phone);

          databaseworker.child( id ).setValue( worker );

            Toast.makeText( this, "data saved", Toast.LENGTH_SHORT ).show();

        }
        else {
            Toast.makeText( this, "Enter name ", Toast.LENGTH_SHORT ).show();
        }


        if (TextUtils.isEmpty( W_skill )) {
            Toast.makeText( this, "Enter Skill", Toast.LENGTH_SHORT ).show();
        }


        if (TextUtils.isEmpty( W_phone )) {
            Toast.makeText( this, "Enter Phone Number", Toast.LENGTH_SHORT ).show();
        }

        }

        public void search(View view) {
        Intent intent= new Intent( MainActivity.this,Main2Activity.class );
        intent.putExtra( "workerlist",(Serializable)workerlist );
        startActivity( intent );
    }
}
