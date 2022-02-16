package com.example.tproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;



public class AnnotationActivity extends AppCompatActivity {
TextView annotation;
static String KEY_STRING;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        annotation = findViewById(R.id.annot);
        annotation.setText(getIntent().getStringExtra(KEY_STRING));


    }
}