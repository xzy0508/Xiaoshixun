package com.example.day01_lianxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day01_lianxi.bean.RegisterData;
import com.example.day01_lianxi.bean.VerifyData;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegsiterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mMain2Name;
    private EditText mMain2Pwd;
    private EditText mMain2Pwdok;
    private EditText mPhone;
    private EditText mYanzheng;
    private Button mMain2Regsiter;
    private String main2name;
    private String main2pwd;
    private String main2pwdok;
    private String main2phone;
    private String mainyanzheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter);
        initView();
    }

    private void initVerify() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.REGISTER)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        final Observable<VerifyData> verify = apiService.getVerify();
        verify.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<VerifyData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VerifyData verifyData) {
                        String data = verifyData.getData();
                        mYanzheng.setText(data);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView() {
        mMain2Name = (EditText) findViewById(R.id.name_main2);
        mMain2Pwd = (EditText) findViewById(R.id.pwd_main2);
        mMain2Pwdok = (EditText) findViewById(R.id.pwdok_main2);
        mPhone = (EditText) findViewById(R.id.phone);
        mYanzheng = (EditText) findViewById(R.id.yanzheng);
        mMain2Regsiter = (Button) findViewById(R.id.regsiter_main2);
        mMain2Regsiter.setOnClickListener(this);
        initVerify();
    }

    private static final String TAG = "RegsiterActivity";
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.regsiter_main2:
                // TODO 19/11/21
                initData();
                finish();
                break;
            default:
                break;
        }
    }

    private void initData() {
//        main2name = mMain2Name.getText().toString();
//        main2pwd = mMain2Pwd.getText().toString();
//        main2pwdok = mMain2Pwdok.getText().toString();
//        main2phone = mPhone.getText().toString();
//        mainyanzheng = mYanzheng.getText().toString();
//        RegisterData.DataBean dataBean = new RegisterData.DataBean();
//        dataBean.setName(main2name);
//        dataBean.setPassword(main2pwd);
//        dataBean.setPhone(main2phone);
//        dataBean.setHeader(mYanzheng);
//        Log.i("11111111111111111111", "initData: "+dataBean.toString());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.REGISTER)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        final Observable<RegisterData> register = apiService.getRegister(mMain2Name.getText().toString(),
                mMain2Pwd.getText().toString(),
                mPhone.getText().toString(),
                mYanzheng.getText().toString());
        register.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<RegisterData>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        
                    }

                    @Override
                    public void onNext(RegisterData registerData) {
                        Log.i(TAG, "onNext: "+registerData.toString());
                        if(registerData.getCode()==200){
                            Toast.makeText(RegsiterActivity.this, registerData.getRet(), Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(RegsiterActivity.this, registerData.getRet(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RegsiterActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
