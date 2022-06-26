package kr.ac.mokwon.project;


import android.graphics.Canvas;
import android.graphics.Color;

import android.view.SurfaceHolder;
import android.widget.Button;


import androidx.annotation.NonNull;

import java.util.Timer;
import java.util.TimerTask;


public class MyThread extends Thread{
    boolean _isRun;
    SurfaceHolder _holder;
    MySurFaceView _myView;
    Canvas c;
    Timer timer;
    int i = 1;
    int count = 3;
    MyBox _player;
    SubActivity ss;
    Ball b1;
    Ball b2;
    Ball b3;
    Ball b4;
    Ball b5;
    Ball b6;
    Ball b7;

    int ti = 0;
    int k = 0;
    int rgg[] = {Color.BLUE, Color.GREEN};
    int score = 0;

    public void Start_Period(){
        timer = new Timer();
        timer.schedule(addTask,0,4000);
    }

    public void Stop_Period(){
        if(timer != null)timer.cancel();
    }

    TimerTask addTask = new TimerTask() {
        @Override
        public void run() {
            if(i == 1){
                _myView.__p.setColor(rgg[i]);
                k = 1;
                i--;
                ti++;
                score += 5;
                if(count != -1)count--;

            }
            else{
                _myView.__p.setColor(rgg[i]);
                k = 0;
                i++;
                ti++;
                score += 10;
                if(count != -1)count--;

            }

        }
    };

    public MyThread(MySurFaceView view, SurfaceHolder holder , MyBox _myBox , Ball _b1, Ball _b2, Ball _b3, Ball _b4, Ball _b5, Ball _b6, Ball _b7){ // 스레드 시작시 생성자 필요 생성자는 반환값이 필요없어서 public만 사용
        _myView = view;
        _holder = holder;
        _isRun = false;
        _player = _myBox;
        ss = new SubActivity();
        Start_Period();
        b1 = _b1;
        b2 = _b2;
        b3 = _b3;
        b4 = _b4;
        b5 = _b5;
        b6 = _b6;
        b7 = _b7;


    }

    public void vigu(Ball b){

        if(b._k > _player._x && b._k < _player._x + 25 && b._z > _player._y && b._z < _player._y + 25 && k == 1 && ti > 2){

            _myView.TreadDestroyO();


        }
    }



            public void SetIsRun(boolean b){
                _isRun = b;
            }


            @Override
            public void run() {

                while (_isRun){            // _isRun 이 false까지 스레드 실행.
                    c = null;
                    try{
                        c = _holder.lockCanvas(null);
                        c.drawColor(Color.WHITE);
                        synchronized (_holder){

                            _myView.Paint(c);
                            vigu(b1);
                            vigu(b2);
                            vigu(b3);
                            vigu(b4);
                            vigu(b5);
                            vigu(b6);
                            vigu(b7);
                            if(count < 0){
                                _myView.text ="점수 : " +  ((score - 30) + "");
                            }
                            else if(count == 0){
                                _myView.text ="GO!!" ;
                            }
                            else
                            {
                                _myView.text ="" +  count;

                            }




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

