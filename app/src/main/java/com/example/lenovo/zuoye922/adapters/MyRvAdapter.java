package com.example.lenovo.zuoye922.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.lenovo.zuoye922.R;
import com.example.lenovo.zuoye922.beans.FuLiBean;

import java.util.List;

/**
 * Created by lenovo on 2019/9/22.
 */

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.ViewHolder>{
    private List<FuLiBean.ResultsBean> list;
    private Context context;

    public MyRvAdapter(List<FuLiBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.fuli_item_layout,null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(list.get(position).getUrl()).into(holder.url);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemClickListener.onLongClick(v, position);
                return false;
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView url;
        public ViewHolder(View itemView) {
            super(itemView);
            url = itemView.findViewById(R.id.url);
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onLongClick(View view, int position);
    }
}
