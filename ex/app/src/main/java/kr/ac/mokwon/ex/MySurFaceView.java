package kr.ac.mokwon.ex;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.compose.ui.graphics.Paint;

public class MySurFaceView extends SurfaceView implements SurfaceHolder.Callback {

    MyThread _thread ;
    Player _player;
    boolean _isDown;
    float _x,_y;

    public MySurFaceView(Context context, AttributeSet attrs) {  // 버튼 생성을 위한 생성자
        super(context, attrs);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        _player = new Player(150,300);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
            TreadDestroyO();

        _thread = new MyThread(this, surfaceHolder);
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
                _thread.join();
                _thread = null;
                retry = false;
            }catch (InterruptedException e ){

            }
        }
    }

    public void Paint(Canvas c){
        if(_isDown){
            _player.SetPosition(_x,_y);
        }
        _player.paint(c);
    }

    public void MoveOn(float speedX, float speedY){
        _isDown = true;

        _x = speedX;
        _y = speedY;
    }
    public  void MoveOff(){
        _isDown = false;
    }
}
