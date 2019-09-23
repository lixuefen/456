package com.example.lenovo.zuoyeer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.zuoyeer.adapters.MyRvAdapter;
import com.example.lenovo.zuoyeer.beans.TeacherBean;
import com.example.lenovo.zuoyeer.presenter.TeacherPresenter;
import com.example.lenovo.zuoyeer.view.TeacherView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TeacherView{
    /**
     * 名师推荐
     */
    private TextView mToolBarTitle;
    private Toolbar mMyToolBar;
    private RecyclerView mMyRec;
    private List<TeacherBean.BodyBean.ResultBean> list;
    private TeacherPresenter teacherPresenter;
    private MyRvAdapter myRvAdapter;
    //李学峰
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teacherPresenter = new TeacherPresenter(this);
        initView();
        initToolBar();
        initRec();
    }
    private void initRec() {
        mMyRec.setLayoutManager(new LinearLayoutManager(this));
        mMyRec.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        list = new ArrayList<>();
        teacherPresenter.initTeacher();
        myRvAdapter = new MyRvAdapter(list, this);
        mMyRec.setAdapter(myRvAdapter);
    }
    private void initToolBar() {
        mMyToolBar.setTitle("");
        setSupportActionBar(mMyToolBar);
    }
    private void initView() {
        mToolBarTitle = (TextView) findViewById(R.id.ToolBarTitle);
        mMyToolBar = (Toolbar) findViewById(R.id.myToolBar);
        mMyRec = (RecyclerView) findViewById(R.id.myRec);
    }
    @Override
    public void setTeacher(List<TeacherBean.BodyBean.ResultBean> list1) {
        list.addAll(list1);
        myRvAdapter.notifyDataSetChanged();
    }
    @Override
    public void ShowTo(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
