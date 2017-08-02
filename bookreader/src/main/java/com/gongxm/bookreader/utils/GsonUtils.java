package com.gongxm.bookreader.utils;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/21 11:47
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonUtils {
    private static Gson gson = new Gson();

    //对象转json
    public static <T> String toJson(T t) {
        String json = "{}";
        try {
            json = gson.toJson(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }


    //json转对象
    public static <T> T fromJson(String json, Type type) {
        T t = null;
        try {
            t = gson.fromJson(json, type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
