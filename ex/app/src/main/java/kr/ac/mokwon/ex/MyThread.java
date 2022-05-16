package kr.ac.mokwon.ex;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;

public class MyThread extends Thread{
    boolean _isRun;
    Canvas c;
    SurfaceHolder _holder;
    MySurFaceView _myView;
    public MyThread(MySurFaceView view, SurfaceHolder holder){ // 스레드 시작시 생성자 필요 생성자는 반환값이 필요없어서 public만 사용
        _myView = view;
        _holder = holder;
        _isRun = false;
    }
    // 스레드 죽이고 살리는 변수 설정.
    public void SetIsRun(boolean b){
        _isRun = b;
    }

    @Override
    public void run() {
        while (_isRun){            // _isRun 이 false까지 스레드 실행.
            c = null;
            try{
                c = _holder.lockCanvas(null);
                c.drawColor(Color.BLACK);
                synchronized (_holder){
                    _myView.Paint(c);
                }
                Thread.sleep(33);   // 대략 33프레임
            }catch (InterruptedException e){
            }finally {
                if(c != null){
                    _holder.unlockCanvasAndPost(c);
                }
            }
        }
    }
}
