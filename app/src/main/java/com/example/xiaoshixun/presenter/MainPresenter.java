package com.example.xiaoshixun.presenter;

import com.example.xiaoshixun.CallBack.MainCallBack;
import com.example.xiaoshixun.bean.ResultData;
import com.example.xiaoshixun.model.MainModel;
import com.example.xiaoshixun.view.MainView;

import java.util.List;

public class MainPresenter implements MainCallBack {
    private MainModel mainModel;
    private MainView mainView;
    public MainPresenter(MainView mainView) {
        this.mainView=mainView;
        this.mainModel=new MainModel();
    }

    public void getData() {
        mainModel.getData(this);
    }

    @Override
    public void onSuccess(List<ResultData.DataBean.ListBean> listBeans) {
        mainView.setData(listBeans);
    }

    @Override
    public void onFail(String str) {
        mainView.showToast(str);
    }
}
