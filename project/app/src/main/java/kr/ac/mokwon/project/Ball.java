package kr.ac.mokwon.project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Ball extends View {
    int _k,_z;

    boolean kf = false;
    boolean zf = false;
    Paint p = new Paint();
    
    static int WIDTH = 223;
    static int HEIGHT = 293;
    public  Ball(Context context){
        super(context);
        _k = (int)(Math.random()*(WIDTH) + 40);
        _z = (int)(Math.random()*(HEIGHT));



        p.setColor(Color.RED);
    }
    public void SetPosition(int k,int z){


        if(_k < 36){
            kf = true;

        }
        if(_k > 264){
            kf = false;

        }
        if(_z < 3){
            zf = true;

        }
        if(_z > 294){
            zf = false;

        }
        if(kf){
            _k += k;
            if((int)(Math.random()*20)<= 10 ){
                _z -= 2*z;
            }
            else{
                _z += 2*z;
            }
        }
        if(!kf){
            _k -= k;

        }
        if(zf){
            _z += z;
            if((int)(Math.random()*20)<= 10 ){
                _k -= 2*k;
            }
            else{
                _k += 2*k;
            }
        }
        if(!zf){
            _z -= z;

        }
    }


    public void paint(Canvas c) {
        c.drawCircle(_k,_z,5 ,p);

    }

}