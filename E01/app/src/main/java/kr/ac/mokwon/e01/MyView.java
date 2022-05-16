package kr.ac.mokwon.e01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class MyView extends View {
    Paint paint;
    Path path;

    public MyView(Context context)  {
        super(context);
        paint = new Paint();



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.BLUE);

        canvas.drawRect(50,150,180,300,paint);

        paint.setColor(0x964b0000); // 삼각형 path
        canvas.drawRect(230,100,270,300,paint);
        paint.setColor(Color.GREEN);
        canvas.drawCircle(230,100,30,paint);
        canvas.drawCircle(270,100,30,paint);
        canvas.drawCircle(250, 70,30,paint);


        canvas.drawRect(85,200,110,225,paint);
        canvas.drawRect(120,200,145,225,paint);
        canvas.drawRect(85,235,110,260,paint);
        canvas.drawRect(120,235,145,260,paint);
        paint.setColor(Color.RED);






    }




}
