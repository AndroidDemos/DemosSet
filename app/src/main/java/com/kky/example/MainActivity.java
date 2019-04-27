package com.kky.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kky.example.mevent.d2.A;
import com.kky.example.mevent.d2.DaggerMainComponent;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity implements NavItemFragment.OnListFragmentInteractionListener {

    private ViewPager view_pager_main;

    ArrayList<Fragment> fragmentArray;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    view_pager_main.setCurrentItem(0);
                    return true;
                case R.id.navigation_dashboard:
                    view_pager_main.setCurrentItem(1);
                    return true;
                case R.id.navigation_notifications:
                    view_pager_main.setCurrentItem(2);
                    return true;
                case R.id.navigation_notifications2:
                    view_pager_main.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragmentData();
        view_pager_main = findViewById(R.id.view_pager_main);
        view_pager_main.setAdapter(new MyAdapter(getSupportFragmentManager()));
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setFragmentData() {
        fragmentArray = new ArrayList<>();
        fragmentArray.add(NavItemFragment.Companion.newInstance(0));
        fragmentArray.add(NavItemFragment.Companion.newInstance(1));
        fragmentArray.add(NavItemFragment.Companion.newInstance(2));
        fragmentArray.add(NavItemFragment.Companion.newInstance(3));
    }

    @Override
    public void onListFragmentInteraction(@Nullable Map<String, ?> item) {
        Intent intent = (Intent) item.get("intent");
        startActivity(intent);
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentArray.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArray.size();
        }
    }

}
