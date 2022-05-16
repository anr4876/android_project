package kr.ac.mokwon.ex006_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class MyView extends View {
    boolean _isOpen;
    Paint _paint, _framePaint;
    RectF _oval;
    float _start, _sweep;
    float _startSpeed = 15;
    float _sweepSpeed = 2;
    public MyView(Context context) {
        super(context);
        _paint = new Paint();
        _paint.setAntiAlias(true);
        _paint.setStyle(Paint.Style.FILL);
        _paint.setColor(0x88ff0000);

        _framePaint = new Paint();
        _framePaint.setAntiAlias(true);
        _framePaint.setStyle(Paint.Style.STROKE);
        _framePaint.setColor(0x8800ff00);

        _oval = new RectF(40,10,290,260);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.YELLOW);
        canvas.drawRect(_oval, _framePaint);
        canvas.drawArc(_oval, _start, _sweep, true, _paint);


        if(_isOpen) {
            _start += _sweepSpeed;
            if(_start > 30) {
                _isOpen = false;
            }
        }else{
            _start -= _sweepSpeed;
            if(_start <= 0){
                _isOpen = true;
            }
        }
        _sweep = 360 -  2* _start;











        invalidate();
    }
}
