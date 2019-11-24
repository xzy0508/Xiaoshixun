package com.example.xuzhiyuan_day02_lianxi1.model;

import com.example.xuzhiyuan_day02_lianxi1.bean.LogBean;
import com.example.xuzhiyuan_day02_lianxi1.callback.LogCallBack;

public interface LogModel {
    void getData(LogCallBack logCallBack, LogBean.DataBean logBean);

}
