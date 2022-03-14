package kr.ac.mokwon.ch003_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

//   public void onClick(View view) {
////        Toast.makeText(getApplicationContext(),"버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
////    } @Override


    @Override  // 상속받은 클래스를 잘 이용하는지 확인해준다.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  // super 부모 호출
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn01);

//        //내부 클래스 사용 예시
//        ButtonListener bl = new ButtonListener();
//        btn1.setOnClickListener(bl);

//        //무명 클래스 사용 예시 가장 많이 사용
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "내부 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
//            }
//        });    // 버튼이 많으면 코드가 길어지는 단점이있다.


        // 람다식 버튼 예시
        btn1.setOnClickListener(view-> {
            Toast.makeText(getApplicationContext(),"람다식 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
        });

    }

    class ButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"내부 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
        }
    } // 클래스 사용
}

