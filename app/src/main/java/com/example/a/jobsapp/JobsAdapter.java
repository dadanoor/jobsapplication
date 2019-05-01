package com.example.a.jobsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.MyViewHolder> {
    ArrayList<JobsModel> mylist;
    Context context;
    public JobsAdapter(JobsActivity jobsActivity,ArrayList<JobsModel>list) {
        context=jobsActivity;
        mylist=list;
    }

    @NonNull
    @Override

    public JobsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.list_row,parent,false);
        MyViewHolder holder=new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull JobsAdapter.MyViewHolder holder, int position) {
        JobsModel model=mylist.get(position);
        holder.tittle.setText(model.getTitle());
        holder.loc.setText(model.getLocation());
        holder.hta.setText(model.getHow_to_apply());

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tittle,loc,hta;
        public MyViewHolder(View itemView) {
            super(itemView);
            tittle=itemView.findViewById(R.id.text1);
            loc=itemView.findViewById(R.id.text2);
            hta=itemView.findViewById(R.id.text3);
        }
    }
}
