package com.example.quizzer.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quizzer.R;
import com.example.quizzer.database.MyDataBase;

import java.math.RoundingMode;

public class SignupActivity extends AppCompatActivity {

    EditText signUpName,signUpEmail,signUpUserName,signUpPassword,signUpConformPassword;
    Button signBut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sign up");

        signUpName = findViewById(R.id.signUpName);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpUserName = findViewById(R.id.signUpUserName);
        signUpPassword = findViewById(R.id.signUpPasswaord);
        signUpConformPassword = findViewById(R.id.signUpConformPasswaord);

        signBut = findViewById(R.id.signUpPageBut);

        signBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData(){

        String name = signUpName.getText().toString().trim();
        String email = signUpEmail.getText().toString().trim();
        String username = signUpUserName.getText().toString().trim();
        String password = signUpPassword.getText().toString().trim();
        String conformPass = signUpConformPassword.getText().toString().trim();

        if(!password.equals(conformPass)){
            Toast.makeText(SignupActivity.this,"Password Not Matched",Toast.LENGTH_SHORT).show();
        }else{

            if(name.length()<=0 && email.length()<=0 && username.length()<=0 && password.length()<=0 &&
                    conformPass.length()<=0){
                Toast.makeText(SignupActivity.this,"Enter All Data",Toast.LENGTH_SHORT).show();
            }else {
                MyDataBase myDataBase = new MyDataBase(SignupActivity.this);
                myDataBase.insertData(name,email,username,password);
            }
        }
    }
}