package kr.ac.mokwon.suti_game;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Ball extends View {
    int _k,_z;
    int _zPlus;
    Paint p = new Paint();

    static int WIDTH = 223;

    public  Ball(Context context){
        super(context);
        _k = (int)(Math.random()*(WIDTH) + 40);
        _z = (int)(Math.random()*(WIDTH) + 40);
       _zPlus = (int)(Math.random()*5 + 1);



        p.setColor(Color.RED);
    }

    public void SetPosition(){
        _z += _zPlus;
        if(_z >= 300){
            _k = (int)(Math.random()*(WIDTH) + 40);
            _z = 0;
        }
    }

    public void Paint(Canvas c) {

        c.drawCircle(_k,_z,5 ,p);

    }

}