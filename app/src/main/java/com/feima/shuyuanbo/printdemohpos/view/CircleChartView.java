package com.feima.shuyuanbo.printdemohpos.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;

import com.feima.shuyuanbo.printdemohpos.utils.LogUtils;

import org.xclcharts.chart.GaugeChart;
import org.xclcharts.view.GraphicalView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shuyuanbo on 17/1/20.
 */

public class CircleChartView extends GraphicalView {

    private GaugeChart chart = new GaugeChart();

    private List<String> mLabels = new ArrayList<String>();
    private List<Pair> mPartitionSet = new ArrayList<Pair>();
    private float mAngle = 0.0f;

    public CircleChartView(Context context) {
        super(context);
        initView();
    }

    public CircleChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CircleChartView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //图所占范围大小
        //xml中的设置:  android:layout_width="300dip"
        //			   android:layout_height="300dip"
        chart.setChartRange(w ,h );
        //绘图区范围
        //左右各缩进10%
        //int offsetX = DensityUtil.dip2px(getContext(), (float) (300 * 0.1));
        //偏移高度的25%下来
        //int offsetY = DensityUtil.dip2px(getContext(), (float) (300 * 0.25));
        // chart.setPadding(offsetY, 0, 0,  0);

    }

    private void initView()
    {
        chartLabels();
        chartDataSet();
        chartRender();
    }




    //图表模块名字
    private void chartLabels() {
        mLabels.add("0 km/h");
        mLabels.add("40 km/h");
        mLabels.add("80 km/h");
        mLabels.add("120 km/h");
        mLabels.add("160 km/h");
    }


    //图表区域模块
    private void chartDataSet() {
        int angle = 180;
        for (int i = 0;i<mLabels.size();i++){
            int currentAngle = (i == mLabels.size() -1 ?angle:(int) (Math.random()*45));
            mPartitionSet.add(new Pair<Float,Integer>((float)36,
                    Color.rgb((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255))));
            angle -= currentAngle;
        }
    }

    @Override
    public void render(Canvas canvas) {
        try {
            chart.render(canvas);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e(e.toString());
        }
    }

    public void chartRender() {
        try {

            //设置标题
            //chart.setTitle("刻度盘 ");

            //刻度步长
            chart.setTickSteps(10d);

            //标签(标签和步长分开，步长即刻度可以密点，标签可以松点)
            chart.setCategories(mLabels);
            //分区
            chart.setPartition(mPartitionSet);

            //设置当前指向角度(0-180).
            //chart.setCurrentAngle(90f);
            chart.setCurrentAngle(mAngle);
            //绘制边框
            chart.showRoundBorder();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            LogUtils.e(e.toString());
        }
    }

    public void setmAngle(float mAngle) {
        this.mAngle = mAngle;
    }

    //获得基类图表对象
    public GaugeChart getChart(){
        return this.chart;
    }
}
