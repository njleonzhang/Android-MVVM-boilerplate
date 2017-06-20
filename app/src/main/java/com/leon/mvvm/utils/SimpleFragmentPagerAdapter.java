package com.leon.mvvm.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by leon on 2017/6/9.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private int mPagerCnt;
    private List<Fragment> mFragments;

    public SimpleFragmentPagerAdapter(AppCompatActivity activity,
                                      List<Fragment> fragments) {
        super(activity.getSupportFragmentManager());
        mFragments = fragments;
        mPagerCnt = fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mPagerCnt;
    }
}
