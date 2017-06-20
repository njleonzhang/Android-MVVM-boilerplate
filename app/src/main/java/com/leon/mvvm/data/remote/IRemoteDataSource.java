package com.leon.mvvm.data.remote;

import com.leon.mvvm.BuildConfig;
import com.leon.mvvm.data.model.BaseResponse;
import com.leon.mvvm.ui.login.model.LoginRequest;
import com.leon.mvvm.ui.login.model.LoginResponse;
import com.leon.mvvm.ui.main.home.model.HomeTestBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IRemoteDataSource {
    String BASE_URL = BuildConfig.DEBUG ? "http://rapapi.org/mockjsdata/20993/" : "";
    int TIMEOUT = 10;
    int READ_TIMEOUT = 10;

    @POST("user/login/")
    Observable<BaseResponse<LoginResponse>> login(@Body LoginRequest loginRequest);

    @GET("tests/")
    Observable<BaseResponse<List<HomeTestBean>>> getTestList();
}
