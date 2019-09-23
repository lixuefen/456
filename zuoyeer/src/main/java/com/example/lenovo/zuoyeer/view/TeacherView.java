package com.example.lenovo.zuoyeer.view;

import com.example.lenovo.zuoyeer.beans.TeacherBean;

import java.util.List;

/**
 * Created by lenovo on 2019/9/22.
 */

public interface TeacherView {
    void setTeacher(List<TeacherBean.BodyBean.ResultBean> list1);
    void ShowTo(String str);
}
