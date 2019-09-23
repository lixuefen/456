package com.example.lenovo.zuoye922;

import com.example.lenovo.zuoye922.beans.FuLiBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2019/9/22.
 */

public interface ApiService {
    String FuLiURL = "http://gank.io/api/";
    @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<FuLiBean> getFuLi();
}
