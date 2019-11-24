package com.example.day01_lianxi;

import com.example.day01_lianxi.bean.RegisterData;
import com.example.day01_lianxi.bean.VerifyData;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    String REGISTER="http://yun918.cn/study/public/index.php/";
    @POST("register")
    @FormUrlEncoded
    Observable<RegisterData> getRegister(@Field("username") String username, @Field("password") String password, @Field("phone") String phone, @Field("verify") String verify);

    @GET("verify")
    Observable<VerifyData> getVerify();


}
