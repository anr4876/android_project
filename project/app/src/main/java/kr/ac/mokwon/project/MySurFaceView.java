package kr.ac.mokwon.project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.logging.Handler;

public class MySurFaceView extends SurfaceView implements SurfaceHolder.Callback {

    MyThread _thread ;
    MyBox _player;
    boolean _isDown;
    Paint __p;
    Paint _p;
    int _x,_y;
    Ball[] _ball = new Ball[7];
    int _z;
    int _k;
    public String text = "3";


    public MySurFaceView(Context context, AttributeSet attrs) {  // 버튼 생성을 위한 생성자
        super(context, attrs);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        __p = new Paint();
        _p = new Paint();
        _p.setColor(Color.BLACK);
        _p.setTextSize(18);

        SurfaceHolder _holder;

        for (int i = 0; i < _ball.length; i++){
            _ball[i] = new Ball(context);
        }
        _player = new MyBox(context,130,240);

        _holder = getHolder();
        _holder.addCallback(this);

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        TreadDestroyO();

        _thread = new MyThread(this, surfaceHolder,_player,_ball[0],_ball[1],_ball[2],_ball[3],_ball[4],_ball[5],_ball[6]);
        _thread.SetIsRun(true);
        _thread.start();

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        TreadDestroyO();
    }
    void TreadDestroyO(){

        if(_thread == null){
            return;
        }
        _thread.SetIsRun(false);
        boolean retry = true;
        while (retry){
            try{

                Thread.sleep(1000);

                _thread = null;
                retry = false;
            }catch (InterruptedException e ){

            }
        }


    }

    public void Paint(Canvas c){
        for (int i = 0; i < _ball.length; i++){
            _k = _ball[i]._k;
            _z = _ball[i]._z;

        }
        if(_isDown){

            _player.SetPosition(_x,_y,__p);

        }
        for (int i = 0; i < _ball.length; i++){
            _ball[i].SetPosition((int)(Math.random()*4 + 1),(int)(Math.random()*4 + 1));
        }
        for (int i = 0; i < _ball.length; i++){
            _ball[i].paint(c);
        }
        _player.paint(c);

        c.drawText(text, 120,120,_p);
        c.drawLine(30,0,30,300,_p);
        c.drawLine(270,0,270,300,_p);
        c.drawLine(30,300,270,300,_p);
    }

    public void MoveOn(int speedX, int speedY){
        _isDown = true;


        _x = speedX;
        _y = speedY;

    }
    public  Boolean MoveOff(){

        _isDown = false;
        return false;
    }
}
