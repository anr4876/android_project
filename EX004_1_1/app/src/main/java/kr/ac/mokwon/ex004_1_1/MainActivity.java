package kr.ac.mokwon.ex004_1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView txt;


    boolean isFirst; // true false 저장 변수
    int calcID;

    int number1;
    int number2;
    BtnListner BL;


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


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        // 가중치 설적 LayoutParams (가로 세로 가중치)

        Button[] btn = new Button[16];

        BL = new BtnListner();

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
                btn[qwe - 1].setOnClickListener(BL);
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

        calcID = 0;
        number1 = 0;
        number2 = 0;
        isFirst = true;

    }
    class BtnListner implements View.OnClickListener {
        void CalcNumber() {
            if(number2 == 0){
               return;
            }
            switch (calcID) { // switch()는 ()안의 값이 case옆의 값과 동일하면 실행
                case 1:
                    number1 += number2;
                    number2 = 0;
                    txt.setText(number1 + "");
                    break;
                case 2:
                    number1 -= number2;
                    number2 = 0;
                    txt.setText(number1 + "");
                    break;
                case 3:
                    number1 *= number2;
                    number2 = 0;
                    txt.setText(number1 + "");
                    break;
                case 4:
                    number1 /= number2;
                    number2 = 0;
                    txt.setText(number1 + "");
                    break;

            }
        }

            @Override
            public void onClick (View view){
                String str = ((Button) view).getText().toString();
                int sum;

                switch (str) {

                    case "+":
                        if (calcID > 0){
                            CalcNumber();
                        }
                        txt.setText(number1 + "");
                        calcID = 1;
                        isFirst = true;
                        break;
                    case "-":
                        if (calcID > 0){
                            CalcNumber();
                        }
                        txt.setText(number1 + "");
                        calcID = 2;
                        isFirst = true;
                        break;
                    case "×":
                        if (calcID > 0){
                            CalcNumber();
                        }
                        txt.setText(number1 + "");
                        calcID = 3;
                        isFirst = true;
                        break;
                    case "÷":
                        if (calcID > 0){
                            CalcNumber();
                        }
                        txt.setText(number1 + "");
                        calcID = 4;
                        isFirst = true;
                        break;
                    case "=": {
                        switch (calcID) { // switch()는 ()안의 값이 case옆의 값과 동일하면 실행
                            case 1:
                                sum = number1 + number2;
                                txt.setText(sum + "");
                                break;
                            case 2:
                                sum = number1 - number2;
                                txt.setText(sum + "");
                                break;
                            case 3:
                                sum = number1 * number2;
                                txt.setText(sum + "");
                                break;
                            case 4:
                                sum = number1 / number2;
                                txt.setText(sum + "");
                                break;

                        }


                        calcID = 0;
                        number1 = 0;
                        number2 = 0;
                        isFirst = true;

                        break;
                    }
                    default:
                        int number = Integer.parseInt(str);
                        if (calcID == 0) {
                            if (isFirst) {
                                number1 = number;
                                isFirst = false;
                            } else {
                                number1 *= 10;
                                number1 += number;
                            }
                            txt.setText(number1 + "");
                            break;
                        } else {
                            if (isFirst) {
                                number2 = number;
                                isFirst = false;
                            } else {
                                number2 *= 10;
                                number2 += number;
                            }
                            txt.setText(number2 + "");

                            break;
                        }

                }
            }
        }
    }
