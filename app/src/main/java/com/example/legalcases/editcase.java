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
    EditText ed3;
    LinearLayout nh;
    public static Date dn;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcase);
        this.getSupportActionBar().hide();
        ed3 = findViewById(R.id.nexthearingdate);
        nh = findViewById(R.id.nh);

        /*ed3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                DialogFragment newFragment = new DatePick(ed3);
                newFragment.show(getSupportFragmentManager(), "datePicker");
                return false;
            }
        });*/
        ed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePick(ed3);
                newFragment.show(getSupportFragmentManager(), "datePicker");
            }
        });
    }
}