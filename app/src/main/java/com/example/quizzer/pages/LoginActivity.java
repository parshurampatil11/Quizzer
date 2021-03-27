package com.example.quizzer.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quizzer.R;
import com.example.quizzer.database.MyDataBase;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    TextInputLayout loginName,loginPassword;
    Button logInPageBut,logInPageSignUp;
    MyDataBase myDataBase;
    ArrayList<String> loginUserArray,loginPassArray;
    String name,password,logName,logPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Login");

        loginName = findViewById(R.id.loginName);
        loginPassword = findViewById(R.id.loginPassword);

        myDataBase = new MyDataBase(LoginActivity.this);
        loginUserArray = new ArrayList<>();
        loginPassArray = new ArrayList<>();

        logInPageSignUp = findViewById(R.id.loginSignUp);
        logInPageSignUp.setVisibility(View.GONE);
        logInPageBut = findViewById(R.id.logInPageBut);
        logInPageBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logName = null;
                logPass = null;
                getData();
                loginData();
            }
        });
    }

    private void getData(){

        Cursor cursor = myDataBase.displayData();

        if(cursor.getCount()==0){
            Toast.makeText(LoginActivity.this,"Not Any Records",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                loginUserArray.add(cursor.getString(3));
                loginPassArray.add(cursor.getString(4));
            }
        }
    }

    private void loginData(){
        name = loginName.getEditText().getText().toString().trim();
        password = loginPassword.getEditText().getText().toString().trim();

        for(String i: loginUserArray){
            if(i.equals(name)){
                logName = name;
                break;
            }
        }
        for(String j: loginPassArray){
            if(j.equals(password)){
                logPass = password;
                break;
            }
        }

        if(logName!=null && logPass!=null){
            Intent intent = new Intent(LoginActivity.this,YearActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this,"Records Not Match",Toast.LENGTH_SHORT).show();
            logInPageSignUp.setVisibility(View.VISIBLE);
            logInPageSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}