package practice.code.com.baseframework.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import practice.code.com.baseframework.App;
import practice.code.com.baseframework.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayoutID());
        App.activity = this;
        ButterKnife.bind(this);
        initView();
        initData();
        initListener();
        loadData();
    }
    //  初始化布局
     protected abstract int initLayoutID();

    //初始化 view (findID)
    protected abstract void initView();

    //初始化 数据的
    protected abstract void initData();

// 加载数据的
    protected abstract void loadData();

//    初始化 监听的
    protected abstract void initListener();

}
