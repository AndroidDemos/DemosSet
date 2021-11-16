package com.kky.example.mview.recycler;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.util.LocalPrinter;

import java.util.ArrayList;

/**
 * Author: Zeus
 * Date: 2021/9/13 18:11
 * Description:
 * History:
 */
public class SecondRecyclerView extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondrecyclerview);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("titles01");
        strings.add("titles02");
        strings.add("titles03");
        RecyclerView recyclerView = findViewById(R.id.rv_base);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SecondAdapter adapter = new SecondAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNewData(strings);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                LocalPrinter.printLocal("onItemClick-------onItemClick");
            }
        });
    }
}
