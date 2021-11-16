package com.eus.flex

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.text.TextUtils


/*
* @author Zeus
* create at 2020/3/30 16:39
* modify at 2020/3/30 16:39
* modify because 
* description: TO FIT
*/
object ClipBoardUtil {
    /**
     * 复制内容倒剪切板
     */
    fun copy2Clip(con: Context, txt: String) {
        val cm = con.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.text = txt
    }

    /**
     * 获取剪切板内容
     * @return
     */
    fun paste(con: Context): String? {
//        val manager = con.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val manager = MyApplication.getContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        if (manager != null) {
            if (manager.hasPrimaryClip() && manager.primaryClip!!.itemCount > 0) {
                val addedText = manager.primaryClip!!.getItemAt(0).text
                val addedTextString = addedText.toString()
                if (!TextUtils.isEmpty(addedTextString)) {
                    return addedTextString
                }
            }
        }
        return ""
    }

    /**
     * 清空剪切板
     */
    fun clear(con: Context) {
        val manager = con.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        if (manager != null) {
            try {
                manager.setPrimaryClip(manager.primaryClip!!)
                manager.setPrimaryClip(ClipData.newPlainText("", ""))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}