package com.kky.example.mview.recycler;

import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
class SecondAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public SecondAdapter() {
        super(R.layout.item_second_recycler);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_title, item);
//        NoTouchRecyclerView recyclerView = helper.getView(R.id.rv_child);
        NoTouchRecyclerView recyclerView = helper.getView(R.id.rv_child);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        ArrayList<String> strings = new ArrayList<>();
        strings.add("child01");
        strings.add("child02");
        strings.add("child03");
        recyclerView.setAdapter(new ChildAdapter(strings) );
    }
}
