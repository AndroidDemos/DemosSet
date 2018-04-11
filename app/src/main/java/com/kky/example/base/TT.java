package com.kky.example.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.kky.example.base.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeus QQ:1946690608
 * @name DemosSet
 * @time 2018/4/8 15:15
 * @change time
 * @class describe
 */
public abstract class TT extends BaseFragment {


    public static int NAV_TAB_VIEW = 1;
    private   List<BaseFragment> fragments = new ArrayList<>();

    protected abstract List<BaseFragment> setFragments();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        List<BaseFragment> tmpFragments = setFragments();
        fragments.addAll(setFragments());
//        for(BaseFragment fragment:tmpFragments){
//            fragments.add(fragment);
//        }
    }

    public static List<BaseFragment> getFragments() {
          List<BaseFragment> fragments = new ArrayList<>();

        for(BaseFragment baseFragment:fragments){

        }
        return fragments;
    }


}
