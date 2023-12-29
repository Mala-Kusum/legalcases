package com.example.legalcases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Date;

public class editcase extends AppCompatActivity {
    EditText ed3,ed4,ed16;
    LinearLayout nh;
    public static Date dn;
    ArrayAdapter<String> ad1,ad2,ad3;
    AutoCompleteTextView a1,a2,a3;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcase);
        this.getSupportActionBar().hide();

        ed3 = findViewById(R.id.nexthearingdate);
        ed4 = findViewById(R.id.lasthearingdate);
        ed16 = findViewById(R.id.casefilingdate);
        nh = findViewById(R.id.nh);
        a1 = (AutoCompleteTextView) findViewById(R.id.statushead);
        a2 = (AutoCompleteTextView) findViewById(R.id.hqro);
        a3 = (AutoCompleteTextView) findViewById(R.id.state);
        String[] s1 = {"Closed- Won","Closed- Lost","Ongoing","Settled","Disposed","Dismissed","Sine Dine"};
        String[] s2 = {"HQ","RO"};

        //defining all the autocompletextview
        ad1 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, s1);
        a1.setThreshold(1);
        a1.setAdapter(ad1);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.showDropDown();
            }
        });

        ad2 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, s2);
        a1.setThreshold(1);
        a1.setAdapter(ad2);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a2.showDropDown();
            }
        });
        ad2 = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, R.array.States);

        a3.setThreshold(1);
        a3.setAdapter(ad3);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a3.showDropDown();
            }
        });
        ed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePick(ed3);
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });
        ed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePick(ed4);
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });
        ed16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePick(ed16);
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });
    }
}