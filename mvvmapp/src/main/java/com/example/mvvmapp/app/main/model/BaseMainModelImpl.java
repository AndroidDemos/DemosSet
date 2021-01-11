package com.example.mvvmapp.app.main.model;

import com.example.mvvmapp.app.main.logic.MainDataInterface;
import com.example.mvvmapp.bean.User;

/**
 * Author: Zeus
 * Date: 2020/7/13 18:26
 * Description:
 * History:
 */
public class BaseMainModelImpl implements BaseMainModel {

    @Override
    public void getName(int i, MainDataInterface dataInterface) {
        User user = new User();
        if (i == 1) {
            user.setName("Jay");
            user.setLastName("Pirate");
        } else {
            user.setName("fantasyGirl");
            user.setLastName("Beauty");
        }
        dataInterface.success(user);
    }

    @Override
    public void getAge(int i, MainDataInterface dataInterface) {
        User user = new User();
        if (i == 1) {
            user.setName("Jay");
            user.setLastName("Pirate");
        } else {
            user.setName("fantasyGirl");
            user.setLastName("Beauty");
        }
        dataInterface.success(user);
    }
}
