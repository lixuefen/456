package com.example.lenovo.zuoye922.view;

import com.example.lenovo.zuoye922.beans.FuLiBean;

import java.util.List;

/**
 * Created by lenovo on 2019/9/22.
 */

public interface FuLiView {
    void setFuLiData(List<FuLiBean.ResultsBean> result);
    void ShowTo(String str);
}
