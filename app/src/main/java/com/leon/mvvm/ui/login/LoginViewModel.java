package com.leon.mvvm.ui.login;


import android.databinding.ObservableField;
import android.widget.Toast;

import com.leon.mvvm.data.remote.NetworkObserver;
import com.leon.mvvm.ui.main.MainActivity;
import com.leon.mvvm.ui.base.mvvm.BaseVMActivity;
import com.leon.mvvm.ui.base.mvvm.BaseViewModel;
import com.leon.mvvm.ui.login.model.LoginRequest;
import com.leon.mvvm.ui.login.model.LoginResponse;
import com.leon.mvvm.utils.ActivityUtil;

/**
 * Created by leon on 2017/6/20.
 */

public class LoginViewModel extends BaseViewModel {
    public ObservableField<String> cellphone = new ObservableField<>("");
    public ObservableField<String> password = new ObservableField<>("");

    public LoginViewModel(BaseVMActivity activity) {
        super(activity);
    }

    public void login() {
        mDataManager.login(new LoginRequest(cellphone.get(), password.get()))
            .compose(mActivity.bindToLifecycle())
            .subscribe(new NetworkObserver<LoginResponse>(mActivity) {
                @Override
                protected void onHandleSuccess(LoginResponse loginResponse) {
                    super.onHandleSuccess(loginResponse);
                    Toast.makeText(mActivity,
                        "OK + cellphone:" + cellphone.get() + "  password " + password.get(),
                        Toast.LENGTH_LONG).show();
                    ActivityUtil.gotoPage(mActivity, MainActivity.class);
                }
            });
    }
}
