package kr.ac.mokwon.ex;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Player {
    float _x, _y;
    Paint _p;
    Paint __p;
    public Player(float x, float y){

        _x = x;
        _y = y;
        _p = new Paint();
        _p.setColor(Color.RED);
        __p = new Paint();
        __p.setColor(Color.WHITE);
    }
    public void SetPosition(float x, float y){
        _x += x;
        _y += y;

    }
    public void paint(Canvas c){

        c.drawCircle(_x,_y,20,_p);

        c.drawLine(40,0,40,320,__p);
        c.drawLine(240,0,240,320,__p);
        c.drawLine(40,320,240,320,__p);
    }
}
