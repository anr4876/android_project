package kr.ac.mokwon.suti_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start_btn = findViewById(R.id.game_start);


        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 버튼 클릭시 다른 레이아웃으로 화면 전환
                Intent intent = new Intent(MainActivity.this, ExplanationActivity.class);
                startActivity(intent);


            }

        });

    }

}