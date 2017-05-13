package practice.code.com.baseframework.model.util;

import java.util.HashMap;
import java.util.Map;

import practice.code.com.baseframework.contact.HttpContact;
import practice.code.com.baseframework.contact.OtherContact;
import practice.code.com.baseframework.model.biz.ICallBack;
import practice.code.com.baseframework.model.biz.ILogin;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class LoginUtil implements ILogin {

    private LoginUtil(){}
    private static LoginUtil loginUtil = new LoginUtil();
    public static LoginUtil getInstance(){
        return loginUtil;
    }

    @Override
    public void goLogin(String usename, String password ,ICallBack callBack) {
//        String url, Map<String, String> map, final ICallBack callBack)
        Map<String,String> map = new HashMap<>();
        map.put("username",usename);
        map.put("pwd",password);
        map.put("keep_login", OtherContact.KEEP_LOGIN);
        OkHttpUtil.getOkHttpUrl().doPOST(HttpContact.LOGINURL,map,callBack);
    }
}
