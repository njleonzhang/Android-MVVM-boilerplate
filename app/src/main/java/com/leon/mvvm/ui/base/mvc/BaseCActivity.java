package com.leon.mvvm.ui.base.mvc;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.leon.mvvm.data.DataManager;
import com.leon.mvvm.ui.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by leon on 2017/3/16.
 */

public class BaseCActivity extends BaseActivity {
    protected DataManager mDataManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    public DataManager getDataManager() {
        return mDataManager;
    }
}
