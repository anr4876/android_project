package kr.ac.mokwon.ex;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Player {
    float _x, _y;
    Paint _p;
    public Player(float x, float y){

        _x = x;
        _y = y;
        _p = new Paint();
        _p.setColor(Color.RED);
    }
    public void SetPosition(float x, float y){
        _x += x;
        _y += y;
    }
    public void paint(Canvas c){
        c.drawCircle(_x,_y,20,_p);
    }
}
