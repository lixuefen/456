package com.example.lenovo.zuoyeer;

import com.example.lenovo.zuoyeer.beans.TeacherBean;

import java.util.List;

/**
 * Created by lenovo on 2019/9/22.
 */

public interface TeacherCallBack {
    void OnSuccess(List<TeacherBean.BodyBean.ResultBean> list1);
    void OnFalie(String str);
}
