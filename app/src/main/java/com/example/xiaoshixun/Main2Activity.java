package com.example.xiaoshixun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xiaoshixun.adapter.RecyclerAdapter;
import com.example.xiaoshixun.bean.ResultData;
import com.example.xiaoshixun.presenter.MainPresenter;
import com.example.xiaoshixun.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, MainView {

    private Toolbar mMain2Toolbar;
    private EditText mPhone;
    private EditText mPhoneOk;
    private TextView mYuMoney;
    private RecyclerView mRecyclerview;
    private Button mCancle;
    private Button mOk;
    private List<ResultData.DataBean.ListBean> listBeans;
    private MainPresenter mainPresenter;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mainPresenter = new MainPresenter(this);
        initView();
        initToolbar();
        yuMoney();
        initData();
    }

    private void initData() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        listBeans = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(listBeans, this);
        mRecyclerview.setAdapter(recyclerAdapter);

        mainPresenter.getData();


    }

    private void yuMoney() {
        Intent intent = getIntent();
        String money = intent.getStringExtra("money");
        mYuMoney.setText("账户余额:"+money);
        setResult(100,intent);
    }

    private void initToolbar() {
        mMain2Toolbar.setTitle("兑换");
        setSupportActionBar(mMain2Toolbar);
    }

    private void initView() {
        mMain2Toolbar = (Toolbar) findViewById(R.id.toolbar_main2);
        mPhone = (EditText) findViewById(R.id.phone);
        mPhoneOk = (EditText) findViewById(R.id.ok_phone);
        mYuMoney = (TextView) findViewById(R.id.money_yu);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        mCancle = (Button) findViewById(R.id.cancle);
        mCancle.setOnClickListener(this);
        mOk = (Button) findViewById(R.id.ok);
        mOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancle:
                // TODO 19/11/18
                finish();
                break;
            case R.id.ok:
                // TODO 19/11/18
                String mphone_string = mPhone.getText().toString();
                String mphoneok_string = mPhoneOk.getText().toString();
                if (mphone_string.equals(mphoneok_string)&&!mphone_string.isEmpty()&&!mphoneok_string.isEmpty()&&mphone_string.length()==11){
                    Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(this, "输入错误，请重新输入", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void setData(List<ResultData.DataBean.ListBean> listBeans) {
        this.listBeans.clear();
        this.listBeans.addAll(listBeans);
        recyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(Main2Activity.this, str, Toast.LENGTH_SHORT).show();
    }
}
