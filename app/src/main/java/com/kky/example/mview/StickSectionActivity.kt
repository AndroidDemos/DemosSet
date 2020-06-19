package com.kky.example.mview

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kky.example.R
import com.kky.example.base.activity.BaseActivity
import com.kky.example.mview.sticky.Contact
import com.kky.example.mview.sticky.DecorationCallback
import com.kky.example.mview.sticky.GroupSectionAdapter
import com.kky.example.widget.decor.SectionDecoration
import kotlinx.android.synthetic.main.activity_sticky_section.*

/**
 *粘滞性头部
 */
class StickSectionActivity : BaseActivity() {
    var groupSectionAdapter = GroupSectionAdapter()
    var data = mutableListOf<Contact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sticky_section)
        initData()
    }

    private fun initData() {
        rv_sticky.layoutManager = LinearLayoutManager(this)
        rv_sticky.adapter = groupSectionAdapter
        getFakeDatas()
        groupSectionAdapter.setNewData(data)
        rv_sticky.addItemDecoration(SectionDecoration(this, object : DecorationCallback {
            override fun getGroupId(position: Int): Long {
                return groupSectionAdapter.data[position].id
            }

            override fun getGroupFirstLine(position: Int): String {
                return groupSectionAdapter.data[position].name
            }
        }))
    }

    private fun getFakeDatas() {
        for (i in 0..5) {
            for (k in 1..10) {
                var contact = Contact()
                contact.id = i.toLong();
                if (i == 0) {
                    if (k == 1) {
                        contact.name = "GroupX+大$i"
                    } else {
                        contact.name = "出使之章00" + i + "Child " + k
                    }
                } else if (i == 1) {
                    if (k == 1) {
                        contact.name = "GroupX+大天使志坚$i"
                    } else {
                        contact.name = "天然呆萌00" + i + "Child " + k
                    }
                } else if (i == 2) {
                    if (k == 1) {
                        contact.name = "GroupX+大天使志坚$i"
                    } else {
                        contact.name = "超级玛丽00" + i + "Child " + k
                    }
                } else if (i == 3) {
                    if (k == 1) {
                        contact.name = "GroupX+大天使志坚" + i + "Child " + k
                    } else {
                        contact.name = "耽美网文00" + i + "Child " + k
                    }
                } else if (i == 4) {
                    if (k == 1) {
                        contact.name = "GroupX+大天使志坚$i"
                    } else {
                        contact.name = "美丽杀手00" + i + "Child " + k
                    }
                } else if (i == 5) {
                    if (k == 1) {
                        contact.name = "GroupX+大天使志坚$i"
                    } else {
                        contact.name = "健身达人00" + i + "Child " + k
                    }
                }
                data.add(contact)
            }
        }
    }

// blog https://www.jianshu.com/p/b46a4ff7c10a
}