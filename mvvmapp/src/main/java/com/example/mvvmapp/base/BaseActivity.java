package com.example.mvvmapp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Author: Zeus
 * Date: 2020/7/13 17:07
 * Description:
 * History:
 */
public abstract class BaseActivity<D_T> extends AppCompatActivity {
    protected D_T mDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding viewDataBinding = DataBindingUtil.setContentView(this, getLayoutID());
        this.mDataBinding = (D_T) viewDataBinding;
        initData();
        loadData();
    }

    protected abstract void initData();

    protected abstract void loadData();

    protected abstract int getLayoutID();
}
