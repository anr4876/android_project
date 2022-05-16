package kr.ac.mokwon.ch006_4;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {
    int _x,_y;
    int _speedx = 1;
    int _speedy = 1;
    int _diameter;
    static int WIDTH = 300;
    static int HEIGHT = 300;
    Paint p = new Paint();

    public  Ball(int d){
        _diameter = d;
        _x = (int)(Math.random()*(WIDTH - _diameter)+ _diameter);
        _y = (int)(Math.random()*(HEIGHT - _diameter)+ _diameter);

        _speedx = (int)(Math.random()*6 + 1);
        _speedy = (int)(Math.random()*6 + 1);
        p.setColor(Color.RED);
    }
    public void Paint(Canvas c){
        if(_x > WIDTH || _x < 0){
            _speedx *= -1;
        }
        if(_y > HEIGHT || _y < 0){
            _speedy *= -1;
        }
        _x += _speedx;
        _y += _speedy;
        c.drawCircle(_x,_y,_diameter,p);
    }
}
