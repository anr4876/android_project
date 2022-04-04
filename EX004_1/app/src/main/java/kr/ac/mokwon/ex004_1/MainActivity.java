package kr.ac.mokwon.ex004_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    String str;
    BtnListner BL;
    String kk = "";
    double[] num = {0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        LinearLayout lLayout = new LinearLayout(this);
        lLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout lLayout1 = new LinearLayout(this);
        lLayout1.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout lLayout2 = new LinearLayout(this);
        lLayout2.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout lLayout3 = new LinearLayout(this);
        lLayout3.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout lLayout4 = new LinearLayout(this);
        lLayout4.setOrientation(LinearLayout.HORIZONTAL);

        BL = new BtnListner();

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        // 가중치 설적 LayoutParams (가로 세로 가중치)

        Button[] btn = new Button[16];


        txt = new TextView(this);
        txt.setText("0");
        txt.setLayoutParams(new LinearLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        lLayout.addView(txt);

        String[] key = {"7", "8", "8", "+", // 버튼 txt값
                        "4", "5", "6", "-",
                        "1", "2", "3", "×",
                        " ", "0", "=", "÷"};


        for (int x = 0; x < 4; x++) { // 한번에 버튼 16개 생성
            for (int j = 1; j <= 4; j++) {
                int qwe = (x * 4) + j;
                btn[qwe - 1] = new Button(this); // 현재 만들고있는 액티비티에 버튼을 생성한다고 명령
                btn[qwe - 1].setText(key[qwe - 1]);
                btn[qwe - 1].setLayoutParams(params); // 각 구간에 일정한 비율로 공간 할당
                btn[qwe - 1].setOnClickListener(BL); // 버튼 클릭시 BtnListner 클래스 실행
                if (x == 0) {
                    lLayout1.addView(btn[qwe - 1]); // 1번째 줄 공간 할당
                } else if (x == 1) {
                    lLayout2.addView(btn[qwe - 1]); // 2번째 줄 공간 할당
                } else if (x == 2) {
                    lLayout3.addView(btn[qwe - 1]); // 3번째 줄 공간 할당
                } else {
                    lLayout4.addView(btn[qwe - 1]); // 4번째 줄 공간 할당
                }
            }
        }
        btn[12].setVisibility(View.INVISIBLE); // 12번 버튼 존재는하지만 안보이게함

        lLayout.addView(lLayout1); // 각 버튼 위치 지정
        lLayout.addView(lLayout2);
        lLayout.addView(lLayout3);
        lLayout.addView(lLayout4);


        setContentView(lLayout); // 버튼이 화면에 출력해주는 코드


    }

    class BtnListner implements View.OnClickListener {
        Operation op1 = new Operation();

        @Override
        public void onClick(View view) { // 버튼 클릭시 실행
            str = ((Button) view).getText().toString();
            try{ // try{}안이 실행불가하면 catch로 넘어감
                double a = Double.parseDouble(str); // 계산 결과가 소수가 가능함
                num[0] = (10*num[0]) + a; // 전에 사용했던 숫자는 *10을 통해서 자리를 바꿔줌
                txt.setText(num[0] + ""); // num을 txt에 출력
            }catch(Exception e){
                if (str == "+"){ // + 버튼 누르면 실행
                    op1.oper(); // Operation 클래스의 oper() 실행
                    kk = "+"; // 연산자 + 를 기억
                }
                else if (str == "-"){ // - 버튼 누르면 실행
                    op1.oper();
                    kk = "-"; // 연산자 - 를 기억
                }
                else if (str == "×"){ // × 버튼 누르면 실행
                    op1.oper();
                    kk = "×"; // 연산자 × 를 기억
                }
                else if (str == "÷"){ // ÷ 버튼 누르면 실행
                    op1.oper();
                    kk = "÷"; // 연산자 ÷ 를 기억
                }
                else{                   // = 버튼 누르면 실행
                    op1.oper();
                    if(num[1] != 0 )txt.setText(num[1] + "");
                    num[1] = 0; // 모든 계산이 끝났으므로 num[1],num[0],kk 값 초기화
                    num[0] = 0;
                    kk = "";
                }
                if(num[1] != 0 )txt.setText(num[1] + ""); // num[1] 중간 계산 출력 코드
            }
        }
    }
    class Operation{
        public void oper() { // 버튼에따라 사용하는 연산자를 적용해주는 클래스

            switch (kk) { // switch()는 ()안의 값이 case옆의 값과 동일하면 실행
                case "+" :
                    num[1] += num[0];
                    num[0] = 0;
                    break;
                case "-":
                    num[1] -= num[0];
                    num[0] = 0;
                    break;
                case "×":
                    num[1] *= num[0];
                    num[0] = 0;
                    break;
                case "÷":
                    num[1] /= num[0];
                    num[0] = 0;
                    break;
                default:
                    num[1] = num[0];
                    num[0] = 0;
            }
        }
    }
}
