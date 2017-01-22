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

import com.feima.shuyuanbo.printdemohpos.R;
import com.feima.shuyuanbo.printdemohpos.bean.model.ChartItem;
import com.feima.shuyuanbo.printdemohpos.bean.model.MainItem;

import java.util.ArrayList;

/**
 * Created by shuyuanbo on 17/1/19.
 */

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.ChartViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<ChartItem> mDatas;

    private OnItemClickListener mOnItemClickListener;


    //定义item点击接口
    public interface OnItemClickListener{
        void onItemClick(View v, int mode);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener ;
    }

    public ChartAdapter(Context context, ArrayList<ChartItem> datas){
        this.mContext = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public ChartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_chart_item,parent,false);
        ChartViewHolder holder = new ChartViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ChartViewHolder holder, int position) {
        setOnListener(holder,position);
        ChartItem item = mDatas.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvDesc.setText(item.getDesc());

    }



    @Override
    public int getItemCount() {
        return mDatas == null?0:mDatas.size();
    }

    class ChartViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvDesc;
        public ChartViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.adapter_chart_tvtitle);
            tvDesc = (TextView) itemView.findViewById(R.id.adapter_chart_tvdesc);
        }
    }

    private void setOnListener(final ChartViewHolder holder, final int position) {
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
