package com.example.legalcases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class basicsearch extends AppCompatActivity {
    ArrayAdapter<CharSequence> ad;
    Spinner filterType;
    FloatingActionButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basicsearch);
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
    }
}