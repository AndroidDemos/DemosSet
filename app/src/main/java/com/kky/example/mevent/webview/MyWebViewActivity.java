package com.kky.example.mevent.webview;

import android.annotation.SuppressLint;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.util.ToastUtils;
import com.orhanobut.logger.Logger;

import androidx.annotation.Nullable;


/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/10/22 16:18
 * @change time
 * @class describe
 */
public class MyWebViewActivity extends BaseActivity {
    String url = "http://test.bitqqex.com/#/login";
//    String url = "http://otc.bitqqex.pro";

    private WebView mWebView;
    private boolean initWebToApp = false;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_webview);
        mWebView = (WebView) findViewById(R.id.my_web);
        WebSettings webSettings = mWebView.getSettings();

        setWebView(webSettings);

        mWebView.addJavascriptInterface(new JSHook(), "bitqq");
        mWebView.loadUrl(url);
//        mWebView.loadUrl("https://www.baidu.com/");
    }

    private void setWebView(WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setSavePassword(false);
        webSettings.setSaveFormData(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setSupportZoom(true);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if(!initWebToApp){initWebToApp();}
            }
        });
    }

    private void initWebToApp() {
        initWebToApp = true;
        String method = "javascript:comeFormApp()";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            mWebView.evaluateJavascript(method, null);
        } else {
            mWebView.loadUrl(method);
        }
    }

    public class JSHook {

        @JavascriptInterface
        public void syncLogin(String json) { //  登录成功回调
            Log.e("JSHook-JSHook", "syncLogin fun");
            Logger.json(json);
            ToastUtils.makeText(json);
        }

        @JavascriptInterface
        public void showLogin() { //  跳转至登录界面
            Log.e("JSHook-JSHook", "showLogin");

        }

        @JavascriptInterface
        public void appBack() { // 返回上一个界面
            Log.e("JSHook-JSHook", "appBack");
        }
    }
}
