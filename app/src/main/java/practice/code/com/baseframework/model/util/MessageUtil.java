package practice.code.com.baseframework.model.util;

import java.util.HashMap;
import java.util.Map;

import practice.code.com.baseframework.contact.HttpContact;
import practice.code.com.baseframework.contact.OtherContact;
import practice.code.com.baseframework.model.biz.ICallBack;
import practice.code.com.baseframework.model.biz.IHttp;
import practice.code.com.baseframework.model.biz.IMessage;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class MessageUtil implements IMessage {

    /**
     *
     *
     * @param pageIndex 第几页
     */
    @Override
    public void getMessageList(int pageIndex, ICallBack callBack) {

        Map<String,String> map = new HashMap<>();

        map.put("catalog", OtherContact.CATALOG+"");
        map.put("pageIndex",pageIndex + "");
        map.put("pageSize",OtherContact.PAGESIZE +"");

        IHttp httpUtil = OkHttpUtilFactry.getHttpUtil();
        httpUtil.doGET(HttpContact.MESSGAEURL ,map ,callBack);

    }
}
