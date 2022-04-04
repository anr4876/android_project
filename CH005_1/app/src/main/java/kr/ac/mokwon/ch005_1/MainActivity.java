package kr.ac.mokwon.ch005_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClickListner listener = new ClickListner();
        CheckBox box1 = findViewById(R.id.check1);
        CheckBox box2 = findViewById(R.id.check2);
        box1.setOnClickListener(listener);
        box2.setOnClickListener(listener);

    }



    class ClickListner implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            boolean checked = ((CheckBox)view).isChecked();
            switch (view.getId()){
                case R.id.check1:
                    Toast.makeText(getApplicationContext(),
                            ((CheckBox)view).getText()+":"+ checked,
                            Toast.LENGTH_SHORT).show();
                    break;
                case R.id.check2:
                    Toast.makeText(getApplicationContext(),
                    ((CheckBox)view).getText()+":"+checked,
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}