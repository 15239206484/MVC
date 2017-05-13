package practice.code.com.baseframework.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.thoughtworks.xstream.XStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import practice.code.com.baseframework.R;
import practice.code.com.baseframework.model.biz.ICallBack;
import practice.code.com.baseframework.model.entity.LoginEntity;
import practice.code.com.baseframework.model.util.LoginUtil;

public class Login extends AppCompatActivity implements ICallBack{

    @Bind(R.id.login_username)
    EditText loginUsername;
    @Bind(R.id.login_password)
    EditText loginPassword;
    @Bind(R.id.go_login)
    Button goLogin;
    @Bind(R.id.activity_login)
    LinearLayout activityLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.go_login)
    public void onViewClicked() {
        String username = loginUsername.getText().toString().trim();

        String password = loginPassword.getText().toString().trim();

        LoginUtil.getInstance().goLogin(username,password,this);

    }

    @Override
    public void succeed(String mgs) {
        Log.e("login",mgs);
        XStream xs = new XStream();
        xs.alias("oschina", LoginEntity.class);
        xs.alias("user",LoginEntity.UserBean.class);
        xs.alias("result",LoginEntity.ResultBean.class);
        xs.alias("notice",LoginEntity.NoticeBean.class);
        LoginEntity loginEntity = (LoginEntity) xs.fromXML(mgs);
        Toast.makeText(this, loginEntity.getResult().getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail(String mgs) {
        Log.e("login",mgs);
    }
}
