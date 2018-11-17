package com.example.kvssaivarun.firebaset1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    List<Worker> workerlist;
    Context context;

    public Myadapter(Main2Activity main2Activity, List<Worker> workerlist) {
        this.workerlist = workerlist;
        this.context = main2Activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from( context ).inflate( R.layout.row, viewGroup, false );

        return new ViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return workerlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            textView = itemView.findViewById( R.id.textView );


            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < workerlist.size(); i++) {
                String name = workerlist.get( i ).getName();
                String skill = workerlist.get( i ).getSkill();
                String phone = workerlist.get( i ).getPhone();

                stringBuilder.append( "name :" + name + "\t\t\t\t\t" + "skill :" + skill + "\n" + "phone :" + phone + "\n\n" );
                textView.setText( stringBuilder );
            }
        }
    }
}
