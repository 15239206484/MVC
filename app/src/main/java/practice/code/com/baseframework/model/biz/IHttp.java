package practice.code.com.baseframework.model.biz;

import java.util.Map;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public interface IHttp {

    void doGET(String url , Map<String,String> map , ICallBack callBack);
    void doPOST(String url , Map<String,String> map , ICallBack callBack);

}
