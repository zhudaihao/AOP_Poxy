package com.example.administrator.aop_poxy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.administrator.aop_poxy.config.MyApp;
import com.example.administrator.aop_poxy.iProxy.ILogin;
import com.example.administrator.aop_poxy.proxyHandler.MyLoginProxyHandler;

import java.lang.reflect.Proxy;

/**
 * 实现代理接口
 */
public class MainActivity extends AppCompatActivity implements ILogin {

    private ILogin iLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化 代理接口实例  参数(类加载器，代理接口类，切面类)
        iLogin = (ILogin) Proxy.newProxyInstance(getClassLoader(), new Class[]{ILogin.class}, new MyLoginProxyHandler(this, getApplicationContext()));
    }

    /**
     * 用户登录后
     * 逻辑代码
     */
    @Override
    public void toLogin() {
        Log.e("zdh","--------toLogin");
        startActivity(new Intent(this, TextActivity.class));
    }


    /**
     * 需要使用代理的方法，调用接口方法
     * @param view
     */
    public void send(View view) {
        Log.e("zdh","--------send");
        iLogin.toLogin();
    }
}
