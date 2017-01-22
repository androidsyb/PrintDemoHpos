package com.feima.shuyuanbo.printdemohpos.ui.chart;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.feima.shuyuanbo.printdemohpos.R;
import com.feima.shuyuanbo.printdemohpos.adapter.ChartAdapter;
import com.feima.shuyuanbo.printdemohpos.bean.model.ChartItem;
import com.feima.shuyuanbo.printdemohpos.ui.base.BaseActivity;
import com.feima.shuyuanbo.printdemohpos.utils.CommonText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shuyuanbo on 17/1/20.
 */

public class ChartActivity extends BaseActivity implements ChartAdapter.OnItemClickListener {


    @BindView(R.id.chart_recycler)
    RecyclerView mRecycler;
    private ArrayList<ChartItem> mDatas = new ArrayList<>();
    private ChartAdapter mAdapter;

    @Override
    public void initView() {
        setContentView(R.layout.activity_chart);
        ButterKnife.bind(this);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {
        ChartItem item = new ChartItem("刻度均分图","可展示分布式水平模块", CommonText.CAHRT_MODE_CIRCLE);
        mDatas.add(item);
        refreshData();
    }

    private void refreshData() {
        if (mAdapter == null){
            mAdapter = new ChartAdapter(this,mDatas);
            mRecycler.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(this);
        }else{
            mAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onItemClick(View v, int mode) {
        switch (mode){
            case CommonText.CAHRT_MODE_CIRCLE:
                openActivity(ChartActivity.this,CircleChartActivity.class);
                break;

            default:
                break;
        }
    }
}
