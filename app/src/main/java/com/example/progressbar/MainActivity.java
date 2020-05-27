package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ObjectAnimator objectAnimator;
    private ProgressBar progressBar;
    private Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

    }

    private void init() {
        progressBar = findViewById(R.id.progressBarAnim);
        objectAnimator = ObjectAnimator.ofInt(progressBar,"progress",0,100);


        objectAnimator.setDuration(7000); //設定特效持續時間


        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objectAnimator.start();//特效開始
            }
        });


        //特效設置監聽
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            //當特效結束時
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                progressBar.setVisibility(View.GONE);
            }
        });

    }

    private void setProgressBarColour(int score) {
        int color = 0;
        if (score < 30) {
            color = getResources().getColor(R.color.bg_red);
        } else if (score < 70) {
            color = getResources().getColor(R.color.bg_orangef);
        } else {
            color = getResources().getColor(R.color.bg_green11);
        }
        ClipDrawable d = new ClipDrawable(new ColorDrawable(color), Gravity.
                LEFT, ClipDrawable.HORIZONTAL);
        progressBar.setProgressDrawable(d);
        progressBar.setProgress(score);
    }

    public void changeColor(View view) {
        setProgressBarColour(50);
        Log.v("hank","changeColor");
    }
}
