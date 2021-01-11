package com.example.mvvmapp.app.main

import android.os.Bundle
import android.view.View
import com.example.mvvmapp.R
import com.example.mvvmapp.app.main.vm.MainViewModelImpl
import com.example.mvvmapp.base.BaseActivity
import com.example.mvvmapp.bean.User
import com.example.mvvmapp.databinding.ActivityMainBinding
import com.example.mvvmapp.mvvm.IBaseView

class MainActivity : BaseActivity<ActivityMainBinding>(), IBaseView<User> {
    private lateinit var mMainViewModel: MainViewModelImpl
    var user = User()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
    }

    override fun loadData() {
        mMainViewModel = MainViewModelImpl()
        mMainViewModel.attachView(this)
        mMainViewModel.refresh()
    }

    override fun showError() {

    }

    override fun showSuccess(arg: User) {
        user = arg
        mDataBinding.us = user
    }

    public fun onGetData(view: View) {
        mMainViewModel.loadMore()
    }

    override fun showLoading() {
    }

    override fun complete() {
    }
}
