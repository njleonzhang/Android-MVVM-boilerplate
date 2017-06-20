package com.leon.mvvm.ui.base.mvvm;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.leon.mvvm.BR;
import com.leon.mvvm.ui.base.BaseFragment;

/**
 * Created by leon on 2017/3/15.
 */

public class BaseVMFragment extends BaseFragment {
    protected ViewDataBinding mBinding;

    protected ViewDataBinding binding(LayoutInflater inflater, ViewGroup container, int layoutId, BaseViewModel viewModel) {
        mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        mBinding.setVariable(BR.viewModel, viewModel);

        return mBinding;
    }

    protected ViewDataBinding binding(LayoutInflater inflater, ViewGroup container, int layoutId, BaseViewModel viewModel, Object store) {
        mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);
        mBinding.setVariable(BR.viewModel, viewModel);
        return mBinding;
    }
}
