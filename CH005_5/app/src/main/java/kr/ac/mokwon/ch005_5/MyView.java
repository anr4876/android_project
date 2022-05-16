package kr.ac.mokwon.ch005_5;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
    int x, y;
    int k = 0;
    String str;
    Paint p;
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
        p = new Paint();
        p.setColor(Color.BLUE);
        p.setTextSize(25);

    }

    @Override
    protected void onDraw(Canvas canvas) {


        canvas.drawCircle(x, y, k, p);
        canvas.drawText("액션종류 : " + str, 0, 50, p);

        super.onDraw(canvas);

    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
        x = (int)event.getX();
        y = (int)event.getY();

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            str = "down";
            k = 30;
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            str = "move";
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            str = "up";
            k = 0;


        }
        invalidate();

        return true;
    }
}
