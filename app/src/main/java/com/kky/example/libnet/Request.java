package com.kky.example.libnet;

import com.kky.example.bean.LoginOrRegisterBean;
import com.kky.example.bean.LoginOrRegisterData;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
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
    public static String HOST = "http://api.juanwallet.net/";


    @POST("v1/user/loginOrRegister")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Observable<Response<LoginOrRegisterData>> getList(@Body LoginOrRegisterBean body);

}
