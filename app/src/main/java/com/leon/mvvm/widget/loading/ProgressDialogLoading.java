package com.leon.mvvm.widget.loading;

import android.content.Context;


/**
 * Created by leon on 2017/3/14.
 */

public class ProgressDialogLoading implements ILoading {

    private DialogProgressLoading mPd;

    public ProgressDialogLoading(Context context) {
        mPd = new DialogProgressLoading(context);
    }

    @Override
    public void show() {
        mPd.show();
    }

    @Override
    public void hide() {
        mPd.dismiss();
    }

    @Override
    public void dismiss() {
        mPd.dismiss();
    }
}
