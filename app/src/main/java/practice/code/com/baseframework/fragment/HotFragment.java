package practice.code.com.baseframework.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidkun.PullToRefreshRecyclerView;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import practice.code.com.baseframework.App;
import practice.code.com.baseframework.R;
import practice.code.com.baseframework.adapter.RefishRV;
import practice.code.com.baseframework.model.biz.ICallBack;
import practice.code.com.baseframework.model.entity.MessageEntity;
import practice.code.com.baseframework.model.util.MessageUtil;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class HotFragment extends BaseFragmnet implements ICallBack{
    @Bind(R.id.pull_rv)
    PullToRefreshRecyclerView pullRv;
    int flag = 1;
    private MessageUtil messageUtil;
    private List<MessageEntity.NewsBean> newslist;
    private List<MessageEntity.NewsBean> allNewslist;
    private RefishRV refishRV;

    @Override
    protected int initLayoutID() {
        return R.layout.fragment_pull_rv;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        allNewslist = new ArrayList<>();
        refishRV = new RefishRV(App.activity,allNewslist);

       if(allNewslist != null){
           for(int i = 0; i <allNewslist.size();i++){
               Log.e("tttt",allNewslist.get(i).getAuthor());
           }
       }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(App.activity);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        pullRv.setLayoutManager(linearLayoutManager);

        pullRv.setAdapter(refishRV);
    }

    @Override
    protected void loadData() {
        messageUtil = new MessageUtil();
        messageUtil.getMessageList(flag,this);

    }

    @Override
    protected void initListener() {

    }


    @Override
    public void succeed(String mgs) {
        Log.e("HotFragment",mgs);
        XStream xStream = new XStream();
        xStream.alias("oschina", MessageEntity.class);
        xStream.alias("news",MessageEntity.NewsBean.class);
        MessageEntity messageEntity = (MessageEntity) xStream.fromXML(mgs);
        newslist = messageEntity.getNewslist();
        allNewslist.addAll(newslist);
        refishRV.notifyDataSetChanged();


    }

    @Override
    public void fail(String mgs) {
        Log.e("HotFragment",mgs);
    }
}
