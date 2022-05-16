package kr.ac.mokwon.ch006_4;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class MyThread extends Thread{
    Ball[] _balls;
    SurfaceHolder _holder;
    boolean _isRun;
    public MyThread(SurfaceHolder holder){
            _holder = holder;
    }
    public void SetBalls(Ball[] balls){
        _balls = balls;
    }
    public void SetRun(boolean b){
        _isRun = b;
    }

    @Override
    public void run() {
        while(_isRun){
            Canvas c = null;
            try{
                c = _holder.lockCanvas(null);
                c.drawColor(Color.BLACK);
                synchronized (_holder){
                    for(int i = 0; i < _balls.length; i++){
                        _balls[i].Paint(c);
                    }
                }
            }finally {
                if(c != null){
                    _holder.unlockCanvasAndPost(c);
                }
            }
        }
    }
}

