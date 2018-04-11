package com.example.mahafuz.shivamssanwich;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView mimageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        mimageView = findViewById(R.id.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final View cl = findViewById(R.id.view);
                int clx = cl.getWidth()/2;
                int cly = cl.getHeight()/2;
                int ImageRadius = (int) Math.max(mimageView.getWidth()/4,mimageView.getHeight()/4);
                int finalRadius = (int) Math.hypot(clx,cly);
                Animator anim = ViewAnimationUtils.createCircularReveal(cl,clx,cly,finalRadius,ImageRadius);
                anim.setDuration(2000);
                anim.start();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Pair pairs = new Pair<View,String>(mimageView, "imageTran");
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                        startActivity(new Intent(getApplicationContext(),RecyclerViewActivity.class),options.toBundle());
                    }
                },2000);
            }
        },2000);

    }
}
