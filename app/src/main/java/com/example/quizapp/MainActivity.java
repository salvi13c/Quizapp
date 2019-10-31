package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btn1; //
    Button btn2;
    Button btn3;
    Button btn4;
    int QuestionNum = 0;
    TextView textQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setQuestions(QuestionNum);

    }


    public void onClickTrue(View v) {
        verifyanswer("true");
    }


    public void onClickFalse(View v) {
        verifyanswer("false");
    }


    public void onClickPrevious(View v) {
        previous();
    }


    public void onClickNext(View v) {
        next();
    }


    public void setQuestions(int QuestionNum) {
        String[] questions = getResources().getStringArray(R.array.questions);
        textQuestion = findViewById(R.id.textView);
        textQuestion.setText(questions[QuestionNum]);
    }

    public void previous() {
        if (QuestionNum > 0) {
            QuestionNum--;
            setQuestions(QuestionNum);
        } else {

        }

    }

    public void next() {
        if (QuestionNum < 2) {
            QuestionNum++;
            setQuestions(QuestionNum);
        } else {

        }
    }

    public void verifyanswer(String answer) {
        String[] answers = getResources().getStringArray(R.array.answers);
        String correct = answers[QuestionNum];
        if (correct.equals(answer)) {
            printToast("Correct!");
            next();
        } else {
            printToast("incorrect!");
            next();
        }
    }



    public void printToast(String text) {
        Toast toast = Toast.makeText(getApplicationContext(), text,
                Toast.LENGTH_SHORT);

        toast.show();
    }


}
