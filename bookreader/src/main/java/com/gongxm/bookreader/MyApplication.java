package com.gongxm.bookreader;

import android.app.Application;

import org.xutils.x;

/**
 * Created by gongxm on 2016/8/6.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化xUtils
        x.Ext.init(this);
    }
}
