package com.example.quizzer.pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quizzer.R;

public class QuestionActivityBE extends AppCompatActivity {

    TextView beQuestionTextView;
    RadioGroup radioGroupBE;
    RadioButton radioButton5,radioButton6,radioButton7,radioButton8;
    Button beNextButton;


    String questions[] = {
            "In how many different ways can the letters of the word 'CORPORATION' be arranged so that the vowels always come together?",
            "Two numbers are respectively 20% and 50% more than a third number. The ratio of the two numbers is:",
            "A train 125 m long passes a man, running at 5 km/hr in the same direction in which the train is going, in 10 seconds. The speed of the train is:",
            "If 20% of a = b, then b% of 20 is the same as: ",
            "What least number must be added to 1056, so that the sum is completely divisible by 23 ?",
            "The greatest number of four digits which is divisible by 15, 25, 40 and 75 is: ",
            "A boat can travel with a speed of 13 km/hr in still water. If the speed of the stream is 4 km/hr, find the time taken by the boat to go 68 km downstream. ",
            "A, B and C can do a piece of work in 20, 30 and 60 days respectively. In how many days can A do the work if he is assisted by B and C on every third day?",
            "If a person walks at 14 km/hr instead of 10 km/hr, he would have walked 20 km more. The actual distance travelled by him is: ",
            "In how many ways a committee, consisting of 5 men and 6 women can be formed from 8 men and 10 women? "
    };
    String answers[] = {"50400","4:5","50 km/hr","4% of a","2","9600","4 hr","15 days","50 km","11760"};
    String opt[] = {
            "810","1440","2880","50400",
            "2:5","3:5","4:5","6:7",
            "45 km/hr","50 km/hr","54 km/hr","55 km/hr",
            "4% of a","5% of a","20% of a","None of these",
            "2","3","18","21",
            "9000","9400","9600","9800",
            "2 hr","3 hr","4 hr","5 hr",
            "12 days","15 days","16 days","18 days",
            "50 km","56 km","70 km","80 km",
            "266","5040","11760","86400"
    };
    int flag=0;
    public int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_b_e);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("BE Question");
        beQuestionTextView = findViewById(R.id.questionTextBE);
        radioGroupBE = findViewById(R.id.radioGroupBE);
        radioButton5 = findViewById(R.id.radioButton5);
        radioButton6 = findViewById(R.id.radioButton6);
        radioButton7 = findViewById(R.id.radioButton7);
        radioButton8 = findViewById(R.id.radioButton8);

        beQuestionTextView.setText(questions[flag]);
        radioButton5.setText(opt[0]);
        radioButton6.setText(opt[1]);
        radioButton7.setText(opt[2]);
        radioButton8.setText(opt[3]);

        beNextButton = findViewById(R.id.beNextButt);
        beNextButton.setOnClickListener(v -> {
            if(radioGroupBE.getCheckedRadioButtonId()==-1){
                Toast.makeText(QuestionActivityBE.this,"Please Select One Choice",Toast.LENGTH_SHORT).show();
            }else {
                RadioButton radioButtonAns = findViewById(radioGroupBE.getCheckedRadioButtonId());
                String ans = radioButtonAns.getText().toString();
                Toast.makeText(QuestionActivityBE.this,ans,Toast.LENGTH_SHORT).show();
                if(ans.equals(answers[flag])){
                    correct++;
                }else {
                    wrong++;
                }
                flag++;
                if(flag<questions.length){
                    beQuestionTextView.setText(questions[flag]);
                    radioButton5.setText(opt[flag*4]);
                    radioButton6.setText(opt[flag*4+1]);
                    radioButton7.setText(opt[flag*4+2]);
                    radioButton8.setText(opt[flag*4+3]);
                }else {
                    marks = correct;
                    String marksAns = String.valueOf(correct);
                    String wrongAns= String.valueOf(wrong);
                    Intent intent = new Intent(QuestionActivityBE.this,BEResult.class);
                    intent.putExtra("marks",marksAns);
                    intent.putExtra("wrong",wrongAns);
                    startActivity(intent);
                }
                radioGroupBE.clearCheck();
            }
        });

        findViewById(R.id.beExitBut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuestionActivityBE.this,YearActivity.class);
                startActivity(intent);
            }
        });
    }
}