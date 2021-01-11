package com.example.mvvmapp.bean;

/**
 * Author: Zeus
 * Date: 2020/7/14 10:42
 * Description:
 * History:
 */
public class ZData<D> {
    int code;
    D data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
