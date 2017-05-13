package practice.code.com.baseframework.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import practice.code.com.baseframework.App;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public abstract class BaseFragmnet extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(initLayoutID(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initView();
        initListener();
    }

    @Override
    public void onResume() {
        super.onResume();
        initData();
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
