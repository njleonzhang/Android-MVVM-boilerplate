package com.leon.mvvm.ui.main.notification;

import android.content.Context;

import com.leon.mvvm.ui.base.BaseFragment;
import com.leon.mvvm.ui.base.mvvm.BaseViewModel;
import com.leon.mvvm.ui.main.notification.model.RxBusTestEvent;
import com.leon.mvvm.utils.RxBus;

/**
 * Created by leon on 2017/6/20.
 */

public class NotificationViewModel extends BaseViewModel {
    public NotificationViewModel(Context context, BaseFragment fragment) {
        super(context, fragment);
    }

    public void testRxBus() {
        RxBus.getInstance().post(new RxBusTestEvent(0));
    }
}
