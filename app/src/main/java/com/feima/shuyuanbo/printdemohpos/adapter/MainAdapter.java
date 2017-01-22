package com.feima.shuyuanbo.printdemohpos.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.feima.shuyuanbo.printdemohpos.bean.model.MainItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuyuanbo on 17/1/19.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<MainItem> mDatas;

    private OnItemClickListener mOnItemClickListener;


    //定义item点击接口
    public interface OnItemClickListener{
        void onItemClick(View v, int mode);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener ;
    }

    public  MainAdapter(Context context,ArrayList<MainItem> datas){
        this.mContext = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = new TextView(mContext);
        MainViewHolder holder = new MainViewHolder(tv);
        return holder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        setOnListener(holder,position);
        MainItem item = mDatas.get(position);
        holder.tv.setText(item.getText());
        holder.tv.setTextColor(Color.WHITE);
        holder.tv.setTextSize(20);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.height = 100;
        params.topMargin = 10;
        holder.tv.setGravity(Gravity.CENTER);
        holder.tv.setLayoutParams(params);
        holder.tv.setBackgroundColor(item.getColor());
    }



    @Override
    public int getItemCount() {
        return mDatas == null?0:mDatas.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        public MainViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView;
        }
    }

    private void setOnListener(final MainViewHolder holder, final int position) {
        if (mOnItemClickListener == null){
            return;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view,mDatas.get(position).getMode());
            }
        });
    }
}
