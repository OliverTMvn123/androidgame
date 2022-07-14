package com.example.test;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;



public class playgame extends AppCompatActivity implements View.OnTouchListener {

    private static final String DEBUGTAG = "JWP";
    private ImageView player;
    private Animation anim_Shoot;
    CountDownTimer Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playgame);
        addTouchListener();
        animation();
        player= (ImageView)findViewById(R.id.player);

    }

    private void animation() {
        anim_Shoot= AnimationUtils.loadAnimation(this,R.anim.anim_shot);

    }

    private void addTouchListener() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.layoutAttack);
        layout.setOnTouchListener(new View.OnTouchListener() {
            float pointX=0,pointY=0;

            public boolean onTouch(View view, MotionEvent event) {
                pointX = event.getX();
                pointY = event.getY();
                String mess = String.format("Coordinates: (%.2f,%.2f)", pointX, pointY);
                Log.d(playgame.DEBUGTAG, mess);
                float tam1=(float)355.95,tam2=(float)702.03;
                float a=-(tam2-pointY)/(-tam1+pointX);
                float b=tam2-tam1*a;
                String c="y="+a+"x+"+b;
                Timer= new CountDownTimer(2000,100) {
                    @Override
                    public void onTick(long l) {
                        player.setX(player.getX()+35);
                        player.setY(a*player.getX()+b);
                    }

                    @Override
                    public void onFinish() {

                    }
                };
                Timer.start();
                /*player.setX(pointX-300);
                player.setY(pointY-250);*/

                return false;
            }
        });
    }

    private void createVecter(float pointX, float pointY, int i, int i1) {
        float a=(i1-pointY)%(i+pointX);
        float b=i1-i*a;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        return false;
    }

}