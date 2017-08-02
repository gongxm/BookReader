package com.gongxm.bookreader.utils;

import android.app.Activity;

import com.gongxm.bookreader.database.DataBaseHelper;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/8/3 23:50
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class InitUtils {
    public static void init(Activity context) {
        //把需要初始化才能使用的工具类都放到这里来进行初始化.

        //初始化SharedPreferences工具类
        ConfigUtils.init(context);
        //初始化数据库
        DataBaseHelper.getInstance();

        //初始化解析正则
        ParseHtmlRegexUtils.addRegex();
    }
}
