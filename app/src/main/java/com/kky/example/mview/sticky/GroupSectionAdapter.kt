package com.kky.example.mview.sticky

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.kky.example.R

class GroupSectionAdapter : BaseQuickAdapter<Contact, BaseViewHolder>
(R.layout.item_test_recycler) {
    override fun convert(helper: BaseViewHolder, item: Contact) {
        helper.setText(R.id.tv_name, item.name)
    }

}