package com.kky.example.mview;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;

import org.jetbrains.annotations.Nullable;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/5/2 22:16
 * @change time
 * @class describe
 */
public class KeyBoardActivity extends BaseActivity {
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_board);
        editText = findViewById(R.id.editText);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                InputMethodManager inputManager = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(editText, 0);
            }
        }, 200);

    }
}
