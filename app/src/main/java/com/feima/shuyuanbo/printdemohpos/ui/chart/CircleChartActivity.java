package com.feima.shuyuanbo.printdemohpos.ui.chart;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.feima.shuyuanbo.printdemohpos.MyApplication;
import com.feima.shuyuanbo.printdemohpos.R;
import com.feima.shuyuanbo.printdemohpos.config.SysEnv;
import com.feima.shuyuanbo.printdemohpos.service.MyGestureListener;
import com.feima.shuyuanbo.printdemohpos.ui.base.BaseActivity;
import com.feima.shuyuanbo.printdemohpos.utils.LogUtils;
import com.feima.shuyuanbo.printdemohpos.view.CircleChartView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shuyuanbo on 17/1/20.
 */

public class CircleChartActivity extends BaseActivity {


    @BindView(R.id.circlechart_view)
    CircleChartView mChartView;

    float x_down = 0;
    float y_down = 0;
    float mDegree = 0.0f;

    @Override
    public void initView() {
        setContentView(R.layout.activity_chart_circle);
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        LogUtils.d("touch了"+event.toString());
        switch (event.getAction() & MotionEvent.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                LogUtils.d("-----down");
                x_down = event.getX();
                y_down = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                LogUtils.d("------up");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtils.d("------move");
                float yChange = y_down - event.getY();
                y_down = event.getY();
                LogUtils.d(yChange+"");
                changePoint(yChange);
                break;
            default:
                break;
        }
        return true;
    }

    private void changePoint(float yChange) {
        float changeD = yChange/(SysEnv.SCREEN_HEIGHT)*180;
        LogUtils.d("changed----"+changeD);
        mDegree += changeD;
        LogUtils.d("degree----"+mDegree);
        mChartView.setmAngle(mDegree);
        mChartView.chartRender();
        mChartView.invalidate();
    }
}
