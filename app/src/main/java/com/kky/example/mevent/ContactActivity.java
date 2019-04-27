package com.kky.example.mevent;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;

import org.jetbrains.annotations.Nullable;

/*
 * @author Zeus
 * create at 2019/1/22 10:36
 * modify at 2019/1/22 10:36
 * modify because
 * description: TO FIT
 */
public class ContactActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initData();
    }

    private void initData() {
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI,null,ContactsContract.PhoneLookup.DISPLAY_NAME+"=?",new String[]{"11"},null);
        Log.i(getTAG(),"----cursor----"+cursor);

    }
}
