package com.example.lenovo.zuoyeer.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.lenovo.zuoyeer.R;
import com.example.lenovo.zuoyeer.beans.TeacherBean;

import java.util.List;

/**
 * Created by lenovo on 2019/9/22.
 */

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.ViewHolder>{
    private List<TeacherBean.BodyBean.ResultBean> list;
    private Context context;

    public MyRvAdapter(List<TeacherBean.BodyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context,R.layout.item_layout,null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(context).load(list.get(position).getTeacherPic()).apply(options).into(holder.TeacherPic);
        holder.TeacherName.setText(list.get(position).getTeacherName());
        holder.Title.setText(list.get(position).getTitle());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView TeacherPic;
        TextView TeacherName;
        TextView Title;
        public ViewHolder(View itemView) {
            super(itemView);
            TeacherPic = itemView.findViewById(R.id.TeacherPic);
            TeacherName = itemView.findViewById(R.id.TeacherName);
            Title = itemView.findViewById(R.id.Title);
        }
    }
}
