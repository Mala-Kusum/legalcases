package com.example.legalcases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.Date;

public class editcase extends AppCompatActivity {
    EditText ed3,ed4;
    LinearLayout nh;
    public static Date dn;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcase);
        this.getSupportActionBar().hide();
        ed3 = findViewById(R.id.nexthearingdate);
        ed4 = findViewById(R.id.lasthearingdate);
        nh = findViewById(R.id.nh);
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
    }
}