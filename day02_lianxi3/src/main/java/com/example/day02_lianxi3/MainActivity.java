package com.example.day02_lianxi3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private ArrayList<ResultData.DataBean.DatasBean> datasBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        datasBeans = new ArrayList<>();
    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
    }
}
