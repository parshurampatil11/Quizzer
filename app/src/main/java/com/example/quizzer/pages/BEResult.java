package com.example.quizzer.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.quizzer.R;

public class BEResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_e_result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BE Result");

        TextView totalText = findViewById(R.id.totalBE);
        TextView correctText = findViewById(R.id.correctBE);
        TextView wrongText = findViewById(R.id.wrongBE);

        String total = "Total Marks: "+getIntent().getStringExtra("marks");
        String correct = "Correct Ans: "+getIntent().getStringExtra("marks");
        String wrong = "Wrong Ans: "+getIntent().getStringExtra("wrong");

        totalText.setText(total);
        correctText.setText(correct);
        wrongText.setText(wrong);
    }
}