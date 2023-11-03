package com.example.legalcases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class basicsearch extends AppCompatActivity {
    ArrayAdapter<CharSequence> ad;
    Spinner filterType;
    tAdapter adapt;
    FloatingActionButton add;
    ArrayList<String> list,filtered;
    RecyclerView tagList;
    ActionBar bar;
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

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(basicsearch.this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        /*layoutManager.setAlignItems(AlignItems.FLEX_START);
        layoutManager.setJustifyContent(JustifyContent.FLEX_START);*/
        layoutManager.setJustifyContent(JustifyContent.FLEX_END);

        tagList = findViewById(R.id.taglist);
        tagList.setHasFixedSize(true);
        tagList.setLayoutManager(layoutManager);
        tagList.setAdapter(adapt);

        filterType = findViewById(R.id.filtertype);
        ad=ArrayAdapter.createFromResource(basicsearch.this,R.array.filter, android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_item);
        filterType.setAdapter(ad);

        add=findViewById(R.id.add);

        /*bar=getSupportActionBar();

        try{
            bar.setBackgroundDrawable(new ColorDrawable(1));
        }
        catch(Exception e){
            Log.e("Exception", e.toString());
        }*/


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
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.kebabmenu, menu);

        return true;
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