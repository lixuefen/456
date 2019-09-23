package com.example.lenovo.zuoye922;

import com.example.lenovo.zuoye922.beans.FuLiBean;

import java.util.List;

/**
 * Created by lenovo on 2019/9/22.
 */

public interface FuLiCallBack {
    void OnSuccess(List<FuLiBean.ResultsBean> result);
    void OnFaile(String str);
}
