package com.leon.mvvm.ui.main.notification;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leon.mvvm.R;
import com.leon.mvvm.ui.base.mvvm.BaseVMFragment;

/**
 * Created by leon on 2017/6/20.
 */

public class NotificationFragment extends BaseVMFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        NotificationViewModel viewModel = new NotificationViewModel(getContext(), this);
        ViewDataBinding binding = binding(inflater, container, R.layout.fragment_notification, viewModel);
        return binding.getRoot();
    }
}
