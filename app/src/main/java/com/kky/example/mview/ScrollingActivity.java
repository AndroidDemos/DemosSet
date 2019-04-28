package com.kky.example.mview;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import com.kky.example.R;
import com.kky.example.bean.PieData;
import com.kky.example.widget.PieView;
import com.kky.example.widget.canvas.CheckView;

import java.util.ArrayList;

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {
    private PieView pieView;
    private CheckView checkView;
    private Button btCheck, btUncheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        pieView = findViewById(R.id.v_pie);
        checkView = findViewById(R.id.v_check);
        btCheck = findViewById(R.id.bt_check);
        btUncheck = findViewById(R.id.bt_uncheck);
        pieView.setStartAngle(30);
        ArrayList<PieData> pieData = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int value = i > 0 ? i + 2 : i + 1;
            PieData data = new PieData("Ye", value);
            pieData.add(data);
        }
        pieView.setData(pieData);
        checkView.setBackgroundColor(0xFF5317);
        btUncheck.setOnClickListener(this);
        btCheck.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_uncheck:
                checkView.unCheck();
                break;
            case R.id.bt_check:
                checkView.check();
                break;
        }
    }
}
