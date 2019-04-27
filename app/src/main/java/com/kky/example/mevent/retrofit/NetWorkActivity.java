package com.kky.example.mevent.retrofit;

import android.os.Bundle;
import android.util.Log;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.bean.LoginOrRegisterBean;
import com.kky.example.bean.LoginOrRegisterData;
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
        bean.setCode("3232");
        bean.setCode("3232");
        bean.setCode("3232");
        bean.setCode("3232");
        Observable<Response<LoginOrRegisterData>> observable = NetWorkManager.getRequest()
                .getList(bean);

        Disposable dissposable = observable.compose(ResponseTransformer.handleResult())
                .compose(SchedulerProvider.getInstance().applySchedulers())
                .subscribe(cardBeans -> {
                    Log.e("card-size", cardBeans.getAccountVO() + "account?");
                }, throwable -> {
                    Log.e("card-size", "error" + throwable.getMessage());
                    if(throwable instanceof ApiException){
                        ApiException apiException = (ApiException) throwable;
                        ToastUtils.makeText(apiException.getDisplayMessage());
                    }
                });
        mDisposable.add(dissposable);
    }
}
