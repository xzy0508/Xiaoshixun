package com.example.xiaoshixun.view;

import com.example.xiaoshixun.bean.ResultData;

import java.util.List;

public interface MainView {
    void setData(List<ResultData.DataBean.ListBean> listBeans);
    void showToast(String str);
}
