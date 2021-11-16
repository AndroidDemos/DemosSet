package com.kky.example.mview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kky.example.R;
import com.kky.example.base.activity.BaseActivity;
import com.kky.example.widget.decor.LeftAndRightTagDecoration;
import com.kky.example.widget.decor.PaddingItemDerocation;
import com.kky.example.widget.decor.SimpleDividerDecoration;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContentView(R.layout.activity_recycler_view);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("测试Recycler滑动");
        RadioGroup group = findViewById(R.id.rg_type);
        PaddingItemDerocation decoration1 = new PaddingItemDerocation(this);
        SimpleDividerDecoration decoration2 = new SimpleDividerDecoration(this);
        LeftAndRightTagDecoration decoration3 = new LeftAndRightTagDecoration(this);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_1:
                        if (recycler.getItemDecorationCount() > 1) {
                            recycler.removeItemDecorationAt(0);
                        }
                        recycler.addItemDecoration(decoration1);
                        break;
                    case R.id.rb_2:
                        if (recycler.getItemDecorationCount() > 1) {
                            recycler.removeItemDecorationAt(0);
                        }
                        recycler.addItemDecoration(decoration2);
                        break;
                    case R.id.rb_3:
                        if (recycler.getItemDecorationCount() > 1) {
                            recycler.removeItemDecorationAt(0);
                        }
                        recycler.addItemDecoration(decoration3);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + checkedId);
                }
            }
        });
        recycler = findViewById(R.id.rv_test);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        recycler.addItemDecoration(decoration1);
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

                if (lastVisibleItemPosition == position) {
                    manager.scrollToPositionWithOffset(position, position + 1);
                }
                adapter.notifyItemChanged(position);
            }
        });

//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            public void run() {
//                hideSoftKeyboard(RecyclerViewActivity.this);
//            }
//        }, 400);
    }
    /**
     * 点击空白处隐藏软键盘
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null && v != null && v.getWindowToken() != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        return getWindow().superDispatchTouchEvent(ev) || onTouchEvent(ev);
    }
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            return (!(event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom));
        }
        return false;
    }

    void hideSoftKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputMethodManager =
                    (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}
