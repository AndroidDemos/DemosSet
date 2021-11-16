package com.kky.example.util.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

/**
 * Author: Zeus
 * Date: 2021/9/6 18:05
 * Description:
 * History:
 */
public class JsHelp<T> {
    public T gsonToMap(String strJson) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<T>() {
                }.getType(), new MapTypeAdapter()).create();
        return gson.fromJson(strJson, new TypeToken<T>() {
        }.getType());
    }
    public Map<String,Object> gson2ToMap(String strJson) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<Map<String,Object>>() {
                }.getType(), new MapTypeAdapter()).create();
        return gson.fromJson(strJson, new TypeToken<Map<String,Object>>() {
        }.getType());
    }

}
