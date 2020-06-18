package com.kky.example.util

import android.app.Activity
import android.content.Intent
import java.util.*

object IntentHelp {

     fun <T> addActivity(activity: Activity, targetActivity: Class<T>, myData: MutableList<Map<String, Any>>) {
        val map1: MutableMap<String, Any>
        val intent: Intent
        map1 = HashMap()
        val simpleName = targetActivity.simpleName
        map1["title"] = simpleName
        intent = Intent(activity, targetActivity)
        map1["intent"] = intent
        myData.add(map1)
    }

     fun <T> addWithTitle(activity: Activity, title: String, targetActivity: Class<T>, myData: MutableList<Map<String, Any>>) {
        val map1: MutableMap<String, Any>
        val intent: Intent
        map1 = HashMap()
        val simpleName = targetActivity.simpleName
        map1["title"] = title
        intent = Intent(activity, targetActivity)
        map1["intent"] = intent
        myData.add(map1)
    }
}