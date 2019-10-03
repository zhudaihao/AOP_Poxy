package com.example.administrator.aop_poxy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.administrator.aop_poxy.config.MyApp;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("alan","--------------LoginActivity");
    }

    public void login(View view) {
        MyApp.getInstance().setLogin(true);
    }
}
