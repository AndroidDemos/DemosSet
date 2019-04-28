package com.kky.example.mview;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import android.view.View;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.widget.FullSheetDialogFragment;

import org.jetbrains.annotations.Nullable;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/6/27 17:42
 * @change time
 * @class describe
 */
public class BottomSheetActivity extends BaseActivity {
    BottomSheetBehavior behavior;
    BottomSheetBehavior behavior1;
    View view;
    BottomSheetDialog mBottomSheetDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);

        View bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);

        view = getLayoutInflater().inflate(R.layout.dialog_bottom_sheet, null);
//        ((ViewGroup) view.getParent()).removeView(view);
        mBottomSheetDialog = new BottomSheetDialog(this);
        mBottomSheetDialog.setContentView(view);
//        behavior1 = BottomSheetBehavior.from((View) view.getParent());

        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //这里是bottomSheet 状态的改变
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
            }
        });
//        behavior1.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                //这里是bottomSheet 状态的改变
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                //这里是拖拽中的回调，根据slideOffset可以做一些动画
//            }
//        });
        mBottomSheetDialog.show();


    }

    public void doclick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                break;
            case R.id.button1:

                break;
            case R.id.button2:
                new FullSheetDialogFragment().show(getSupportFragmentManager(), "dialog");
                break;
        }
    }
}
