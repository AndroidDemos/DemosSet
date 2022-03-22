package com.kky.example.mui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.util.LocalPrinter
import com.kky.example.util.ToastUtils
import com.kky.example.widget.CustomPopWindow
import kotlinx.android.synthetic.main.activity_popwindow.*
import kotlinx.android.synthetic.main.merge_verticle_2_bt_layout.*

/**
 * @name DemosSet
 * @author Zeus QQ:1946690608
 * @time 2018/5/25 14:20
 * @change time
 * @class describe
 */
class PopwindowActivity : BaseActivity(), View.OnClickListener {
    private val mPopWindow: CustomPopWindow? = null
    private var mListPopWindow: CustomPopWindow? = null
    private var mCustomPopWindow: CustomPopWindow? = null
    override fun onClick(v: View) {
        when (v) {
            button1 -> {
            }
            button2 -> {
            }
            button3 -> {
                showPopMenu()
            }
            button4 -> {
                showPopListView()
            }
            button5 -> {
                ToastUtils.makeText("button--5")
            }
            button6 -> {
            }
            button7 -> {
            }
        }
    }

    private fun showPopMenu() {

        val contentView = LayoutInflater.from(this).inflate(R.layout.pop_menu, null)
        //处理popWindow 显示内容
        handleLogic(contentView)
        //创建并显示popWindow
        mCustomPopWindow = CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .create()
                .showAsDropDown(button3, 0, 20)
    }

    private fun handleLogic(contentView: View) {

        val listener = View.OnClickListener { v ->
            if (mCustomPopWindow != null) {
                mCustomPopWindow!!.dissmiss()
            }
            var showContent = ""

            when (v.id) {
                R.id.menu1 -> {
                    showContent = "点击 Item菜单1"
                }
                R.id.menu2 -> {
                    showContent = "点击 Item菜单2"
                }
                R.id.menu3 -> {
                    showContent = "点击 Item菜单3"
                }
                R.id.menu4 -> {
                    showContent = "点击 Item菜单4"
                }
                R.id.menu5 -> {
                    showContent = "点击 Item菜单5"
                }

            }

            ToastUtils.makeText(showContent)
        }
        contentView.findViewById<View>(R.id.menu1).setOnClickListener(listener)
        contentView.findViewById<View>(R.id.menu2).setOnClickListener(listener)
        contentView.findViewById<View>(R.id.menu3).setOnClickListener(listener)
        contentView.findViewById<View>(R.id.menu4).setOnClickListener(listener)
        contentView.findViewById<View>(R.id.menu5).setOnClickListener(listener)

    }

    private fun showPopListView() {
        val contentView = LayoutInflater.from(this).inflate(R.layout.pop_list, null)
        //处理popWindow 显示内容
        handleListView(contentView)
        //创建并显示popWindow
        mListPopWindow = CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)//显示大小
                .create()
                .showAsDropDown(button7, 0, 20)
    }

    private fun handleListView(contentView: View) {
        val recyclerView = contentView.findViewById(R.id.recyclerView) as RecyclerView
        val manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.VERTICAL
        recyclerView.setLayoutManager(manager)
        val adapter = MyAdapter()
        adapter.setData(mockData())
        recyclerView.setAdapter(adapter)
        adapter.notifyDataSetChanged()
    }

    private fun mockData(): MutableList<String>? {
        val data = ArrayList<String>()
        for (i in 0..99) {
            data.add("Item:$i")
        }

        return data
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popwindow)
        val include1 = findViewById<View>(R.id.include1)
        if (include1 == null) {
            LocalPrinter.printLocal("include is null")
        } else {
            include1.findViewById<Button>(R.id.button5).setOnClickListener(this)
        }
        setListeners()
    }

    private fun setListeners() {
        val list: List<View> = listOf(button1, button2, button3, button4, button5, button6, button7)
        for (i in list) {
            i.setOnClickListener(this)
        }
    }
}