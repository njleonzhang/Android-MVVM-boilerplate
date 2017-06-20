package com.leon.mvvm.ui.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.leon.mvvm.widget.loading.ILoading;
import com.leon.mvvm.widget.loading.ProgressDialogLoading;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by leon on 2017/3/16.
 */

public class BaseActivity extends RxAppCompatActivity implements ILoading {
    ILoading mLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoading = new ProgressDialogLoading(this);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        preventInitialFocus();
    }

    protected void setLoading(ILoading loading) {
        mLoading = loading;
    }

    @Override
    public void show() {
        mLoading.show();
    }

    @Override
    public void hide() {
        mLoading.hide();
    }

    @Override
    public void dismiss() {
        mLoading.dismiss();
    }

    private void preventInitialFocus() {
        final ViewGroup content = (ViewGroup)this.findViewById(android.R.id.content);
        final View root = content.getChildAt(0);
        if (root == null) return;
        final View focusDummy = new View(this);
        focusDummy.setFocusable(true);
        focusDummy.setFocusableInTouchMode(true);
        if (root instanceof ViewGroup) {
            ((ViewGroup)root).addView(focusDummy, 0, new LinearLayout.LayoutParams(0, 0));
        } else {
            content.addView(focusDummy, 0, new LinearLayout.LayoutParams(0, 0));
        }
    }
}
