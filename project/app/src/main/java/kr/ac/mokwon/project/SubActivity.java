package kr.ac.mokwon.project;

import static android.view.KeyEvent.KEYCODE_DPAD_DOWN;
import static android.view.KeyEvent.KEYCODE_DPAD_LEFT;
import static android.view.KeyEvent.KEYCODE_DPAD_RIGHT;
import static android.view.KeyEvent.KEYCODE_DPAD_UP;
import static android.view.KeyEvent.KEYCODE_UNKNOWN;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SubActivity extends MainActivity {
    MySurFaceView _MyBox;
    Button btn_r;
    Button btn_left;
    Button btn_right;
    Button btn_down;
    Button btn_up;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_play);  // 이것만 하면 실행 불가 manifests 들어가서
        // <activity android:name=".SubActivity"/> 작성해야 실행
        _MyBox =findViewById(R.id.view);


        btn_left = findViewById(R.id.left_button);
        btn_right = findViewById(R.id.right_button);
        btn_down = findViewById(R.id.down_button);
        btn_up = findViewById(R.id.up_button);
        btn_r = findViewById(R.id.retur);



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
        btn_up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        _MyBox.MoveOn(0, -6);

                        break;
                    case MotionEvent.ACTION_UP:
                        _MyBox.MoveOff();
                        break;
                }
                return false;
            }
        });
        btn_down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:


                        _MyBox.MoveOn(0, 6);

                        break;
                    case MotionEvent.ACTION_UP:


                        _MyBox.MoveOff();
                        break;
                }
                return false;
            }
        });


    }



}
