package com.kky.example.mview.recycler;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kky.example.R;

import java.util.ArrayList;

/**
 * Author: Zeus
 * Date: 2021/9/13 18:14
 * Description:
 * History:
 */
class ChildAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public ChildAdapter(ArrayList<String> strings) {
        super(R.layout.item_second_child, strings);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_child, item);
    }
}
