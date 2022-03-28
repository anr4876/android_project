package kr.ac.mokwon.ch004_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        LinearLayout lLayout = new LinearLayout(this);
        lLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                (0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        // 가중치 설적 LayoutParams (가로 세로 가중치)
        Button btn = new Button(this);
        btn.setText("button01");
        btn.setLayoutParams(params);
        lLayout.addView(btn);

        Button btn2 = new Button(this);
        btn2.setText("button02");
        btn2.setLayoutParams(params);
        lLayout.addView(btn2);

        setContentView(lLayout);
    }
}