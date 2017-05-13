package practice.code.com.baseframework.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

import com.androidkun.PullToRefreshRecyclerView;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import practice.code.com.baseframework.App;
import practice.code.com.baseframework.R;
import practice.code.com.baseframework.adapter.RefishRV;
import practice.code.com.baseframework.model.biz.ICallBack;
import practice.code.com.baseframework.model.entity.MessageEntity;
import practice.code.com.baseframework.model.util.MessageUtil;

public class MainActivity extends AppCompatActivity implements ICallBack {

    @Bind(R.id.main_bt)
    Button mainBt;
    @Bind(R.id.main_fresh_rv)
    PullToRefreshRecyclerView mainFreshRv;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;
    int pageIndex = 1;
    @Bind(R.id.login_bt)
    Button loginBt;
    @Bind(R.id.go_fragment)
    Button goFragment;
    private MessageUtil messageUtil;
    RefishRV refishRV;
    ArrayList<MessageEntity.NewsBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.activity = this;
        initdata();
        messageUtil.getMessageList(pageIndex, this);

    }

    public void initdata() {
        messageUtil = new MessageUtil();
        list = new ArrayList<>();
        refishRV = new RefishRV(this, list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        mainFreshRv.setLayoutManager(linearLayoutManager);
        mainFreshRv.setAdapter(refishRV);
    }

    @OnClick(R.id.main_bt)
    public void onViewClicked() {

        messageUtil.getMessageList(pageIndex++, this);


    }

    @Override
    public void succeed(String mgs) {
        Log.e("mainactivity", mgs);
        XStream xStream = new XStream();
        xStream.alias("oschina", MessageEntity.class);
        xStream.alias("news", MessageEntity.NewsBean.class);
        MessageEntity messageEntity = (MessageEntity) xStream.fromXML(mgs);
        List<MessageEntity.NewsBean> newslist = messageEntity.getNewslist();
        list.addAll(newslist);
        refishRV.notifyDataSetChanged();
    }

    @Override
    public void fail(String mgs) {
        Log.e("mainactivity", mgs);
    }

    @OnClick(R.id.login_bt)
    public void onloginClicked() {

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    @OnClick(R.id.go_fragment)
    public void onfragmentClicked() {
        Intent intent = new Intent(MainActivity.this,GoFragmentActivity.class);
        startActivity(intent);
    }
}
