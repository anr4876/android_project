package kr.ac.mokwon.ex006_2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Snow {
    int _x,_y;
    int _speedx = 1;
    int _speedy = 1;
    int _diameter;


    static int WIDTH = 300;
    static int HEIGHT = 300;
    Paint p = new Paint();

    public  Snow(int d){
        _diameter = d;
        _x = (int)(Math.random()*(WIDTH - _diameter)+ _diameter);
        _y = (int)(Math.random()*(HEIGHT - _diameter)+ _diameter);

        _speedy = (int)(Math.random()*4 + 1);
        _speedx = (int)(Math.random()*4 + 1);

        p.setColor(Color.WHITE);
    }
    public void Paint(Canvas c){



        _y += _speedy;
        _x += _speedx;
        c.drawCircle(_x,_y,_diameter,p);
    }

}
