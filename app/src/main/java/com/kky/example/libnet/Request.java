package com.kky.example.libnet;

import com.kky.example.bean.LoginOrRegisterBean;
import com.kky.example.bean.LoginOrRegisterData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/*
 * @author Zeus
 * create at 2019/1/15 15:27
 * modify at 2019/1/15 15:27
 * modify because
 * description: TO FIT
 */
public interface Request {
    //填上需要访问的服务器地址
    public static String HOST = "http://116.50.166.90:16001/v1/";


    @POST("user/loginOrRegister")
    Observable<Response<LoginOrRegisterData>> getList(@Body LoginOrRegisterBean body);

}
