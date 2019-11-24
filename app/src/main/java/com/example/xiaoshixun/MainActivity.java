package com.example.xiaoshixun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private TextView mTextview;
    private EditText mMoney;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTextview = (TextView) findViewById(R.id.textview);
        mMoney = (EditText) findViewById(R.id.money);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);

        mToolbar.setTitle("首页");
        setSupportActionBar(mToolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                // TODO 19/11/18
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("money",mMoney.getText().toString());
                startActivityForResult(intent,200);
                break;
            default:
                break;
        }
    }
}