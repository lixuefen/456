package com.example.lenovo.zuoye922;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.zuoye922.adapters.MyRvAdapter;
import com.example.lenovo.zuoye922.beans.FuLiBean;
import com.example.lenovo.zuoye922.presenter.FuLiPresenter;
import com.example.lenovo.zuoye922.view.FuLiView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FuLiView{
    private RecyclerView mMyRec;
    private List<FuLiBean.ResultsBean> list;
    private FuLiPresenter fuLiPresenter;
    private MyRvAdapter myRvAdapter;
    private int _possition;
    private MyBroadCastReceiver myBroadCastReceiver;

    //李学峰
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fuLiPresenter = new FuLiPresenter(this);
        initView();
        initData();
    }

    private void initData() {
        mMyRec.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayout.VERTICAL));
        mMyRec.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        fuLiPresenter.initFuLi();
        myRvAdapter = new MyRvAdapter(list, this);
        mMyRec.setAdapter(myRvAdapter);
        myRvAdapter.setOnItemClickListener(new MyRvAdapter.OnItemClickListener() {
            @Override
            public void onLongClick(View view, int position) {
                _possition = position;
                EventBus.getDefault().postSticky(list);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });
    }
    private void initView() {
        mMyRec = (RecyclerView) findViewById(R.id.myRec);
    }

    @Override
    public void setFuLiData(List<FuLiBean.ResultsBean> result) {
        list.addAll(result);
        myRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void ShowTo(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
