package com.leon.mvvm.data.remote;

import com.leon.mvvm.data.local.ILocalDataSource;
import com.leon.mvvm.data.local.LocalDataSource;
import com.leon.mvvm.data.model.BaseResponse;
import com.leon.mvvm.data.utils.RxUtil;

import java.io.File;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by leon on 2017/3/11.
 */

// todo 改成单例 + 使用dagger注入
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
}

