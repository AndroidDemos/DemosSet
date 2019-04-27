package com.kky.example.libnet;

import com.google.gson.annotations.SerializedName;

/*
 * @author Zeus
 * create at 2019/1/15 15:35
 * modify at 2019/1/15 15:35
 * modify because
 * description: TO FIT
 */
public class Response<T> {
    private int code;//返回的code
    private T data; //具体的数据结果
    @SerializedName("desc")
    private String msg;//message 可用来返回接口的说明
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
