package com.kky.example.mevent

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import com.kky.example.BuildConfig
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_manifest_place_holder.*


class ManifestPlaceHolderActivity : BaseActivity() {
    //打包时配置 manifest 里或者 build文件
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manifest_place_holder)
        val appInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
        val urlValue = appInfo.metaData.getString("ZEUS_K")
//        tv_dev.setText(tv_dev.getText() + urlValue)
        tv_url.text = urlValue
        Log.d("测试", "kimmy=$urlValue")
        val text = tv_args1.text.toString()
        tv_args1.text = text + BuildConfig.BASE_URL
        tv_args2.text = text + "-" + BuildConfig.i_test
        tv_args3.text = text + "-" + BuildConfig.LOG_DEBUG
    }
}