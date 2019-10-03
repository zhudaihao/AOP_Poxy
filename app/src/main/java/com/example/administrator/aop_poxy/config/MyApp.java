package com.example.administrator.aop_poxy.config;

import android.app.Application;

public class MyApp extends Application {


    private static MyApp myApp;

    public static MyApp getInstance() {
        return myApp;
    }

    private boolean isLogin =false;
    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
