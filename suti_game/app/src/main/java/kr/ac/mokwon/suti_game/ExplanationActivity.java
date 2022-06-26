package kr.ac.mokwon.suti_game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ExplanationActivity extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explanation);

        Button start_btn = findViewById(R.id.game_start3);


        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 버튼 클릭시 다른 레이아웃으로 화면 전환
                Intent intent = new Intent(ExplanationActivity.this, SubActivity.class);
                startActivity(intent);


            }

        });

    }
}
