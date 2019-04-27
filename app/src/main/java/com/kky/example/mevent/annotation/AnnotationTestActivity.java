package com.kky.example.mevent.annotation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;

import org.jetbrains.annotations.Nullable;

/*
 * @author Zeus
 * create at 2019/1/14 16:44
 * modify at 2019/1/14 16:44
 * modify because
 * description: TO FIT
 */
public class AnnotationTestActivity extends BaseActivity implements View.OnClickListener {
    TextView tvShow;
    Button btSimple;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation_test);
        initView();
    }

    private void initView() {
        tvShow = findViewById(R.id.tv_show);
        btSimple = findViewById(R.id.bt_simple);
        btSimple.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_simple:
                Member member = new Member();
                member.method();
                break;
        }
    }
}
