package com.kky.example.mview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;

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
public class InputManagerActivity extends BaseActivity {
    EditText editText;
    CheckBox checkBox;
    CardView cardView;
    ImageView imageView3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_manager);
        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
        cardView = findViewById(R.id.card_view);
        imageView3 = findViewById(R.id.imageView3);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                InputMethodManager inputManager =
                        (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(editText, 0);
            }
        }, 200);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editText.setTransformationMethod(isChecked ? HideReturnsTransformationMethod.getInstance() :
                        PasswordTransformationMethod.getInstance());

//                cardView.setForeground(new ColorDrawable(getResources().getColor(isChecked ? R.color.success_color :
//                        R.color.success_color)));
                cardView.setUseCompatPadding(isChecked);

                Drawable drawable = getResources().getDrawable(R.drawable.icon_remittance_record);
                if (isChecked) {
                    imageView3.setColorFilter(getResources().getColor(R.color.red));
                } else {
                    imageView3.setColorFilter(getResources().getColor(R.color.color_87d4a7));
                }
            }
        });
    }

    private Drawable wrappedDrawable(Drawable drawable, ColorStateList colors) {
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }
}

