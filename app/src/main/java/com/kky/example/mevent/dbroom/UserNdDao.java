package com.kky.example.mevent.dbroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import io.reactivex.Flowable;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/25 16:26
 * @change time
 * @class describe
 */
@Dao
public interface UserNdDao {

    @Query("SELECT * FROM USER_ND LIMIT 1")
    Flowable<UserInfoNd> getUser();

    @Query("DELETE FROM USER_ND")
    void deleteAllUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserInfoNd userInfoNd);
}
