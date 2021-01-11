package com.example.mvvmapp.mvvm

/**
 * Author: Zeus
 * Date: 2020/7/13 15:40
 * Description: baseView
 * History:
 */
interface IBaseView<T> {
    fun showError()
    fun showSuccess(args: T)
    fun showLoading()
    fun complete()
}