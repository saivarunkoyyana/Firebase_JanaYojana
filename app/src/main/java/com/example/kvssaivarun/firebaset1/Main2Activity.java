package com.example.kvssaivarun.firebaset1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
RecyclerView recyclerView;
List<Worker> workerlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        recyclerView=findViewById( R.id.recyclerview );
        workerlist=new ArrayList<>(  );
workerlist=(List<Worker>)getIntent().getSerializableExtra("workerlist");

       Myadapter myadapter= new Myadapter(this,workerlist);
       recyclerView.setLayoutManager( new GridLayoutManager( this,2 ) );
       recyclerView.setAdapter( myadapter );



    }
}
