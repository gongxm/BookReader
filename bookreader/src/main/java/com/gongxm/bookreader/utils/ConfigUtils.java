package com.gongxm.bookreader.utils;

/**
 * Created by gongxm on 2016/7/21.
 */
import android.content.Context;
import android.content.SharedPreferences;

public class ConfigUtils {


    /**
     * 配置文件对象
     */
    private SharedPreferences config;

    /**
     * 私有构造方法
     * @param context
     */
    private ConfigUtils(Context context) {
        config = context.getSharedPreferences("config", Context.MODE_PRIVATE);
    };

    /**
     * 单例对象
     */
    private static ConfigUtils instance;

    /**
     * 初始化工具类
     * @param context
     */
    public static void init(Context context){
        if(instance==null){
            instance=new ConfigUtils(context);
        }
    }

    /**
     * 获取单例对象
     * @return
     */
    public static ConfigUtils getInstance(){
        return instance;
    }

    /**
     * 获取配置文件中的boolean值
     * @param key
     * @param defValue
     * @return
     */
    public boolean getBoolean(String key,boolean defValue){
        return config.getBoolean(key, defValue);
    }

    /**
     * 保存boolean值到配置文件中
     * @param key
     * @param value
     */
    public void setBoolean(String key,boolean value){
        config.edit().putBoolean(key, value).commit();
    }

}
