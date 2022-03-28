package kr.ac.mokwon.ex003_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    EditText edit1;
    TextView txt1;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn01); // 시작 버튼
        btn2 = findViewById(R.id.btn02); // 정답 버튼
        btn3 = findViewById(R.id.btn03); // 확인 버튼
        txt1 = findViewById(R.id.txt01); // txt 버튼
        edit1 = findViewById(R.id.edit01); // edittext 버튼

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = (int)(Math.random()*100 + 1);
                txt1.setText("게임이 시작되었습니다. \n " +
                        "숫자를 입력하고 정답 제출을 눌러주세요.");

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String k = edit1.getText().toString(); // getText는 오브젝트를 받아온다 오브젝트는 문자형보다 큰 타입이다
                try {
                    int a = Integer.parseInt(k);
                    if (i < a){
                        txt1.setText("입력하신 숫자보다 작습니다.");
                    }
                    else if (i > a){
                        txt1.setText("입력하신 숫자보다 큽니다.");
                    }
                    else {
                        txt1.setText("정답입니다.");
                    }
                }catch (Exception e){
                    // try{}catch() = {}안이 실행이 불가하면  catch로 실행
                    // toString() = 문자열로 값 받아오기
                    // Integet.parseInt = 정수형으로 형 변환
                    txt1.setText("다시 입력하세요(숫자만 입력 가능)");
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt1.setText(i + "");
            } // 문자 + "" 문자에 ""를 씌워준다.
        });
    }
}