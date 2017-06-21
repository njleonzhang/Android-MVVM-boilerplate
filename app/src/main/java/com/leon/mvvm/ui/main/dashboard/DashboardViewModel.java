package com.leon.mvvm.ui.main.dashboard;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.widget.Toast;

import com.leon.mvvm.data.model.EmptyResponse;
import com.leon.mvvm.data.remote.NetworkObserver;
import com.leon.mvvm.ui.base.BaseFragment;
import com.leon.mvvm.ui.base.mvvm.BaseViewModel;

/**
 * Created by leon on 2017/6/20.
 */

public class DashboardViewModel extends BaseViewModel {
    public DashboardViewModel(Context context, BaseFragment fragment) {
        super(context, fragment);
    }

    public void test() {
        mDataManager.getEmpty()
            .compose(mFragment.bindToLifecycle())
            .subscribe(new NetworkObserver<EmptyResponse>(mActivity) {
                @Override
                protected void onHandleSuccess(EmptyResponse emptyResponse) {
                    Toast.makeText(mActivity, "success", Toast.LENGTH_SHORT).show();
                }
            });
    }
}
