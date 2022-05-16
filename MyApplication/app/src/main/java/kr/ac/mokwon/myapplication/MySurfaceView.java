package kr.ac.mokwon.myapplication;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;

import android.content.Context;
import android.view.SurfaceHolder;
import android.widget.Button;


import androidx.annotation.NonNull;

public class MySurfaceView extends SurfaceView   {

    SurfaceHolder holder;



    public MySurfaceView(Context context) {
        super(context);


    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        canvas.drawCircle(150,150,40,paint);
    }



}
