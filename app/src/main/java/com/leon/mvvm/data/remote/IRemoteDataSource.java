package com.leon.mvvm.data.remote;

import com.leon.mvvm.BuildConfig;

public interface IRemoteDataSource {
    String BASE_URL = BuildConfig.DEBUG ? "http://106.15.57.239/" : "https://web.myiot360.com/";
    int TIMEOUT = 10;
    int READ_TIMEOUT = 10;
}
