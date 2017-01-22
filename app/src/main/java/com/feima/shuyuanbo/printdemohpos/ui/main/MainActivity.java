package com.feima.shuyuanbo.printdemohpos.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.feima.shuyuanbo.printdemohpos.R;
import com.feima.shuyuanbo.printdemohpos.adapter.MainAdapter;
import com.feima.shuyuanbo.printdemohpos.bean.model.MainItem;
import com.feima.shuyuanbo.printdemohpos.ui.chart.ChartActivity;
import com.feima.shuyuanbo.printdemohpos.ui.print.PrintActivity;
import com.feima.shuyuanbo.printdemohpos.utils.CommonText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements MainContract.View, MainAdapter.OnItemClickListener {

    @BindView(R.id.main_recycler)
    RecyclerView mRecycler;


    private ArrayList<MainItem> mDatas = new ArrayList<>();
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        initData();
    }

    private void initData() {
        MainItem item = new MainItem("s300打印",0xff334466, CommonText.LIST_MODE_PRINT_S300);
        MainItem item2 = new MainItem("如泰打印",0xff447766, CommonText.LIST_MODE_PRINT_RUTAI);
        MainItem item3 = new MainItem("图表爆炸",0xff886644,CommonText.LIST_MODE_CAHRT);
        mDatas.add(item);
        mDatas.add(item3);
        mDatas.add(item2);
        refreshData();
    }

    private void refreshData() {
        if (mAdapter == null){
            mAdapter = new MainAdapter(this,mDatas);
            mRecycler.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(this);
        }else{
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @Override
    public void onItemClick(View v, int mode) {
        switch (mode){
            case CommonText.LIST_MODE_PRINT_S300:
                openActivity(PrintActivity.class);
                break;
            case CommonText.LIST_MODE_PRINT_RUTAI:
                break;
            //图表
            case CommonText.LIST_MODE_CAHRT:
                openActivity(ChartActivity.class);
                break;
            default:
                break;
        }
    }

    private void openActivity(Class clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }
}
