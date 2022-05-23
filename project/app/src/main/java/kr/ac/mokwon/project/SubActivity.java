package kr.ac.mokwon.project;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);  // 이것만 하면 실행 불가 manifests 들어가서
        // <activity android:name=".SubActivity"/> 작성해야 실행
    }
}
