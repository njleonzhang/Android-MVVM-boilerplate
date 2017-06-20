package com.leon.mvvm.ui.login.model;

/**
 * Created by leon on 2017/6/20.
 */

public class LoginRequest {
    /**
     * cellphone : "10012345678"
     * password : "1234"
     */

    private String cellphone;
    private String password;

    public LoginRequest(String cellphone, String password) {
        this.cellphone = cellphone;
        this.password = password;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
