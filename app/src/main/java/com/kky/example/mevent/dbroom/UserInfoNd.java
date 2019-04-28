package com.kky.example.mevent.dbroom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.databinding.BaseObservable;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/25 16:22
 * @change time
 * @class describe
 */
@Entity(tableName = "user_nd")
public class UserInfoNd {

    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    private String mId;
    @ColumnInfo(name = "user_name")
    private String mUserName;

    public UserInfoNd(String mId, String mUserName) {
        this.mId = mId;
        this.mUserName = mUserName;
    }

    @Ignore
    public UserInfoNd(String mUserName) {
        this.mUserName = mUserName;
        this.mId = UUID.randomUUID().toString();
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getUserName() {
        return mUserName;
    }
}
