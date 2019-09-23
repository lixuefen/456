package com.example.lenovo.zuoyeer.presenter;

import com.example.lenovo.zuoyeer.TeacherCallBack;
import com.example.lenovo.zuoyeer.beans.TeacherBean;
import com.example.lenovo.zuoyeer.model.TeacherModel;
import com.example.lenovo.zuoyeer.view.TeacherView;

import java.util.List;

/**
 * Created by lenovo on 2019/9/22.
 */

public class TeacherPresenter implements TeacherCallBack{
    private TeacherView teacherView;
    private TeacherModel teacherModel;

    public TeacherPresenter(TeacherView teacherView) {
        this.teacherView = teacherView;
        teacherModel = new TeacherModel();
    }
    public void initTeacher() {
        teacherModel.initTeacher(this);
    }
    @Override
    public void OnSuccess(List<TeacherBean.BodyBean.ResultBean> list1) {
        teacherView.setTeacher(list1);
    }

    @Override
    public void OnFalie(String str) {
        teacherView.ShowTo(str);
    }
}
