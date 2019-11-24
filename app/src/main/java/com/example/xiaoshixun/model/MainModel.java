package com.example.xiaoshixun.model;

import com.example.xiaoshixun.ApiServie;
import com.example.xiaoshixun.CallBack.MainCallBack;
import com.example.xiaoshixun.bean.ResultData;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel {
    public void getData(final MainCallBack mainCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiServie.STRING)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiServie apiServie = retrofit.create(ApiServie.class);
        Observable<ResultData> data = apiServie.getData();
        data.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResultData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResultData resultData) {
                        List<ResultData.DataBean.ListBean> list = resultData.getData().getList();
                        mainCallBack.onSuccess(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
