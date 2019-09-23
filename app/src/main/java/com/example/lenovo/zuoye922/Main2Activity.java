package com.example.lenovo.zuoye922;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.lenovo.zuoye922.beans.FuLiBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mMyVp;
    private TextView mShow;
    private ArrayList<VpFragment> list;
    private MyVpFragmentAdapter myVpFragmentAdapter;
    private List<FuLiBean.ResultsBean> list1;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EventBus.getDefault().register(this);
        initView();
        initVp();
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getMess(List<FuLiBean.ResultsBean> list){
        list1 = list;
    }


    private void initVp() {

        list = new ArrayList<>();
        for (int i = 0;i<list1.size();i++){
            VpFragment vpFragment = new VpFragment();
            Bundle bundle = new Bundle();
            bundle.putString("imgurl",list1.get(i).getUrl());
            bundle.putInt("i",(i+1));
            bundle.putInt("count",list1.size());
            vpFragment.setArguments(bundle);
            list.add(vpFragment);
        }
        myVpFragmentAdapter = new MyVpFragmentAdapter(getSupportFragmentManager(), list);
        mMyVp.setAdapter(myVpFragmentAdapter);


    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


    private void initView() {
        mMyVp = (ViewPager) findViewById(R.id.myVp);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", 2000);

    }
}
