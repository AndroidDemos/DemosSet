package com.example.mvvmapp.app.main.vm;

import android.view.View;

import com.example.mvvmapp.app.main.MainActivity;
import com.example.mvvmapp.app.main.logic.MainDataInterface;
import com.example.mvvmapp.app.main.model.BaseMainModelImpl;
import com.example.mvvmapp.bean.User;
import com.example.mvvmapp.mvvm.BaseVM;

/**
 * Author: Zeus
 * Date: 2020/7/13 18:16
 * Description:
 * History:
 */
public class MainViewModelImpl extends BaseVM<MainActivity> implements BaseMainVM, MainDataInterface {

    private BaseMainModelImpl mMainModel;

    public MainViewModelImpl() {
        this.mMainModel = new BaseMainModelImpl();
    }

    @Override
    public void refresh() {
        mMainModel.getAge(1, this);
    }

    @Override
    public void loadMore() {
        mMainModel.getAge(2, this);
    }

    @Override
    public void success(User user) {
        getIView().showSuccess(user);
    }

    public void reGetData(View view) {
        mMainModel.getAge(2, this);
    }

    @Override
    public void error(String message) {

    }

    @Override
    public void complete() {

    }


}
