package com.feima.shuyuanbo.printdemohpos.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by shuyuanbo on 17/1/19.
 */

public  abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        initData();
    }
    public abstract void initView() ;

    protected   void initListener(){

    }

    protected abstract void initData();

    public void showToast(String notice) {

        Toast.makeText(this, notice, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String notice){
        Toast.makeText(this, notice, Toast.LENGTH_LONG).show();
    }

    protected void openActivity(Context context,Class clazz){
        Intent intent = new Intent(context,clazz);
        startActivity(intent);
    }
}
