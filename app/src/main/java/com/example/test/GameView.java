package com.example.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.View;

import java.util.Random;

import javax.net.ssl.HandshakeCompletedEvent;

public class GameView extends View {

    Bitmap background;
    Rect rect;
    int dWidth,dHeight;
    Bitmap zombie[]= new Bitmap[8];
    int zombieX, zombieY,zombieSpeed,zombieFrame,zombieWidth;
    Random random;
    Handler handler;//không biết nhưng dùng nó để có thể dùng Runnable
    Runnable runnable;//loop chương trình
    final  long UPDATE_MILLIS = 30;
    public GameView(Context context) {
        super(context);
        Khoitaodulieu();
        //Khởi tạo vòng lặp
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    public void Khoitaodulieu(){
        background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        Display display = ((Activity)getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        dWidth= size.x;
        dHeight = size.y;
        rect =new Rect(0,0,dWidth,dHeight);
        zombie[0]=BitmapFactory.decodeResource(getResources(),R.drawable.a1);
        zombieX= dWidth+300;
        zombieY= 860;
        zombieSpeed=15;
        zombieFrame=0;
        zombieWidth =zombie[0].getWidth();
        random = new Random();
        handler = new Handler();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background,null, rect,null);//vẽ background
        canvas.drawBitmap(zombie[zombieFrame],zombieX, zombieY,null);//vẽ con zomb
        zombieX-= zombieSpeed;
        if(zombieX< -zombieWidth){
            //set tọa độ khi mà con zom nó đi quá màn hình nè :D
            zombieX= dWidth+random.nextInt(500);
            zombieY= 860;
            zombieSpeed = 14+random.nextInt(17);
        }
        handler.postDelayed(runnable,UPDATE_MILLIS);//lặp lại nè
    }

}
