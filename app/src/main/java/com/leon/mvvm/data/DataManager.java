package com.leon.mvvm.data;

import com.leon.mvvm.data.local.ILocalDataSource;
import com.leon.mvvm.data.local.LocalDataSource;
import com.leon.mvvm.data.model.BaseResponse;
import com.leon.mvvm.data.remote.IRemoteDataSource;
import com.leon.mvvm.data.remote.RetrofitServiceUtil;
import com.leon.mvvm.data.utils.RxUtil;
import com.leon.mvvm.ui.login.model.LoginRequest;
import com.leon.mvvm.ui.login.model.LoginResponse;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

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

    public <T> Observable<T> preProcess(Observable<BaseResponse<T>> observable) {
        return observable.compose(RxUtil.applyScheduler())
            .map(RxUtil.unwrapResponse());
    }

    public Observable<LoginResponse> login(LoginRequest loginRequest) {
        return preProcess(mRemoteDataSource.login(loginRequest));
    }
}

