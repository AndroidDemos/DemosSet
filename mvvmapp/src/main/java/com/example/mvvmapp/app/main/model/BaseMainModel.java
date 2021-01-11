package com.example.mvvmapp.app.main.model;

import com.example.mvvmapp.app.main.logic.MainDataInterface;

/**
 * Author: Zeus
 * Date: 2020/7/13 18:24
 * Description:
 * History:
 */
public interface BaseMainModel {
    void getName(int i, MainDataInterface dataInterface);

    void getAge(int i, MainDataInterface dataInterface);
}
