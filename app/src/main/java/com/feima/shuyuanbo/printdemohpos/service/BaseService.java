package com.feima.shuyuanbo.printdemohpos.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
/**
 * Created by shuyuanbo on 17/1/20.
 * 服务基类
 */
import com.feima.shuyuanbo.printdemohpos.utils.LogUtils;

public abstract class BaseService extends Service {


    @Override
    public void onCreate() {
        LogUtils.d("BaseService-->onCreate()");
        super.onCreate();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onStart(Intent intent, int startId) {
        LogUtils.d("BaseService-->onStart()");
        super.onStart(intent, startId);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.d( "BaseService-->onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        LogUtils.d( "BaseService-->onDestroy()");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.d( "BaseService-->onBind()");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.d("BaseService-->onUnbind()");
        return super.onUnbind(intent);
    }
}
