package kr.ac.mokwon.e01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        LinearLayout lLayout = new LinearLayout(this);
        lLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout lLayout1 = new LinearLayout(this);
        lLayout1.setOrientation(LinearLayout.HORIZONTAL);

        MyView vview = new MyView(this);
        // setContentView(view);
        vview.layout(10,10,230,230);
        Button btn1 = new Button(this);
        Button btn2 = new Button(this);



        lLayout.addView(vview);
        lLayout1.addView(btn1);
        lLayout1.addView(btn2);
        lLayout.addView(lLayout1);
        setContentView(lLayout);


    }


}