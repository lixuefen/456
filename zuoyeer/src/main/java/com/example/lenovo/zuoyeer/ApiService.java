package com.example.lenovo.zuoyeer;

import com.example.lenovo.zuoyeer.beans.TeacherBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by lenovo on 2019/9/22.
 */

public interface ApiService {
    String URL = "https://api.yunxuekeji.cn/";
    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<TeacherBean> getTeacher();
}
