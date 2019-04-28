package com.kky.example.mevent.dbroom;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/7/25 16:07
 * @change time
 * @class describe
 */
@Database(entities = {UserInfo.class, UserInfoNd.class}, version = 2)
public abstract class UserDataBase extends RoomDatabase {
    private static volatile UserDataBase INSTANCE;

    public abstract UserDao userDao();
    public abstract UserNdDao ndDao();

    public static UserDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (UserDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserDataBase.class, "user_db").
                            build();
                }
            }
        }
        return INSTANCE;
    }
}
