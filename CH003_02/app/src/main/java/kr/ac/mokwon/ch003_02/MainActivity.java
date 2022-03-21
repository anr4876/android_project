package kr.ac.mokwon.ch003_02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView1 = findViewById(R.id.txto1);
        TextView textView2 = findViewById(R.id.txto2);
        TextView textView3 = findViewById(R.id.txto3);
        textView1.setText("코드에서 바꿈!!");
        textView2.setTextSize(30);
        textView3.setTextSize(30);
        textView3.setTextColor(Color.BLUE);
        textView3.setTypeface(Typeface.SERIF,Typeface.ITALIC);
    }
}