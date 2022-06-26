package kr.ac.mokwon.suti_game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class MySurFaceView extends SurfaceView implements SurfaceHolder.Callback {
    Ball[] _ball;
    private ArrayList<Missle> MissleList;
    MyThread _thread ;
    Player _player;
    boolean _isDown;
    int _x,_y;
    int count = 10000;
    Paint _p,_p2, __p, p;
    String text, heet;
    int _q;
    boolean bos = true;
    public MySurFaceView(Context context, AttributeSet attrs) {  // 버튼 생성을 위한 생성자
        super(context, attrs);
        p = new Paint();
        p.setColor(Color.YELLOW);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        _ball = new Ball[7];
        _player = new Player(context,135,240);
        _p = new Paint();
        _p2 = new Paint();
        _p.setColor(Color.GREEN);
        _p.setTextSize(18);
        _q = 130;
        __p = new Paint();
        text = count + "";
        heet = "나은 목숨 : " + (""+3);
        _p2.setColor(Color.BLUE);
        for (int i = 0; i < _ball.length; i++){
            _ball[i] = new Ball(context);
        }
        MissleList = new ArrayList<Missle>();

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        TreadDestroyO();

        _thread = new MyThread(this, surfaceHolder,MissleList,_player,_ball[0],_ball[1],_ball[2],_ball[3],_ball[4],_ball[5],_ball[6]);
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
                _thread.sleep(1000);
                _thread = null;
                retry = false;
            }catch (InterruptedException e ){

            }
        }
    }

    public void Paint(Canvas c){
        if(_isDown){
            _player.SetPosition(_x,_y,__p);

        }
        for (int i = 0; i < _ball.length; i++){
            _ball[i].SetPosition();
        }
        for (int i = 0; i < _ball.length; i++){
            _ball[i].Paint(c);
        }
        _player.paint(c);
        if(_q >= 200) bos = false;
        if(_q <= 30) bos = true;
        if(bos){
            _q += 3;
        }else{
            _q -= 3;
        }



        c.drawRect(_q,5,_q + 70,5 + 25,_p2);
        c.drawText(text, _q+5,25,_p);
        c.drawText(heet, 130,159,_p);
        c.drawLine(30,0,30,300,_p);
        c.drawLine(270,0,270,300,_p);
        c.drawLine(30,300,270,300,_p);

    }

    public void MoveOn(int speedX, int speedY){
        _isDown = true;

        _x = speedX;
        _y = speedY;
    }
    public  void MoveOff(){
        _isDown = false;
    }




}
