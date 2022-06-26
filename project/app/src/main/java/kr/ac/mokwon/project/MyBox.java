package kr.ac.mokwon.project;


import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;

import android.graphics.Paint;

import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MyBox extends View {
    int _x, _y;
    Paint _p;

    public MyBox(Context context, int x, int y ) {
        super(context);
        _x = x;
        _y = y;

        _p = new Paint();
        _p.setColor(Color.GREEN);



    }


    public void SetPosition(int x, int y,Paint p){

        if(_x < 33){
           _x += 9;


        }
        if(_x > 243){
            _x -= 9;


        }
        if(_y < 3){
            _y += 9;


        }
        if(_y > 273){
            _y -= 6;

        }
        _x += x;

        _y += y;

        _p = p;

    }




    public void paint( Canvas c){



        c.drawRect( _x,_y,_x + 25,_y + 25,_p);

    }

}