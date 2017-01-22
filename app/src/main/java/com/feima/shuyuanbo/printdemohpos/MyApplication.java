package com.feima.shuyuanbo.printdemohpos;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;

import com.feima.shuyuanbo.printdemohpos.config.SysEnv;
import com.feima.shuyuanbo.printdemohpos.service.MyNetworkListener;

/**
 * Created by shuyuanbo on 17/1/20.
 */

public class MyApplication extends Application {


    /**应用程序版本versionName**/
    public static String version = "error";
    /** 设备ID **/
    public static String deviceId = "error";

    /**对外提供整个应用生命周期的Context**/
    private static Context instance;

    public static int mScreenWidth = 0;
    public static int mScreenHeight = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
        Intent intent = new Intent(this, MyNetworkListener.class);
        startService(intent);
    }


    public static Context gainContext() {
        return instance;
    }

    private void init() {
        //应用程序版本
        version = SysEnv.getVersionName();
        //设备ID
        deviceId = SysEnv.DEVICE_ID;
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);

        mScreenWidth = windowManager.getDefaultDisplay().getWidth();
        mScreenHeight = windowManager.getDefaultDisplay().getHeight();
    }

    public void exit(){
        Intent intent = new Intent(this, MyNetworkListener.class);
        stopService(intent);
    }

}
