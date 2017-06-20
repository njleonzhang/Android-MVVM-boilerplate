package com.leon.mvvm.data.model;

import java.io.Serializable;

public class BaseResponse<E> implements Serializable {
    private String code;
    private String msg;
    private E data;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public E getData() {
        return data;
    }
}
