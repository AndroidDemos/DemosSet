package com.kky.example.mevent.d2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;

import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

/*
 * @author Zeus
 * create at 2019/1/14 17:06
 * modify at 2019/1/14 17:06
 * modify because
 * description: dagger 入门
 */
public class D2Simple1Activity extends BaseActivity implements View.OnClickListener {
    private Button bt1, bt2;
    private TextView tv1;

    @Inject
    A a;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d2_simple1);
        initView();
    }

    private void initView() {
        MainComponent component = DaggerMainComponent.builder().build();
        component.activityInject(this);
        bt1 = findViewById(R.id.button1);
        bt2 = findViewById(R.id.button2);
        tv1 = findViewById(R.id.textView1);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                String xxoo = a.xxoo();
                setTv1(xxoo);
                break;
            case R.id.button2:
                String appointment = a.appointment();
                setTv1(appointment);
                break;
        }
    }

    private void setTv1(String s) {
        tv1.setText(s);
    }


}
