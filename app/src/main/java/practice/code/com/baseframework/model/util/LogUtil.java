package practice.code.com.baseframework.model.util;

import android.util.Log;

/**
 * Created by Administrator on 2017/5/11 0011.
 */

public class LogUtil {

    public static final boolean aboolean = true;

    public static void e(String tag,String mge){
        if(aboolean == true){
            Log.e(tag,mge);
        }
    }

}
