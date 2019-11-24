package com.example.xuzhiyuan_day02_lianxi1.presenter;

import com.example.xuzhiyuan_day02_lianxi1.bean.LogBean;
import com.example.xuzhiyuan_day02_lianxi1.callback.LogCallBack;
import com.example.xuzhiyuan_day02_lianxi1.model.ImpLogModel;
import com.example.xuzhiyuan_day02_lianxi1.view.LogView;

public class ImpLogPresenter implements LogPrestenter, LogCallBack {
    private ImpLogModel impLogModel;
    private LogView logView;

    public ImpLogPresenter(LogView logView) {
        this.logView = logView;
        impLogModel  =new ImpLogModel();
    }

    @Override
    public void getData(LogBean.DataBean logBean) {
        if (impLogModel!=null){
            impLogModel.getData(this,logBean);
        }
    }

    @Override
    public void onSucess(String success) {
        if (logView!=null){
            logView.onSucess(success);
        }

    }

    @Override
    public void onFaile(String error) {
        if (logView!=null){
            logView.onFaile(error);
        }
    }
}
