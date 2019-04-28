package com.kky.example.mview;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/8/24 15:27
 * @change time
 * @class describe
 */
public class RecyclerViewActivity extends BaseActivity {
    RecyclerView recycler;
    TestAdapter adapter;
    ArrayList<ScrollBean> list = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("测试Recycler滑动");
        recycler = findViewById(R.id.rv_test);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        for (int i = 0; i < 20; i++) {
            ScrollBean bean = new ScrollBean();
            bean.time = "position" + i;
            list.add(bean);
        }
        adapter = new TestAdapter(R.layout.item_test_recycler, list);
        recycler.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                list.get(position).isOpen = !list.get(position).isOpen;

                int lastVisibleItemPosition = manager.findLastVisibleItemPosition();

                if(lastVisibleItemPosition==position){
                    manager.scrollToPositionWithOffset(position,position+1);
                }

                adapter.notifyItemChanged(position);
            }
        });
    }
}
