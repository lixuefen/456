package com.example.lenovo.zuoye922;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by lenovo on 2019/9/22.
 */

public class VpFragment extends Fragment {
    private View view;
    private ImageView mVpImg;
    private TextView mTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.vp_fragment_layout, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mVpImg = (ImageView) view.findViewById(R.id.vpImg);
        mTv = (TextView) view.findViewById(R.id.tv);
        Bundle arguments = getArguments();
        String imgurl = (String) arguments.get("imgurl");
        Glide.with(getActivity()).load(imgurl).into(mVpImg);
        int i = arguments.getInt("i");
        int count = arguments.getInt("count");

        mTv.setText("第"+i+"张/共"+count+"张");
    }
}
