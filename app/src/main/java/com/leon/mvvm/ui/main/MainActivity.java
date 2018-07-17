package com.leon.mvvm.ui.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;

import com.leon.mvvm.R;
import com.leon.mvvm.ui.base.mvc.BaseCActivity;
import com.leon.mvvm.ui.main.dashboard.DashboardFragment;
import com.leon.mvvm.ui.main.home.HomeFragment;
import com.leon.mvvm.ui.main.notification.NotificationFragment;
import com.leon.mvvm.utils.SimpleFragmentPagerAdapter;

import java.util.Arrays;

import butterknife.BindView;

public class MainActivity extends BaseCActivity {
    @BindView(R.id.navigation)
    BottomNavigationView mNavigationView;

    @BindView(R.id.viewpager)
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager.setAdapter(new SimpleFragmentPagerAdapter(this,
            Arrays.asList(new HomeFragment(), new DashboardFragment(), new NotificationFragment())));

        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mViewPager.addOnPageChangeListener(mOnPageChangeListener);
        mViewPager.setOffscreenPageLimit(3);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        mViewPager.setCurrentItem(item.getOrder());
        return true;
    };

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mNavigationView.getMenu().getItem(position).setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
