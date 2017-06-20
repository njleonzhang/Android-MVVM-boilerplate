package com.leon.mvvm.ui.base.mvc;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.leon.mvvm.data.DataManager;
import com.leon.mvvm.ui.base.BaseFragment;


/**
 * MVC模式的基Fragment
 * Created by xupeng on 2017/4/27.
 */
public class BaseCFragment extends BaseFragment {
    protected DataManager mDataManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance();
    }
}
