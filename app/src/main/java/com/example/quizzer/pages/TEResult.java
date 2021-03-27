package com.example.quizzer.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.quizzer.R;

public class TEResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_e_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TE Result");

        TextView markText = findViewById(R.id.totalTE);
        TextView correctText = findViewById(R.id.correctTE);
        TextView wrongText = findViewById(R.id.wrongTE);

        String total = "Total Marks: "+getIntent().getStringExtra("marks");
        String correct = "Correct Ans: "+getIntent().getStringExtra("marks");
        String wrong = "Wrong Ans: "+getIntent().getStringExtra("wrong");
        markText.setText(total);
        correctText.setText(correct);
        wrongText.setText(wrong);


    }
}