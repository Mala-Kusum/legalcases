package com.example.legalcases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class basicsearch extends AppCompatActivity {
    ArrayAdapter<CharSequence> ad;
    Spinner filterType;
    tAdapter adapt;
    FloatingActionButton add;
    ArrayList<String> list,filtered;
    RecyclerView tagList;
    ActionBar bar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView nav;
    SearchView s;
    List<Tag> lt;
    static final int i1=R.id.item1;
    static final int i2=R.id.item2;
    static final int i3=R.id.item3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicsearch);

        //Navigation Drawer
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //initialising variables
        nav = findViewById(R.id.nav);
        s=findViewById(R.id.search);
        filterType = findViewById(R.id.filtertype);
        add=findViewById(R.id.add);
        tagList = findViewById(R.id.taglist);
        list = new ArrayList<>();
        adapt=new tAdapter(this,list);
        lt = new ArrayList<>();
        int id = s.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        EditText sedit = (EditText) s.findViewById(id);

        //s.setEnabled(false);
        //s.setInputType(0);
        sedit.setEnabled(false);



        list.add("wgegerg");
        list.add("case no.");
        list.add("breif history");
        list.add("case filing date");

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(basicsearch.this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.FLEX_END);


        tagList.setHasFixedSize(true);
        tagList.setLayoutManager(layoutManager);
        tagList.setAdapter(adapt);

        filterType = findViewById(R.id.filtertype);
        ad=ArrayAdapter.createFromResource(basicsearch.this,R.array.filter, android.R.layout.simple_spinner_item);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_item);
        filterType.setAdapter(ad);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(basicsearch.this,editcase.class);
                startActivity(i);
            }
        });
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.item1){
                    Toast.makeText(basicsearch.this, "item 1", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        /*filterType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0){
                    //s.setEnabled(true);
                    s.setSubmitButtonEnabled(true);
                }
                else{
                    //s.setEnabled(false);
                    //s.setInputType(0);
                    s.setSubmitButtonEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //s.setEnabled(false);
                //s.setInputType(0);
                s.setSubmitButtonEnabled(false);
            }
        });*/
        filterType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(filterType.getSelectedItem().toString().equals("SELECTED")){
                    sedit.setEnabled(false);
                    sedit.setError("Select a filter type in the drop down first");
                }
                else{
                    sedit.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                sedit.setEnabled(false);
                sedit.setError("Select a filter type in the drop down first");
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(filterType.getSelectedItem().toString().equals("SELECTED")){
                    sedit.setEnabled(false);
                    sedit.setError("Select a filter type in the drop down first");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.kebabmenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}