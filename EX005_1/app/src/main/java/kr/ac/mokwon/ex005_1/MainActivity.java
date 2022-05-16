package kr.ac.mokwon.ex005_1;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

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

        VolumeController volume = findViewById(R.id.volume);
        volume.setKnobChangeListener(new VolumeController.KnobListener() {
            @Override
            public void OnCheange(float angle) {
                textView.setText(angle+"");
                if(0 <= angle){
                    ratingBar.setRating(angle/60);
                }
                else {
                    ratingBar.setRating((360 + angle)/60);
                }
            }
        });



    }
}