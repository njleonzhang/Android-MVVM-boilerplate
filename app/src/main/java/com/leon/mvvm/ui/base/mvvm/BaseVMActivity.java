package com.leon.mvvm.ui.base.mvvm;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.leon.mvvm.BR;
import com.leon.mvvm.ui.base.BaseActivity;

/**
 * Created by leon on 2017/3/14.
 */

public class BaseVMActivity extends BaseActivity {
    protected ViewDataBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected ViewDataBinding binding(int layoutId, BaseViewModel viewModel) {
        mBinding = DataBindingUtil.setContentView(this, layoutId);
        mBinding.setVariable(BR.viewModel, viewModel);
        return mBinding;
    }

    protected ViewDataBinding binding(int layoutId, BaseViewModel viewModel, Object store) {
        mBinding = DataBindingUtil.setContentView(this, layoutId);
        mBinding.setVariable(BR.viewModel, viewModel);
        return mBinding;
    }
}
