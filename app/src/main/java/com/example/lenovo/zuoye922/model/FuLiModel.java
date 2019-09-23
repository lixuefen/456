package com.example.lenovo.zuoye922.model;

import com.example.lenovo.zuoye922.ApiService;
import com.example.lenovo.zuoye922.FuLiCallBack;
import com.example.lenovo.zuoye922.beans.FuLiBean;
import com.example.lenovo.zuoye922.presenter.FuLiPresenter;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lenovo on 2019/9/22.
 */

public class FuLiModel {
    public void initFuLi(final FuLiCallBack fuLiCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.FuLiURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Observable<FuLiBean> observable = service.getFuLi();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuLiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FuLiBean fuLiBean) {
                        if (fuLiBean!=null){
                            List<FuLiBean.ResultsBean> result = fuLiBean.getResults();
                            fuLiCallBack.OnSuccess(result);
                        }else {
                            fuLiCallBack.OnFaile("请求失败");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
