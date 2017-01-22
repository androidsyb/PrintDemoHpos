package com.feima.shuyuanbo.printdemohpos.service;

import android.widget.Toast;

/**
 * Created by shuyuanbo on 17/1/20.
 */

public class MyNetworkListener extends NetWorkStateService {
    @Override
    public void onNoNetwork() {
        Toast.makeText(getApplicationContext(),"网络链接已断开,请确认网络",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNetworkChange(String networkType) {
        Toast.makeText(getApplicationContext(),"当前网络为----"+networkType,Toast.LENGTH_SHORT).show();
    }
}
