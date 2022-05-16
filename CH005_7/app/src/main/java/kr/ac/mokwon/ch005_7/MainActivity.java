package kr.ac.mokwon.ch005_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // VolumeController controller = new VolumeController(this);
        // setContentView(controller);
    text = findViewById(R.id.txt);
    VolumeController volume = findViewById(R.id.volume);
    volume.setKnobChangeListener(new VolumeController.KnobListener() {
        @Override
        public void OnCheange(float angle) {
            text.setText(angle+"");
        }
    });
    }
}