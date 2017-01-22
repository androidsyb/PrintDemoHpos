package com.feima.shuyuanbo.printdemohpos.service;

import android.view.GestureDetector;
import android.view.MotionEvent;

import com.feima.shuyuanbo.printdemohpos.utils.LogUtils;

/**
 * Created by shuyuanbo on 17/1/20.
 */

public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        LogUtils.d("onsingleTapup");
        return super.onSingleTapUp(e);

    }

    @Override
    public void onShowPress(MotionEvent e) {
        LogUtils.d("onShowPress");
        super.onShowPress(e);
    }


    @Override
    public void onLongPress(MotionEvent e) {
        LogUtils.d("onLongPress");
        super.onLongPress(e);
    }
}
