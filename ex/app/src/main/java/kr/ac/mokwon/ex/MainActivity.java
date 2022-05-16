package kr.ac.mokwon.ex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MySurFaceView _view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _view = findViewById(R.id.view);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        btn1.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        _view.MoveOn(-1,0);
                        break;
                    case MotionEvent.ACTION_UP:
                        _view.MoveOff();
                        break;
                }
                return false;
            }
        });
        btn2.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        _view.MoveOn(1,0);
                        break;
                    case MotionEvent.ACTION_UP:
                        _view.MoveOff();
                        break;
                }
                return false;
            }
        });
    }
}