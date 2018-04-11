package com.kky.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.MenuItem;

import com.kky.example.base.activity.BaseActivity;
import com.kky.example.mview.ViewDisActivity;
import com.kky.example.util.ActivityItemUtil;

import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements NavItemFragment.OnListFragmentInteractionListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private final static int fragmentLength = 3;
    private static SparseArray<String> itemsDescribe1;
    private static SparseArray<String> itemsDescribe2;
    private static SparseArray<String> itemsDescribe3;
    private static HashMap<String, Class> activities;
    private static int curIndex = NavItemFragment.NAV_TAB_VIEW;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    curIndex = NavItemFragment.NAV_TAB_VIEW;
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    curIndex = NavItemFragment.NAV_TAB_UI;
                    return true;
                case R.id.navigation_notifications:
                    curIndex = NavItemFragment.NAV_TAB_EVENT;
                    mViewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager_entry);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initActivities();
    }

    private void initActivities() {
        itemsDescribe1 = new SparseArray<String>();
        itemsDescribe2 = new SparseArray<String>();
        itemsDescribe3 = new SparseArray<String>();
        activities = new HashMap<String, Class>();
        activities.put("View的事件分发机制", ViewDisActivity.class);
        ActivityItemUtil.Companion.initActivities(itemsDescribe1, itemsDescribe2, itemsDescribe3);
    }

    public static SparseArray<String> getSpArray(int tabIndex) {
        switch (tabIndex) {
            case 0:
                return itemsDescribe1;
            case 1:
                return itemsDescribe2;
            case 2:
                return itemsDescribe3;
            default:
                return itemsDescribe1;
        }
    }

    @Override
    public void onListFragmentInteraction(@Nullable Integer item) {
        Class cls = activities.get(itemsDescribe1.get(item));
        switch (curIndex) {
            case NavItemFragment.NAV_TAB_VIEW:
                cls = activities.get(itemsDescribe1.get(item));
                break;
            case NavItemFragment.NAV_TAB_UI:
                 cls = activities.get(itemsDescribe2.get(item));
                break;
            case NavItemFragment.NAV_TAB_EVENT:
                cls = activities.get(itemsDescribe3.get(item));
                break;
        }
        startActivity(new Intent(this, cls));
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a ViewDisActivity (defined as a static inner class below).
            Fragment fragment;
            switch (position) {
                case 0:
                    fragment = NavItemFragment.Companion.newInstance(NavItemFragment.NAV_TAB_VIEW, itemsDescribe1.size());
                    break;
                case 1:
                    fragment = NavItemFragment.Companion.newInstance(NavItemFragment.NAV_TAB_UI, itemsDescribe2.size());
                    break;
                case 2:
                    fragment = NavItemFragment.Companion.newInstance(NavItemFragment.NAV_TAB_EVENT, itemsDescribe3.size());
                    break;
                default:
                    fragment = NavItemFragment.Companion.newInstance(NavItemFragment.NAV_TAB_VIEW, itemsDescribe1.size());
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return fragmentLength;
        }
    }

}
