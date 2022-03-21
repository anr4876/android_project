package kr.ac.mokwon.ex003_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = findViewById(R.id.txt01);
        ImageButton btn1 = findViewById(R.id.btn01);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                int i = (int)(Math.random()*6 + 1);
                String txt = i + "";

                txt1.setText(txt);
            }

        });


    }
}