package practice.code.com.baseframework.model.util;

import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import practice.code.com.baseframework.App;
import practice.code.com.baseframework.model.biz.ICallBack;
import practice.code.com.baseframework.model.biz.IHttp;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class OkHttpUtil implements IHttp {

    private OkHttpUtil(){}
    private static OkHttpUtil okHttpUtil = new OkHttpUtil();
    public static OkHttpUtil getOkHttpUrl(){
        return okHttpUtil;
    }


    @Override
    public void doGET(String url, Map<String, String> map, final ICallBack callBack) {

        OkHttpClient okHttpClient = new OkHttpClient();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");
        if(map != null){
            Set<String> keyset = map.keySet();
            for(String key : keyset){
                String value = map.get(key);
                stringBuffer.append(key).append("=").append(value).append("&");

            }
        }
        url = url + stringBuffer.toString().substring(0, stringBuffer.length() - 1);


        Request request = new Request.Builder()
                .url(url)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                LogUtil.e("okhttp", e.toString());

                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.fail( e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();


                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                            callBack.succeed(string);

                    }
                });
            }
        });

    }

    @Override
    public void doPOST(String url, Map<String, String> map, final ICallBack callBack) {

        OkHttpClient client = new OkHttpClient();
        final FormBody.Builder body = new FormBody.Builder();
        if (map != null) {
            Set<String> strings = map.keySet();
            for (String key : strings) {
                String value = map.get(key);
                body.add(key, value);
            }

        }

        Request request = new Request.Builder()
                .url(url)
                .post(body.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                LogUtil.e("okhttp", e.toString());

                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callBack.fail( e.toString());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       callBack.succeed(string);
                    }
                });

            }
        });


    }
}
