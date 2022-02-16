package com.example.tproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
Button add,anButton;
EditText name, author, year, annotation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        add = findViewById(R.id.add_button);
        name = findViewById(R.id.add_name);
        author = findViewById(R.id.add_author);
        year = findViewById(R.id.add_year);
        annotation = findViewById(R.id.add_annotation);
        anButton = findViewById(R.id.annotation_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backAddIntent = new Intent(AddActivity.this, MainActivity.class);
                String sendN = name.getText().toString();
                String sendA = author.getText().toString();
                int sendY = Integer.parseInt(year.getText().toString());

                backAddIntent.putExtra(MainActivity.KEY_N,sendN);
                backAddIntent.putExtra(MainActivity.KEY_A,sendA);
                backAddIntent.putExtra(MainActivity.KEY_Y,sendY);
            }
        });


    }
}