package com.kky.example.util;

import android.app.Activity;
import android.content.Intent;

import com.kky.example.meffect.wheel.WheelViewActivity;
import com.kky.example.mevent.ContactActivity;
import com.kky.example.mevent.FingerPrintActivity;
import com.kky.example.mevent.annotation.AnnotationTestActivity;
import com.kky.example.mevent.d2.D2Simple1Activity;
import com.kky.example.mevent.dbroom.RoomActivity;
import com.kky.example.mevent.dbroom.RoomActivity2;
import com.kky.example.mevent.gmap.GMapActivity;
import com.kky.example.mevent.retrofit.NetWorkActivity;
import com.kky.example.mevent.webview.MyWebViewActivity;
import com.kky.example.mui.CoordinateActivity;
import com.kky.example.mui.LeftMenuActivity;
import com.kky.example.mui.PopwindowActivity;
import com.kky.example.mui.UiActivity;
import com.kky.example.mview.BottomSheetActivity;
import com.kky.example.mview.KeyBoardActivity;
import com.kky.example.mview.RecyclerViewActivity;
import com.kky.example.mview.ScrollingActivity;
import com.kky.example.mview.SoftInputActivity;
import com.kky.example.mview.SoftInputActivity2;
import com.kky.example.mview.SpinnerActivity;
import com.kky.example.mview.ViewDisActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/5/23 10:50
 * @change time
 * @class describe
 */
public class ActivityHelp {
    public static List<Map<String, Object>> setList(int position, Activity activity) {

        List<Map<String, Object>> myData = new ArrayList<>();
        switch (position) {
            case 0:
                setViewList(activity, myData);
                break;
            case 1:
                setUiList(activity, myData);
                break;
            case 2:
                setEventList(activity, myData);
                break;
            case 3:
                setEffect(activity, myData);
                break;
        }

        return myData;
    }

    private static void setUiList(Activity activity, List<Map<String, Object>> myData) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("title", "UiActivity");
        Intent intent = new Intent(activity, UiActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "PopwindowActivity");
        intent = new Intent(activity, PopwindowActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "LeftMenuActivity");
        intent = new Intent(activity, LeftMenuActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "CoordinateActivity");
        intent = new Intent(activity, CoordinateActivity.class);
        map1.put("intent", intent);
        myData.add(map1);
    }

    private static void setViewList(Activity activity, List<Map<String, Object>> myData) {
        addActivity(activity, KeyBoardActivity.class, myData);
        addActivity(activity, SpinnerActivity.class, myData);
        addActivity(activity, ScrollingActivity.class, myData);
        addActivity(activity, BottomSheetActivity.class, myData);
        addActivity(activity, RecyclerViewActivity.class, myData);
        addActivity(activity, SoftInputActivity.class, myData);
        addActivity(activity, SoftInputActivity2.class, myData);
    }

    private static <T> void addActivity(Activity activity, Class<T> targetActivity, List<Map<String, Object>> myData) {
        Map<String, Object> map1;
        Intent intent;
        map1 = new HashMap<>();
        String simpleName = targetActivity.getSimpleName();
        map1.put("title", simpleName);
        intent = new Intent(activity, targetActivity);
        map1.put("intent", intent);
        myData.add(map1);
    }

    private static void setEventList(Activity activity, List<Map<String, Object>> myData) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("title", "FingerPrintActivity");
        Intent intent = new Intent(activity, FingerPrintActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "RoomActivity");
        intent = new Intent(activity, RoomActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "RoomActivity2");
        intent = new Intent(activity, RoomActivity2.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "MyWebView");
        intent = new Intent(activity, MyWebViewActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "SimpleAnnotation");
        intent = new Intent(activity, AnnotationTestActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "简单使用Dagger 2");
        intent = new Intent(activity, D2Simple1Activity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "封装网络请求测试");
        intent = new Intent(activity, NetWorkActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "查询通讯录");
        intent = new Intent(activity, ContactActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "GMap使用");
        intent = new Intent(activity, GMapActivity.class);
        map1.put("intent", intent);
        myData.add(map1);
    }

    private static void setEffect(Activity activity, List<Map<String, Object>> myData) {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("title", "ViewDisActivity");
        Intent intent = new Intent(activity, ViewDisActivity.class);
        map1.put("intent", intent);
        myData.add(map1);

        map1 = new HashMap<>();
        map1.put("title", "WheelViewActivity");
        intent = new Intent(activity, WheelViewActivity.class);
        map1.put("intent", intent);
        myData.add(map1);
    }


}
