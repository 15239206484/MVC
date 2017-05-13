package practice.code.com.baseframework.model.util;

import practice.code.com.baseframework.model.biz.IHttp;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class OkHttpUtilFactry {

    public static final int OKHTTP = 0;
    public static final int VOLLEY = 1;
    public static final int RETRFIT = 2;
    public static final int TYPE = OKHTTP;

    public static IHttp getHttpUtil() {
        IHttp iHttp = null;

        switch (TYPE) {
            case 0:
                iHttp =  OkHttpUtil.getOkHttpUrl();
                break;
            case 1:
                break;

            case 2:
                break;
            default:
                break;
        }
        return iHttp;
    }

}
