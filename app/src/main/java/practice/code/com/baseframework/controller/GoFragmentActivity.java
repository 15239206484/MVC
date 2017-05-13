package practice.code.com.baseframework.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import practice.code.com.baseframework.R;
import practice.code.com.baseframework.fragment.HotFragment;
import practice.code.com.baseframework.utils.FragmentUtil;

public class GoFragmentActivity extends BaseActivity {


    @Bind(R.id.frame_add)
    FrameLayout frameAdd;
    @Bind(R.id.hot_select)
    Button hotSelect;
    @Bind(R.id.blog_select)
    Button blogSelect;
    @Bind(R.id.other_select)
    Button otherSelect;
    @Bind(R.id.activity_go_fragment)
    LinearLayout activityGoFragment;

    @Override
    protected int initLayoutID() {
        return R.layout.activity_go_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentUtil.getInstance().start(HotFragment.class);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {

    }



    @OnClick({R.id.hot_select, R.id.blog_select, R.id.other_select})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.hot_select:
                break;
            case R.id.blog_select:
                break;
            case R.id.other_select:
                break;
        }
    }
}
