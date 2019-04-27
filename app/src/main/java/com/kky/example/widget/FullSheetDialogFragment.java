package com.kky.example.widget;

import android.app.Dialog;
import android.os.Bundle;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import android.view.View;

import com.kky.example.R;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/6/27 19:16
 * @change time
 * @class describe
 */
public class FullSheetDialogFragment extends BottomSheetDialogFragment {
    private BottomSheetBehavior mBehavior;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.dialog_bottom_sheet, null);
        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        view.findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAction();
            }
        });
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);//全屏展开
    }

    private void setAction() {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}
