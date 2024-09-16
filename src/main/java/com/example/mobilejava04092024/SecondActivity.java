package com.example.mobilejava04092024;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    private ImageView animationIV;
    private Button startBtn;
    private Button pauseBtn;

    private Button backActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        startBtn = findViewById(R.id.startButton);
        pauseBtn = findViewById(R.id.pauseButton);
        backActivity = findViewById(R.id.backActivityButton);
        animationIV=findViewById(R.id.animImageView);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.my_animation);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.appearance_animation1);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.appearance_animation4);

        startBtn.setVisibility(View.INVISIBLE);
        pauseBtn.setVisibility(View.INVISIBLE);
        backActivity.setVisibility(View.INVISIBLE);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator rotateYAnimator = ObjectAnimator.ofFloat(animationIV, "rotationY", 0f, 360f);
                animationIV.startAnimation(animation);
            }
        });

        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationIV.clearAnimation();
            }
        });

        backActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ChangeActivity.class);
                startActivity(intent);
            }
        });

        animationIV.post(() -> animationIV.startAnimation(animation2));

        startBtn.post(() -> startBtn.startAnimation(animation1));
        startBtn.setVisibility(View.VISIBLE);

        pauseBtn.post(() -> pauseBtn.startAnimation(animation1));
        pauseBtn.setVisibility(View.VISIBLE);

        backActivity.post(() -> backActivity.startAnimation(animation1));
        backActivity.setVisibility(View.VISIBLE);
    }
}
