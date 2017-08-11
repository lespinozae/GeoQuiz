package com.example.lmanuel.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.lmanuel.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOW = "com.example.lmanuel.geoquiz.answer_shown";
    private boolean mAsnwerIsTrue;
    private TextView mAnswerTextView;
    private Button mShowAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAsnwerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
        mShowAnswer = (Button) findViewById(R.id.showAnswerButton);

        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAsnwerIsTrue)
                {
                    mAnswerTextView.setText(R.string.true_button);
                }
                else
                {
                    mAnswerTextView.setText(R.string.false_button);
                }

                setAnswerShownResult(true);
            }
        });
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    private void setAnswerShownResult(boolean isAnswerShown)
    {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOW, isAnswerShown);
    }
}
