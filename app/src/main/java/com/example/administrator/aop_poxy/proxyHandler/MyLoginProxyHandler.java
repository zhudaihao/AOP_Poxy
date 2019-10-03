package com.example.administrator.aop_poxy.proxyHandler;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.administrator.aop_poxy.LoginActivity;
import com.example.administrator.aop_poxy.MainActivity;
import com.example.administrator.aop_poxy.config.MyApp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理 切面类
 */
public class MyLoginProxyHandler implements InvocationHandler {

    private Object proxyTag;
    private Context context;

    public MyLoginProxyHandler(Object proxyTag, Context context) {
        this.proxyTag = proxyTag;
        this.context = context;
    }

    /**
     * @param proxy
     * @param method
     * @param args 代理对象传递的参数（代码对象构造方法参数--》MyLoginProxyHandler构造方法参数）
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        //如果登录就执行 代理接口方法，没有就执行else代码
        if (MyApp.getInstance().isLogin()) {
            //参数（代理接口实现类 ，invoke方法第三个参数args）
            //代码执行这里 会回调接口方法
            //如果不调用这个方法，接口方法不会回调
            object = method.invoke(proxyTag, args);

            Log.e("zdh","----invoke----登录"+"-------");
        } else {
            //去登录

            context.startActivity(new Intent(context,LoginActivity.class));

            Log.e("zdh","-----invoke---没有登录");
        }
        return object;
    }
}
