package kr.ac.mokwon.suti_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class SubActivity extends MainActivity{
    MySurFaceView _MyBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);
        _MyBox = findViewById(R.id.view);
        Button btn_left = findViewById(R.id.left_button);
        Button btn_right = findViewById(R.id.right_button);
        Button btn_r = findViewById(R.id.retur);


        btn_r.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Intent intent = new Intent(SubActivity.this, PopupActivity.class);
                startActivity(intent); // 스레드에서 ui 호출방법 찾기
                return false;
            }
        });

        btn_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        _MyBox.MoveOn(-6, 0);

                        break;

                    case MotionEvent.ACTION_UP:
                        _MyBox.MoveOff();
                        break;
                }
                return false;
            }
        });
        btn_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        _MyBox.MoveOn(6, 0);

                        break;
                    case MotionEvent.ACTION_UP:
                        _MyBox.MoveOff();
                        break;
                }
                return false;
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_LEFT:
                _MyBox.MoveOn(-6, 0);
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                _MyBox.MoveOn(6,0);
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                _MyBox.MoveOff();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }
}
