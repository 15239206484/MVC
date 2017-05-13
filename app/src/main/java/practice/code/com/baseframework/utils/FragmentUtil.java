package practice.code.com.baseframework.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import practice.code.com.baseframework.App;
import practice.code.com.baseframework.R;
import practice.code.com.baseframework.fragment.BaseFragmnet;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class FragmentUtil  {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private String simpleName;
    private BaseFragmnet listFragment;

    private FragmentUtil(){

    }

    private static FragmentUtil fragmentUtil = null;

    public static FragmentUtil getInstance(){
        if(fragmentUtil == null){
            synchronized (FragmentUtil.class){
                fragmentUtil = new FragmentUtil();
            }
        }
        return fragmentUtil;
    }

    //  进行实务的操作
    public  FragmentUtil start(Class<? extends BaseFragmnet> fragmentClass){
        manager = App.activity.getSupportFragmentManager();
        simpleName = fragmentClass.getSimpleName();
        BaseFragmnet fragmentByTag = (BaseFragmnet) manager.findFragmentByTag(simpleName);
        Log.e("TAG",simpleName);
        transaction = manager.beginTransaction();
        if(fragmentByTag == null){
            try {
                fragmentByTag  =  fragmentClass.newInstance();
                transaction.add(R.id.frame_add,fragmentByTag,simpleName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        if(listFragment != null){
            transaction.hide(listFragment);
        }

        transaction.show(fragmentByTag);
        listFragment = fragmentByTag ;
        transaction.addToBackStack(simpleName);
        transaction.commit();

        return this;

    }


}
