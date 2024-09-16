package com.example.mobilejava04092024;

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

public class MainActivity extends AppCompatActivity {
    private ImageView animationIV;
    private Button startBtn;
    private Button pauseBtn;

    private Button backActivity;
    private AnimationDrawable frameAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationIV = findViewById(R.id.animImageView);
        startBtn = findViewById(R.id.startButton);
        pauseBtn = findViewById(R.id.pauseButton);
        backActivity = findViewById(R.id.backActivityButton);

        frameAnimation = (AnimationDrawable) animationIV.getDrawable();

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.appearance_animation3);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.appearance_animation1);

        animationIV.setVisibility(View.INVISIBLE);
        startBtn.setVisibility(View.INVISIBLE);
        pauseBtn.setVisibility(View.INVISIBLE);
        backActivity.setVisibility(View.INVISIBLE);

        startBtn.setOnClickListener(v -> {
            if (!frameAnimation.isRunning()) {
                frameAnimation.start();
            }
        });

        pauseBtn.setOnClickListener(v -> {
            if (frameAnimation.isRunning()) {
                frameAnimation.stop();
            }
        });

        backActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ChangeActivity.class);
                startActivity(intent);
            }
        });

        animationIV.post(() -> animationIV.startAnimation(animation1));
        animationIV.setVisibility(View.VISIBLE);

        startBtn.post(() -> startBtn.startAnimation(animation2));
        startBtn.setVisibility(View.VISIBLE);

        pauseBtn.post(() -> pauseBtn.startAnimation(animation2));
        pauseBtn.setVisibility(View.VISIBLE);

        backActivity.post(() -> backActivity.startAnimation(animation2));
        backActivity.setVisibility(View.VISIBLE);
    }
}