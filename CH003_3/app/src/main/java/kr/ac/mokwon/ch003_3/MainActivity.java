package kr.ac.mokwon.ch003_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton iBtn1 = findViewById(R.id.btn01); // 버튼 생성
        ImageButton iBtn2 = findViewById(R.id.btn02);
        ImageView img1 = findViewById(R.id.img01); // 이미지 생성
        iBtn1.setOnClickListener(new View.OnClickListener(){
        // 버튼1 클릭시 나타나는 효과
            @Override
            public void onClick(View view) { // drawable에 있는 flower이미지 보여주기
                img1.setImageResource(R.drawable.flower);
            }
        });
        iBtn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) { // drawable에 있는 flower2이미지 보여주기
                img1.setImageResource(R.drawable.flower2);
            }
        });

    }
}