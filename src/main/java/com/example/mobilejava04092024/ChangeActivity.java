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

public class ChangeActivity extends AppCompatActivity {

    private Button firstPage;
    private Button secondPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_activity);

        firstPage = findViewById(R.id.firstActivity);
        secondPage = findViewById(R.id.secondActivity);

        firstPage.setVisibility(View.INVISIBLE);
        secondPage.setVisibility(View.INVISIBLE);

        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.appearance_animation1);
        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.appearance_anamation2);

        firstPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        secondPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChangeActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        firstPage.post(() -> firstPage.startAnimation(animation1));
        firstPage.setVisibility(View.VISIBLE);

        secondPage.post(() -> secondPage.startAnimation(animation2));
        secondPage.setVisibility(View.VISIBLE);
    }
}
