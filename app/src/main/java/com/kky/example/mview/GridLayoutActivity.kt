package com.kky.example.mview

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_gridlayout.*

/**
 * Author: Zeus
 * Date: 2021/3/16 16:51
 * Description: GridLayoumanager
 * History:
 */
class GridLayoutActivity : BaseActivity() {
    val list = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gridlayout)
        for (i in 1..21) {
            list.add(i)
        }
        recyclerView.layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL,false)
        val adapter = Adapter()
        recyclerView.adapter = adapter
        adapter.setNewData(list)
    }

    inner class Adapter : BaseQuickAdapter<Int, BaseViewHolder>(R.layout.item_text) {
        override fun convert(helper: BaseViewHolder, item: Int) {
            helper.setText(R.id.tv, "item-$item")
        }
    }
}