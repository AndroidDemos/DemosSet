package com.kky.example.mevent.dbroom;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;

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
 * @class describe
 */
public class RoomActivity extends BaseActivity {
    private final CompositeDisposable disposable = new CompositeDisposable();
    private TextView textView;
    private EditText editText;
    private Button button;
    UserDataBase dataBase;
    UserDao userDao;
    Flowable<UserInfo> user;
    UserInfo userInfo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        textView = findViewById(R.id.tv_mame);
        editText = findViewById(R.id.et_name);
        button = findViewById(R.id.bt_commit);
        dataBase = UserDataBase.getInstance(RoomActivity.this);
        userDao = dataBase.userDao();
    }

    @Override
    protected void onStart() {
        super.onStart();
        user = userDao.getUser();
        disposable.add(user.subscribe(userInfo -> {
            this.userInfo = userInfo;
            textView.setText(userInfo.getUserName());
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
                textView.setText(text.toString());
                button.setEnabled(true);
            }, throwable ->
                Log.e("exception", "Unable to update username", throwable)
            ));
        }
    }

    private void setUser(Editable text) {
        userDao.insertUser(userInfo==null?new UserInfo(text.toString()):new UserInfo(userInfo.getId(),text.toString()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
