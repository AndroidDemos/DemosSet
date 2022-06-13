package com.kky.example.libnet.convert;/*
 * @description
 * @author Zeus
 * @time 2022/6/9 17:27
 * @change remark
 * @change 2022/6/9 17:27
 */

import android.util.Log;

import com.kky.example.BuildConfig;
import com.kky.example.libnet.Response;
import com.kky.example.util.LocalPrinter;
import com.kky.example.util.gson.JsHelp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class ConvertUtils {
     static void byReflect(Response baseResponse) {
        Class clazz = baseResponse.getClass();
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            Log.e(BuildConfig.APPLICATION_ID, "Method---" + m + "\n");
        }
        try {
            Field success = clazz.getDeclaredField("success");
            success.setAccessible(true);
            success.get(baseResponse);
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                Log.e(BuildConfig.APPLICATION_ID, "Field---"  + f.getGenericType() + "\n");
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    static void byMap(String response) {
        Map<String, Object> map = new JsHelp<Map<String, Object>>().gson2ToMap(response);
        for (String av : map.keySet()) {
            LocalPrinter.printLocal("key-" + av + map.get(av)+"\n");
        }
    }

}
