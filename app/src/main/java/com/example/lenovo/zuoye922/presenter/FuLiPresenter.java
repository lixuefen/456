package com.example.lenovo.zuoye922.presenter;

import com.example.lenovo.zuoye922.FuLiCallBack;
import com.example.lenovo.zuoye922.beans.FuLiBean;
import com.example.lenovo.zuoye922.model.FuLiModel;
import com.example.lenovo.zuoye922.view.FuLiView;

import java.util.List;

/**
 * Created by lenovo on 2019/9/22.
 */

public class FuLiPresenter implements FuLiCallBack{
    private FuLiView fuLiView;
    private FuLiModel fuLiModel;

    public FuLiPresenter(FuLiView fuLiView) {
        this.fuLiView = fuLiView;
        fuLiModel = new FuLiModel();
    }
    public void initFuLi() {
        fuLiModel.initFuLi(this);
    }
    @Override
    public void OnSuccess(List<FuLiBean.ResultsBean> result) {
        fuLiView.setFuLiData(result);
    }

    @Override
    public void OnFaile(String str) {
        fuLiView.ShowTo(str);
    }
}
