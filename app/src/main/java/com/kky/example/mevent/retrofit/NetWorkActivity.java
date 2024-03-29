package com.kky.example.mevent.retrofit;

import android.os.Bundle;
import android.util.Log;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.bean.AccountVOBean;
import com.kky.example.bean.LoginOrRegisterBean;
import com.kky.example.bean.LoginOrRegisterData;
import com.kky.example.bean.UserVOBean;
import com.kky.example.libnet.ApiException;
import com.kky.example.libnet.NetWorkManager;
import com.kky.example.libnet.Response;
import com.kky.example.libnet.ResponseTransformer;
import com.kky.example.libnet.SchedulerProvider;
import com.kky.example.util.ToastUtils;

import org.jetbrains.annotations.Nullable;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/*
 * @author Zeus
 * create at 2019/1/15 17:12
 * modify at 2019/1/15 17:12
 * modify because
 * description: TO FIT
 */
public class NetWorkActivity extends BaseActivity {
    private CompositeDisposable mDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        mDisposable = new CompositeDisposable();

        LoginOrRegisterBean bean = new LoginOrRegisterBean();
        //{"code":"787978","deviceId":"ab6d3006286ee432","deviceName":"aosp","mobile":"639444494444","mobilePrefix":"63","version":"20200721"}
        bean.setCode("789789");
        bean.setDeviceId("ab6d3006286ee432");
        bean.setDeviceName("aosp");
        bean.setMobile("639444494444");
        bean.setMobilePrefix("63");
        bean.setVersion("20200721");
        Observable<Response<LoginOrRegisterData>> observable = NetWorkManager.getRequest()
                .getList(bean);

        Disposable dissposable = observable.compose(ResponseTransformer.handleResult())
                .compose(SchedulerProvider.getInstance().applySchedulers())
                .subscribe(loginOrRegisterData -> {
                    AccountVOBean accountVO = loginOrRegisterData.getAccountVO();
                    Log.e("login-or", accountVO + "account?" + accountVO.getReceiptCodeUrl());
                    UserVOBean userVO = loginOrRegisterData.getUserVO();
                    Log.e("login-or", userVO + "userVO?" + userVO.getEmail());
                }, throwable -> {
                    Log.e("login-or", "error" + throwable.getMessage());
                    if (throwable instanceof ApiException) {
                        ApiException apiException = (ApiException) throwable;
                        ToastUtils.makeText(apiException.getDisplayMessage());
                    }
                });
        mDisposable.add(dissposable);
    }
}
