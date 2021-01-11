package com.example.mvvmapp.mvvm

import com.example.mvvmapp.bean.User

/**
 * Author: Zeus
 * Date: 2020/7/13 15:41
 * Description: baseVM
 * History:
 */
interface IBaseVM<V : IBaseView<User>> {
    fun attachView(view: V)
    fun detachView()
    fun getIView(): V
}