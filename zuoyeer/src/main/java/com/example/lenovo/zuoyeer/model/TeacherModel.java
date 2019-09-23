package com.example.lenovo.zuoyeer.model;

import com.example.lenovo.zuoyeer.ApiService;
import com.example.lenovo.zuoyeer.TeacherCallBack;
import com.example.lenovo.zuoyeer.beans.TeacherBean;
import com.example.lenovo.zuoyeer.presenter.TeacherPresenter;

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

public class TeacherModel {
    public void initTeacher(final TeacherCallBack teacherCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService service = retrofit.create(ApiService.class);
        Observable<TeacherBean> observable = service.getTeacher();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TeacherBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TeacherBean teacherBean) {
                        if (teacherBean!=null){
                            List<TeacherBean.BodyBean.ResultBean> list1 = teacherBean.getBody().getResult();
                            teacherCallBack.OnSuccess(list1);
                        }else {
                            teacherCallBack.OnFalie("请求失败");
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
