package com.example.mvvmapp.app.main.logic;

import com.example.mvvmapp.bean.User;

/**
 * Author: Zeus
 * Date: 2020/7/13 18:32
 * Description:
 * History:
 */
public interface MainDataInterface {
    /*返回数据成功*/
    void success(User user);

    /*返回数据失败*/
    void error(String message);

    /*返回数据完成*/
    void complete();
}
