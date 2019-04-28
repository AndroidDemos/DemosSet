package com.kky.example.mevent.dbroom;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.databinding.ActivityRoom2Binding;
import com.kky.example.util.ToastUtils;

import org.jetbrains.annotations.Nullable;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/25 15:58
 * @change time
 * @class describe 利用databinding
 */
public class RoomActivity2 extends BaseActivity {
    private final CompositeDisposable disposable = new CompositeDisposable();
    private EditText editText;
    private Button button;
    UserDataBase dataBase;
    UserNdDao userDao;
    Flowable<UserInfoNd> user;
    UserInfoNd userInfo;
    ActivityRoom2Binding dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_room2);

        editText = findViewById(R.id.et_name);
        button = findViewById(R.id.bt_commit);
        dataBase = UserDataBase.getInstance(RoomActivity2.this);
        userDao = dataBase.ndDao();
    }

    @Override
    protected void onStart() {
        super.onStart();
        user = userDao.getUser();
        disposable.add(user.subscribe(userInfo -> {
            this.userInfo = userInfo;
            dataBinding.setUser(userInfo);
            editText.setText(userInfo.getUserName());
        }, throwable -> {

        }));

        button.setOnClickListener(v -> update());
    }

    private void update() {
        button.setEnabled(false);
        Editable text = editText.getText();
        if (!TextUtils.isEmpty(text)) {
            Completable completable = Completable.fromAction(() -> setUser(text));
            disposable.add(completable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
                        button.setEnabled(true);
                    }, throwable ->
                            Log.e("exception", "Unable to update username", throwable)
            ));
        }
    }

    private void setUser(Editable text) {
        userDao.insertUser(userInfo == null ? new UserInfoNd(text.toString()) : new UserInfoNd(userInfo.getId(), text.toString()));
        userInfo.setUserName(text.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
