package com.example.day01_lianxi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mName;
    private EditText mPwd;
    private Button mLogin;
    private Button mRegsiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mName = (EditText) findViewById(R.id.name);
        mPwd = (EditText) findViewById(R.id.pwd);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
        mRegsiter = (Button) findViewById(R.id.regsiter);
        mRegsiter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                // TODO 19/11/21
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
                break;
            case R.id.regsiter:
                // TODO 19/11/21
                Intent intent1 = new Intent(MainActivity.this, RegsiterActivity.class);
                startActivityForResult(intent1,100);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==200){
            String name = data.getStringExtra("name");
            String pwd = data.getStringExtra("pwd");
            mName.setText(name);
            mPwd.setText(pwd);
        }
    }
}
