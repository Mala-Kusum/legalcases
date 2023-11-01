package com.example.legalcases;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class tAdapter extends RecyclerView.Adapter<tAdapter.MyViewHolder> {
    Context context;
    ArrayList<String> l;

    public tAdapter(Context context, ArrayList<String> l) {
        this.context = context;
        this.l = l;
    }

    public void filterList(ArrayList<String> filterlist) {
        l = filterlist;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public tAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(context).inflate(R.layout.tagcard,parent,false);
        tAdapter.MyViewHolder viewHolder = new tAdapter.MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull tAdapter.MyViewHolder holder, int position) {
        holder.tag.setText(l.get(position));
    }

    @Override
    public int getItemCount() {
        return l.size();
    }
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tag;
        ImageView deleteTag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tag=itemView.findViewById(R.id.tag);
            deleteTag=itemView.findViewById(R.id.deleteTag);
        }
    }
}
