package kr.ac.mokwon.ex006_2;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;

import androidx.annotation.NonNull;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    MyThread _thread;
    Snow[] _balls;
    SurfaceHolder holder;
    public MySurfaceView(Context context) {
        super(context);

        _balls = new Snow[27];
        for (int i = 0; i < _balls.length; i++){
            _balls[i] = new Snow(3);
        }
        holder = getHolder();
        holder.addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        _thread = new MyThread(surfaceHolder);
        _thread.SetRun(true);
        _thread.SetBalls(_balls);
        _thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        _thread.SetRun(false);
        boolean retry = true;
        while (retry){
            try{
                _thread.join();
                retry = false;
            }catch (InterruptedException e){

            }
        }
    }
}
