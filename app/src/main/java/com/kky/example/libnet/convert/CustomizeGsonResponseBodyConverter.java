package com.kky.example.libnet.convert;

import android.util.Log;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ReflectUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.kky.example.BuildConfig;
import com.kky.example.bean.LoginOrRegisterBean;
import com.kky.example.bean.LoginOrRegisterData;
import com.kky.example.libnet.ApiException;
import com.kky.example.libnet.Response;
import com.kky.example.util.LocalPrinter;
import com.kky.example.util.gson.JsHelp;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class CustomizeGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomizeGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        //把responsebody转为string
        String response = value.string();
        if (BuildConfig.DEBUG) {
            //打印后台数据
            Log.e(BuildConfig.APPLICATION_ID, response);
        }
        String toJson = GsonUtils.toJson(response);
//        Type mapType = GsonUtils.getMapType(String.class, Response.class);
//        Log.e(BuildConfig.APPLICATION_ID, "after---" + toJson + "\n");
//        JsonObject s = new JsonObject(response);
        Response baseResponse = gson.fromJson(response, Response.class);
//        ConvertUtils.byReflect(baseResponse);
//        ConvertUtils.byMap(response);


        // 这里只是为了检测code是否!=1,所以只解析HttpStatus中的字段,因为只要code和message就可以了
        if (baseResponse.getCode() != 0) {
            value.close();
            //抛出一个RuntimeException, 这里抛出的异常会到subscribe的onError()方法中统一处理
            try {
                throw new ApiException(baseResponse.getCode(), baseResponse.getMsg());
            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
        try {
            return adapter.fromJson(response);
        } finally {
            value.close();
        }

//        final Gson gson = new GsonBuilder().serializeSpecialFloatingPointValues();
    }

}