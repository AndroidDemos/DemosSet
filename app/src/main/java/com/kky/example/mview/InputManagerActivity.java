package com.kky.example.mview;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.mevent.intent.AActivity;
import com.kky.example.util.LocalPrinter;
import com.kky.example.util.ToastUtils;
import com.kky.example.util.gson.JsHelp;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Map;
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
    RadioButton checkBox;
    CardView cardView;
    ImageView imageView3;
    Button button;
    Button button12;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_manager);
        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
        cardView = findViewById(R.id.card_view);
        imageView3 = findViewById(R.id.imageView3);
        button = findViewById(R.id.button10);
        button12 = findViewById(R.id.button12);

        printPaths();
        Timer timer = new Timer();
        Timer timer2 = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                InputMethodManager inputManager =
                        (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(editText, 0);
            }
        }, 200);
        timer2.schedule(new TimerTask() {
            public void run() {
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
        button.setOnClickListener(v -> {
            AActivity.Companion.start(this, 100);
        });
        button12.setOnClickListener(v -> {
            String mobile_n = "+86 13898741523";
            String trim = mobile_n.trim();
            LocalPrinter.printLocal("trim-" + trim);
            String replace = mobile_n.replace(" ", "");
            LocalPrinter.printLocal("replace-" + replace);
            String dataJson = "{\"rate\" : 1.0, \"extend\" : {\"number\" : 30, \"amount\" : 120.3}}";
            Map<String, Object> map = new JsHelp<Map<String, Object>>().gsonToMap(dataJson);
            for (String av : map.keySet()) {
                LocalPrinter.printLocal("key-" + av + map.get(av));
            }
            LocalPrinter.printLocal("--------");
            Map<String, Object> map2 = new JsHelp<Map<String, Object>>().gson2ToMap(dataJson);
            for (String av : map2.keySet()) {
                LocalPrinter.printLocal("key-" + av + "value-" + map2.get(av));
            }
        });
        editText.setFilters(new InputFilter[]{new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                return null;
            }
        }, new InputFilter.LengthFilter(5)});
        editText.setText("12345678910123333333");
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void printPaths() {
        String DOWNLOADS = this.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).toString();
        String ALARMS = this.getExternalFilesDir(Environment.DIRECTORY_ALARMS).toString();
        File PICTURES = this.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String MOVIES = this.getExternalFilesDir(Environment.DIRECTORY_MOVIES).toString();
        String DIRECTORY_DOCUMENTS = this.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).toString() + "/wers/";
        File DCIM = this.getExternalFilesDir(Environment.DIRECTORY_DCIM);
        if (DCIM.isDirectory()) {
            LocalPrinter.printLocal("isDirectory true");
        } else {
            LocalPrinter.printLocal("isDirectory false");
        }
        if (PICTURES.isDirectory()) {
            LocalPrinter.printLocal("PICTURES isDirectory true");
        } else {
            LocalPrinter.printLocal("PICTURES isDirectory false");
        }
        String hengGang = this.getExternalFilesDir("/").toString();
        LocalPrinter.printLocal(DOWNLOADS);
        LocalPrinter.printLocal(ALARMS);
        LocalPrinter.printLocal(PICTURES.toString());
        File dirDOCUMENTS = new File(DIRECTORY_DOCUMENTS);
        if (dirDOCUMENTS.isDirectory()) {
            LocalPrinter.printLocal("dirDOCUMENTS isDirectory true");
        } else {
            LocalPrinter.printLocal("dirDOCUMENTS isDirectory false");
            dirDOCUMENTS.mkdirs();
            LocalPrinter.printLocal("dirDOCUMENTS isDirectory 222--" + dirDOCUMENTS.isDirectory() + "===" + dirDOCUMENTS.getPath());
        }

        LocalPrinter.printLocal(dirDOCUMENTS.getPath());
        LocalPrinter.printLocal(DIRECTORY_DOCUMENTS);
        LocalPrinter.printLocal(DCIM.toString());
        LocalPrinter.printLocal(hengGang);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @androidx.annotation.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                String data1 = data.getStringExtra("data");
                ToastUtils.makeText(data1);
                finish();
            }
        }
    }

    private Drawable wrappedDrawable(Drawable drawable, ColorStateList colors) {
        Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }
}

