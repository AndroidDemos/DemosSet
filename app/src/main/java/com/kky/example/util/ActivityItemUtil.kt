package com.kky.example.util

import android.util.SparseArray
import com.kky.example.base.activity.BaseActivity
import com.kky.example.mview.ViewDisActivity
import java.util.HashMap

/**
 * @name DemosSet
 * @author Zeus QQ:1946690608
 * @time 2018/4/8 20:34
 * @change time
 * @class describe
 */
class ActivityItemUtil {
    companion object {
        fun initActivities(items1: SparseArray<String>, items2: SparseArray<String>, items3: SparseArray<String>) {
            items1.put(0, "View的事件分发机制")
        }
    }
}