package com.leon.mvvm.data;

import com.leon.mvvm.data.local.ILocalDataSource;
import com.leon.mvvm.data.local.LocalDataSource;
import com.leon.mvvm.data.model.BaseResponse;
import com.leon.mvvm.data.model.EmptyResponse;
import com.leon.mvvm.data.remote.IRemoteDataSource;
import com.leon.mvvm.data.remote.RetrofitServiceUtil;
import com.leon.mvvm.utils.RxUtil;
import com.leon.mvvm.ui.login.model.LoginRequest;
import com.leon.mvvm.ui.login.model.LoginResponse;
import com.leon.mvvm.ui.main.home.model.HomeTestBean;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by leon on 2017/3/11.
 */

public class DataManager {
    private static DataManager mDataManager;
    private IRemoteDataSource mRemoteDataSource;
    private ILocalDataSource mLocalDataSource;

    private DataManager(IRemoteDataSource remoteDataSource, ILocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static DataManager getInstance() {
        if (mDataManager == null) {
            synchronized (DataManager.class) {
                if (mDataManager == null) {
                    mDataManager = new DataManager(RetrofitServiceUtil.create(), new LocalDataSource());
                }
            }
        }
        return mDataManager;
    }

    private <T> Observable<T> preProcess(Observable<BaseResponse<T>> observable) {
        return observable.compose(RxUtil.applyScheduler())
            .map(RxUtil.unwrapResponse(null));
    }

    private <T> Observable<T> preProcess(Observable<BaseResponse<T>> observable, Class<T> cls) {
        return observable.compose(RxUtil.applyScheduler())
            .map(RxUtil.unwrapResponse(cls));
    }

    private Observable<EmptyResponse> preEmptyProcess(Observable<BaseResponse<EmptyResponse>> observable) {
        return preProcess(observable, EmptyResponse.class);
    }


    public Observable<LoginResponse> login(LoginRequest loginRequest) {
        return preProcess(mRemoteDataSource.login(loginRequest));
    }

    public Observable<List<HomeTestBean>> getTestList() {
        return preProcess(mRemoteDataSource.getTestList());
    }

    public Observable<EmptyResponse> getEmpty() {
        return preEmptyProcess(mRemoteDataSource.getEmpty());
    }
}

