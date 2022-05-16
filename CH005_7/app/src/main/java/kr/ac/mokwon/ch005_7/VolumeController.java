package kr.ac.mokwon.ch005_7;

import android.content.AttributionSource;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class VolumeController extends AppCompatImageView {
    float _mX, _mY;
    float _angle;
    float _dAngle;
    KnobListener listener;
    public interface KnobListener{
        public void OnCheange(float angle);
    }
    public void setKnobChangeListener(KnobListener listener){
        this.listener = listener;
    }

    public VolumeController(@NonNull Context context) {
        super(context);
        setImageResource(R.drawable.button_img);
    }

    public VolumeController(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setImageResource(R.drawable.button_img);
    }


    float GetAngle(float x, float y){ // 돌린 각도 계산 함수
        _mX = x - (getWidth()/2.0f);
        _mY = (getWidth()/2.0f) - y;
        _dAngle = (float)(Math.atan2(_mX, _mY) * 180/Math.PI); // tanθ 계산해주는 함수
        return _dAngle;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        _angle = GetAngle(event.getX(), event.getY()); // 터치했을때의 y x 값
        invalidate();
        listener.OnCheange(_angle);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.rotate(_angle, getWidth()/2.0f, getHeight()/2.0f);
        super.onDraw(canvas);
    }
}
