package com.leon.mvvm.data.remote;

import android.content.Context;
import android.widget.Toast;

import com.leon.mvvm.utils.RxUtil;
import com.leon.mvvm.ui.base.BaseActivity;
import com.leon.mvvm.utils.ActivityUtil;
import com.leon.mvvm.widget.loading.ILoading;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public class NetworkObserver<T> implements Observer<T> {
    private static final String TAG = "NetworkObserver";
    private Context mContext;
    private ILoading mLoading;

    public NetworkObserver(Context context) {
        mContext = context;
    }

    public NetworkObserver(Context context, @Nullable ILoading loading) {
        mContext = context;
        mLoading = loading;
    }

    // ==========
    // 偷懒的工具函数，不符合设计原则。
    public NetworkObserver(BaseActivity activity) {
        mContext = activity;
        mLoading = activity;
    }

    public NetworkObserver(BaseActivity activity, Boolean showLoading) {
        mContext = activity;
        if (showLoading) {
            mLoading = activity;
        }
    }
    // ==========

    @Override
    public void onSubscribe(Disposable d) {
        if (mLoading != null) {
            mLoading.show();
        }
    }

    @Override
    public void onNext(T result) {
        onHandleSuccess(result);
    }

    @Override
    public void onError(Throwable e) {

        if (mLoading != null) {
            mLoading.hide();
        }

        String errorMsg = e.getMessage();

        if (e instanceof ConnectException) {
            errorMsg = "无法连接服务器，请稍后重试";
        } else if (e instanceof HttpException) {
            int errorCode = ((HttpException) e).code();
            switch (errorCode / 100) {
                case 5:
                    errorMsg = "服务器内部错误";
                    break;
                case 4:
                    errorMsg = "URL找不到";
                    break;
                default:
                    errorMsg = "未知服务器错误";
            }
        } else if (e instanceof SocketTimeoutException) {
            errorMsg = "连接服务器超时";
        } else if (e instanceof RxUtil.UserNotLoginException) {
            ActivityUtil.gotoLogin(mContext);
        } else {
            errorMsg = e.getMessage();
        }

        onHandleError(errorMsg);
        onHandleFinal();
    }

    @Override
    public void onComplete() {
        if (mLoading != null) {
            mLoading.hide();
        }
        onHandleFinal();
    }

    protected void onHandleSuccess(T t) {}

    protected void onHandleError(String msg) {
        if (msg == null) {
            msg = "未知错误";
        }
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    protected void onHandleFinal() {

    }
}
