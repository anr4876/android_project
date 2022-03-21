package kr.ac.mokwon.ex003_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn;
    ImageView img;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn1);
        img = findViewById(R.id.f1);
        edit = findViewById(R.id.edit01);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String k = edit.getText().toString();
                try {
                    int a = Integer.parseInt(k);
                    img.setRotation(a);
                }catch (Exception e){
                    // str{}catch() = {}안이 실행이 불가하면  catch로 실행
                    // toString() = 문자열로 값 받아오기
                    // Integet.parseInt = 정수형으로 형 변환

                }



            }
        });


    }
}