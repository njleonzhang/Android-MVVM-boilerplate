package com.leon.mvvm.data.utils;

import com.leon.mvvm.data.constants.Constants;
import com.leon.mvvm.data.model.BaseResponse;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by leon on 2017/3/14.
 */

public class RxUtil {
    public static <T> ObservableTransformer<T, T> applyScheduler() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> Function<BaseResponse<T>, T> unwrapResponse() {
        return baseResponse -> {
            if (baseResponse.getCode().equals(Constants.SUCCESS_CODE)) {
                // 返回数据成功, 如果服务器没有返回data字段，则这里return null，会导致空指针异常。
                // 所以对于data可能是空的请求，不应该用这个函数处理。
                return baseResponse.getData();
            } else if (baseResponse.getCode().equals(Constants.USER_NOT_LOGGED_IN)) {
                // auth token过期
                throw new UserNotLoginException(baseResponse.getMsg());
            }
            // 未知错误
            throw new UnknownServerException(baseResponse.getMsg());
        };
    }

    public static class UserNotLoginException extends Exception {
        public UserNotLoginException(String message) {
            super(message);
        }

        public UserNotLoginException() {
            super();
        }
    }

    public static class UnknownServerException extends Exception {
        public UnknownServerException(String message) {
            super(message);
        }
    }
}


