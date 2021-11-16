package com.kky.example.mview;

import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kky.example.R;

import java.util.List;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/8/24 15:39
 * @change time
 * @class describe
 */
public class TestAdapter extends BaseQuickAdapter<ScrollBean, BaseViewHolder> {
    public TestAdapter(int layoutResId, @Nullable List<ScrollBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ScrollBean item) {
        LinearLayout ll = helper.getView(R.id.ll_hide);
        if (item.isOpen) {
            helper.setGone(R.id.ll_hide, true);
        } else {
            helper.setGone(R.id.ll_hide, false);
        }
        helper.setText(R.id.tv_time, item.time);
        helper.setText(R.id.tv_name, "原油1809");
        int position = helper.getAdapterPosition();
        helper.setGone(R.id.et_content,position%2==1);
        helper.setText(R.id.et_content, "1111222@qq.com");
//        EditText et = helper.getView(R.id.et_content);
//        et.setText("1111222@qq.com");

    }
}
