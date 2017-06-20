package com.leon.mvvm.ui.base.mvp;

import android.content.Context;

import com.leon.mvvm.data.DataManager;
import com.leon.mvvm.ui.base.BaseActivity;
import com.leon.mvvm.ui.base.BaseFragment;


/**
 * Created by leon on 2017/4/25.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {

    private T mMvpView;
    protected DataManager mDataManager = DataManager.getInstance();
    protected BaseActivity mActivity;
    protected BaseFragment mFragment;

    public BasePresenter(BaseActivity activity) {
        mActivity = activity;
    }

    public BasePresenter(Context context, BaseFragment fragment) {
        mActivity = (BaseActivity) context;
        mFragment = fragment;
    }

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" +
                " requesting data to the Presenter");
        }
    }
}
