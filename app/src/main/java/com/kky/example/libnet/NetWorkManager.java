package com.kky.example.libnet;

import android.os.Bundle;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/*
 * @author Zeus
 * create at 2019/1/15 15:21
 * modify at 2019/1/15 15:21
 * modify because
 * description: TO FIT
 */
public class NetWorkManager {
    private static NetWorkManager mInstance;
    private static Retrofit retrofit;
    private static volatile Request request = null;

    private NetWorkManager() {
    }

    public static NetWorkManager getInstance() {
        if (mInstance == null) {
            synchronized (NetWorkManager.class) {
                if (mInstance == null) {
                    mInstance = new NetWorkManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化必要对象和参数
     */
    public void init() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        //初始化okhttp
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        //初始化Retrofit
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Request.HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Request getRequest() {
        if (request == null) {
            synchronized (Request.class) {
                request = retrofit.create(Request.class);
            }
        }
        return request;
    }
}
