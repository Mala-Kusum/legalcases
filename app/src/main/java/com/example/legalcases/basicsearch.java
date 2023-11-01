package com.example.legalcases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class basicsearch extends AppCompatActivity {
    ArrayAdapter<CharSequence> ad;
    Spinner filterType;
    tAdapter adapt;
    FloatingActionButton add;
    ArrayList<String> list,filtered;
    RecyclerView tagList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicsearch);

        list = new ArrayList<>();
        adapt=new tAdapter(this,list);

        list.add("wgegerg");
        list.add("case no.");
        list.add("breif history");
        list.add("case filing date");

        tagList = findViewById(R.id.taglist);
        tagList.setHasFixedSize(true);
        tagList.setLayoutManager(new LinearLayoutManager(this));
        tagList.setAdapter(adapt);

        filterType = findViewById(R.id.filtertype);
        ad=ArrayAdapter.createFromResource(basicsearch.this,R.array.filter, android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_item);
        filterType.setAdapter(ad);

        add=findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(basicsearch.this,editcase.class);
                startActivity(i);
            }
        });

        /*@Override
        public boolean onOptionsItemSelected(MenuItem ){
            int id = item.getItemId();
            if (id==android.R.id.home) {
                finish();
            }
            if(item.getItemId()==R.id.item1){
                Intent intent=new Intent(basicsearch.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
            return true;
        }*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        /*if (id==android.R.id.home) {
            finish();
        }*/
        if(item.getItemId()==R.id.item1){
            Intent intent=new Intent(basicsearch.this,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }
}