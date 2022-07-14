package com.example.test;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
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
                player.setX(pointX-100);
                player.setY(pointY+100);
                String mess1 = String.format("location: (%.2f,%.2f)", pointX-100, pointY+100);
                Log.d(playgame.DEBUGTAG, mess1);
                return false;
            }
        });
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        return false;
    }



    /*public void ondraw(float a, float b) {
        Canvas canvas = new Canvas();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20f);
        float startX= (float)192.95;
        float startY= (float) 745.05;
        canvas.drawLine(startX,startY,a,b,paint);
            Log.d(playgame.DEBUGTAG,"hello");


    }*/

}