package com.kky.example.mui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.kky.example.R;

public class LeftMenuActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_left_menu);
        toggleButton = findViewById(R.id.toogle_open);
        imageView = findViewById(R.id.imageView2);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                imageView.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });
    }


}
