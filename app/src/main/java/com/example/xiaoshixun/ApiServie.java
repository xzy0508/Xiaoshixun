package com.example.xiaoshixun;

import com.example.xiaoshixun.bean.ResultData;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiServie {
    String STRING="http://yun918.cn/";
    @GET("ks/jiekou.json")
    Observable<ResultData> getData();
}
