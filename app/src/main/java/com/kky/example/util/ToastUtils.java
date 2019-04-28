package com.kky.example.util;

import android.widget.Toast;


import com.kky.example.ZeusApp;


/**
 * Created by Freddie on 2016/06/01 .
 * Description:Toast管理类, 防止重复显示
 */

public class ToastUtils {

    private static Toast sToast;

    /**
     * 默认Toast
     */
    public static void makeText(String msg) {
        if (sToast == null) {
            sToast = Toast.makeText(ZeusApp.getContext(), msg, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(msg);
            sToast.setDuration(Toast.LENGTH_SHORT);
        }
        sToast.show();
    }
}
