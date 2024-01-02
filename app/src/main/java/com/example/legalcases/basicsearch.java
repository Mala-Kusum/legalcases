package com.example.legalcases;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.cardview.widget.CardView;
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
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    ArrayAdapter<CharSequence> ad,ad2;
    Spinner filterType,spinner;
    tAdapter adapt;
    FloatingActionButton add;
    ArrayList<String> filtered;
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
    CardView card;
    Boolean f=false;
    LinearLayout layout;
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
        card = findViewById(R.id.card);
        layout = findViewById(R.id.layout);
        filterType = findViewById(R.id.filtertype);
        add=findViewById(R.id.add);
        tagList = findViewById(R.id.taglist);
        lt = new ArrayList<>();
        adapt=new tAdapter(this, (ArrayList<Tag>) lt);
        filterType = findViewById(R.id.filtertype);
        spinner = (Spinner) nav.getMenu().findItem(R.id.item1).getActionView();
        ad=ArrayAdapter.createFromResource(basicsearch.this,R.array.filter, android.R.layout.simple_spinner_item);
        ad2 = ArrayAdapter.createFromResource(basicsearch.this,R.array.RO,android.R.layout.simple_spinner_dropdown_item);
       /* int id = s.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        EditText sedit = (EditText) s.findViewById(id);*/

        s.setSubmitButtonEnabled(false);
        //FLEXIVLE LAYOUT FOR FILTER TAGS
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(basicsearch.this);
        layoutManager.setFlexDirection(FlexDirection.ROW);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.FLEX_END);

        tagList.setHasFixedSize(true);
        tagList.setLayoutManager(layoutManager);
        tagList.setAdapter(adapt);

        //SET FILTER TYPE SPINNER
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
                if(item.getItemId()==R.id.logout){
                    Intent i = new Intent(basicsearch.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
                return false;
            }
        });
        filterType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(filterType.getSelectedItem().toString().equals("SELECTED")){
                    /*sedit.setEnabled(false);
                    sedit.setError("Select a filter type in the drop down first");*/
                    s.setSubmitButtonEnabled(false);
                }
                else{
                    //sedit.setEnabled(true);
                    s.setSubmitButtonEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                /*sedit.setEnabled(false);
                sedit.setError("Select a filter type in the drop down first");*/
                s.setSubmitButtonEnabled(false);
            }
        });
        //EXPAND AND CONTRACT CASE CARD
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(f){
                    ViewGroup.LayoutParams params = layout.getLayoutParams();
// Changes the height and width to the specified *pixels*
                    params.height = 350;
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    layout.setLayoutParams(params);
                    f=false;
                }
                else{
                    ViewGroup.LayoutParams params = layout.getLayoutParams();
                    // Changes the height and width to the specified *pixels*
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    layout.setLayoutParams(params);
                    f=true;
                }
            }
        });
        //SEARCHVIEW
        s.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Tag t = new Tag(filterType.getSelectedItem().toString(),query);
                lt.add(t);
                adapt.notifyDataSetChanged();

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        //spinner.setAdapter(new ArrayAdapter<>());
        /*spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(basicsearch.this,spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/
        /*s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(filterType.getSelectedItem().toString().equals("SELECTED")){
                    sedit.setEnabled(false);
                    sedit.setError("Select a filter type in the drop down first");
                }
            }
        });*/
    }
    //NAVIGATION DRAWER OPEN ON CLICK
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}