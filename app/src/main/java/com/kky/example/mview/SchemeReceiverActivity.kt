package com.kky.example.mview

import android.os.Bundle
import android.util.Log
import com.kky.example.base.activity.BaseActivity

/**
 * Author: Zeus
 * Date: 2020/8/19 10:21
 * Description: 接收scheme传参
 * History:
 */
public class SchemeReceiverActivity:BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uriA = intent.data
        uriA?.let { uri ->
            var url = uri.toString();
            Log.e(TAG, "url: " + url);
            // scheme部分
            var scheme = uri.getScheme();
            Log.e(TAG, "scheme: " + scheme);
            // host部分
            var host = uri.getHost();
            Log.e(TAG, "host: " + host);
            //port部分
            var port = uri.getPort();
            Log.e(TAG, "port: " + port);
            // 访问路劲
            var path = uri.getPath();
            Log.e(TAG, "path: " + path);

            // 获取所有参数

            // 获取所有参数
            val query = uri.query
            Log.e(TAG, "query: $query")
            //获取指定参数值
            //获取指定参数值
            val title = uri.getQueryParameter("title")
            Log.e(TAG, "title: $title")
            val paramsurl = uri.getQueryParameter("url")
            Log.e(TAG, "paramsUrl: $paramsurl")

        }

    }
}