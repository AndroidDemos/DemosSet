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
import com.kky.example.mview.BottomSheetActivity;
import com.kky.example.mview.DrawableResourceActivity;
import com.kky.example.mview.KeyBoardActivity;
import com.kky.example.mevent.ManifestPlaceHolderActivity;
import com.kky.example.mview.RecyclerViewActivity;
import com.kky.example.mview.ScrollingActivity;
import com.kky.example.mview.SoftInputActivity;
import com.kky.example.mview.SoftInputActivity2;
import com.kky.example.mview.SpinnerActivity;
import com.kky.example.mview.StickySectionActivity;
import com.kky.example.mview.TextSizeActivity;
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
        IntentHelp.INSTANCE.addActivity(activity, PopwindowActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, LeftMenuActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, CoordinateActivity.class, myData);
    }

    private static void setViewList(Activity activity, List<Map<String, Object>> myData) {
        IntentHelp.INSTANCE.addActivity(activity, KeyBoardActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, SpinnerActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, ScrollingActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, BottomSheetActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, RecyclerViewActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, StickySectionActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, SoftInputActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, SoftInputActivity2.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, DrawableResourceActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, TextSizeActivity.class, myData);
    }


    private static void setEventList(Activity activity, List<Map<String, Object>> myData) {
        IntentHelp.INSTANCE.addActivity(activity, FingerPrintActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, RoomActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, RoomActivity2.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, MyWebViewActivity.class, myData);
        IntentHelp.INSTANCE.addActivity(activity, AnnotationTestActivity.class, myData);
        IntentHelp.INSTANCE.addWithTitle(activity, "简单使用Dagger 2", D2Simple1Activity.class, myData);
        IntentHelp.INSTANCE.addWithTitle(activity, "封装网络请求测试 2", NetWorkActivity.class, myData);
        IntentHelp.INSTANCE.addWithTitle(activity, "查询通讯录 2", ContactActivity.class, myData);
        IntentHelp.INSTANCE.addWithTitle(activity, "GMap使用", GMapActivity.class, myData);
        IntentHelp.INSTANCE.addWithTitle(activity, "Manifest placeHolder的传参", ManifestPlaceHolderActivity.class,
                myData);
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
