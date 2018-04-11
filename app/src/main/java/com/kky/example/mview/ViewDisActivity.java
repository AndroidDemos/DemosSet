package com.kky.example.mview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.base.fragment.BaseFragment;

import org.jetbrains.annotations.Nullable;

public class ViewDisActivity extends BaseActivity {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public ViewDisActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dis);
        Log.d(this.getTAG(),"onCreate");
    }
}
