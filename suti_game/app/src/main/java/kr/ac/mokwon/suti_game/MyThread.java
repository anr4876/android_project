package kr.ac.mokwon.suti_game;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MyThread extends Thread{
    boolean _isRun;

    public boolean _isRun2;
    public boolean _isRun3;
    Timer timer,timer2;
    int i = 0;
    Canvas c;
    SurfaceHolder _holder;
    MySurFaceView _myView;
    SubActivity _sub;
    Player  _player;
    int count = 0;
    int rgg[] = {Color.BLUE, Color.GREEN};
    int ddd = 10000;
    Ball b1;
    Ball b2;
    Ball b3;
    Ball b4;
    Ball b5;
    Ball b6;
    Ball b7;
    int k = 0;
    Paint p ;

    ArrayList<Missle> MissleList;
    public MyThread(MySurFaceView view, SurfaceHolder holder , ArrayList<Missle> missleList, Player _myBox , Ball _b1, Ball _b2, Ball _b3, Ball _b4, Ball _b5, Ball _b6, Ball _b7){ // 스레드 시작시 생성자 필요 생성자는 반환값이 필요없어서 public만 사용
        _myView = view;
        _sub = new SubActivity();
        _holder = holder;
        _isRun2 = false;
        _isRun3 = false;
        Start_Period();
        Start_Period2();
        b1 = _b1;
        b2 = _b2;
        b3 = _b3;
        b4 = _b4;
        b5 = _b5;
        b6 = _b6;
        b7 = _b7;
        p = new Paint();

        p.setColor(Color.YELLOW);
        _player = _myBox;
        MissleList = new ArrayList<Missle>();
    }
    public void Start_Period2(){
        timer2 = new Timer();
        timer2.schedule(addTask2,0,200);
    }
    public void Stop_Period2(){
        if(timer2 != null)timer2.cancel();
    }

    TimerTask addTask2 = new TimerTask() {
        @Override
        public void run() {
            MissleList.add(new Missle(_player._x + 12, 240));

        }
    };


    public void Start_Period(){
        timer = new Timer();
        timer.schedule(addTask,0,4000);
    }

    public void vigu(Ball b){

        if(b._k > _player._x && b._k < _player._x + 25 && b._z > _player._y && b._z < _player._y + 25 && k == 1 ){
            count++;
            k = 0;
            _myView.__p.setColor(Color.BLACK);
            i = 1;
            if(count == 3){
                _myView.heet ="Game_Out";

                _isRun2 = true;
            }


        }
    }

    public void Stop_Period(){
        if(timer != null)timer.cancel();
    }

    TimerTask addTask = new TimerTask() {
        @Override
        public void run() {
            if(i == 1){
                _myView.__p.setColor(rgg[i]);

                i--;
                k = 1;



            }
            else {
                _myView.__p.setColor(rgg[i]);

                i++;
                k = 0;



            }



        }
    };


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
                c.drawColor(Color.WHITE);
                synchronized (_holder){
                    _myView.Paint(c);
                    _myView.heet ="남은 목숨 : " + (""+(3-count));

                    vigu(b1);
                    vigu(b2);
                    vigu(b3);
                    vigu(b4);
                    vigu(b5);
                    vigu(b6);
                    vigu(b7);

                    if(_isRun3){
                        _myView.TreadDestroyO();
                    }
                    if(_isRun2){
                        _isRun3 = true;

                    }
                    if(ddd <= 0){
                        _myView.text = "break";
                        _myView.heet = "Game_Clear";
                        _isRun2 = true;
                    }
                    if(ddd > 0) {
                        _myView.text = "" + ddd;
                    }


                    for (int i = MissleList.size() - 1; i>=0; i--){
                        if(MissleList.get(i).Move() == true){
                            MissleList.remove(i);
                            continue;
                        }
                        if(MissleList.get(i)._x >= _myView._q && MissleList.get(i)._x <= _myView._q + 70 ){
                            if(MissleList.get(i)._y >= 5 && MissleList.get(i)._y <= 30){

                                ddd -= 100;
                                MissleList.remove(i);
                            }
                        }
                    }
                    for(Missle tMissle: MissleList){
                        c.drawCircle(tMissle._x,tMissle._y,5 ,p);

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
