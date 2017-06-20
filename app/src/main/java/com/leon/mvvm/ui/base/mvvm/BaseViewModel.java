package com.leon.mvvm.ui.base.mvvm;

import android.content.Context;

import com.leon.mvvm.data.DataManager;
import com.leon.mvvm.ui.base.BaseActivity;
import com.leon.mvvm.ui.base.BaseFragment;

/**
 * Created by leon on 2017/3/11.
 */

public class BaseViewModel {
    protected BaseActivity mActivity;
    protected BaseFragment mFragment;
    protected DataManager mDataManager = DataManager.getInstance();

    public BaseViewModel(BaseVMActivity activity) {
        mActivity = activity;
    }

    public BaseViewModel(Context context, BaseFragment fragment) {
        mActivity = (BaseActivity) context;
        mFragment = fragment;
    }
}
