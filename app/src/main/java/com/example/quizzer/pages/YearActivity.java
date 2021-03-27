package com.example.quizzer.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quizzer.R;

public class YearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Select Year");

        findViewById(R.id.teYearBut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YearActivity.this, QuestionActivityTE.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.beYearButt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YearActivity.this, QuestionActivityBE.class);
                startActivity(intent);
            }
        });
    }
}