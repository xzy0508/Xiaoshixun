package com.example.xiaoshixun.CallBack;

import com.example.xiaoshixun.bean.ResultData;

import java.util.List;

public interface MainCallBack {
    void onSuccess(List<ResultData.DataBean.ListBean> listBeans);
    void onFail(String str);
}
