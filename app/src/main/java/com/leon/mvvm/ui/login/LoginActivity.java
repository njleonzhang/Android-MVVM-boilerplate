package com.leon.mvvm.ui.login;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.leon.mvvm.R;
import com.leon.mvvm.ui.base.mvvm.BaseVMActivity;

/**
 * Created by leon on 2017/6/20.
 */

public class LoginActivity extends BaseVMActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_login, new LoginViewModel(this));
    }
}
