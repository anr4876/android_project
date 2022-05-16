package kr.ac.mokwon.ch005_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView  textView;
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ToggleButton toggle1 = findViewById(R.id.toggle);
        textView = findViewById(R.id.txt);
        ratingBar = findViewById(R.id.rating);

        toggle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    boolean checked = ((ToggleButton)view).isChecked();
                    Toast.makeText(getApplicationContext(), "선택 : "+checked,
                            Toast.LENGTH_SHORT).show();
                    float rating = ratingBar.getRating();
                textView.setText("별점 : " + rating);
            }
        });


    }
}