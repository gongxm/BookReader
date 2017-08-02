package com.gongxm.bookreader.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/21 11:58
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

public class UIUtils {

    /**
     * dip转换px
     */
    public static int dip2px(int dip) {
        final float scale = MainUtils.getActivity().getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */
    public static int px2dip(int px) {
        final float scale = MainUtils.getActivity().getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }


    public static View inflate(int resId) {
        return LayoutInflater.from(MainUtils.getActivity()).inflate(resId, null);
    }

    public static View inflate(ViewGroup parent, int resId) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }

    public static View inflate(ViewGroup parent, int resId,boolean attachToRoot) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, attachToRoot);
    }

    /**
     * 获取资源
     */
    public static Resources getResources() {
        return MainUtils.getActivity().getResources();
    }

    /**
     * 获取文字
     */
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * 获取文字数组
     */
    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 获取dimen
     */
    public static int getDimens(int resId) {
        return getResources().getDimensionPixelSize(resId);
    }

    /**
     * 获取drawable
     */
    public static Drawable getDrawable(int resId) {
        return getResources().getDrawable(resId);
    }

    /**
     * 获取颜色
     */
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**
     * 获取颜色选择
     */
    public static ColorStateList getColorStateList(int resId) {
        return getResources().getColorStateList(resId);
    }

    public static void runInMainThread(Runnable runnable) {
        MainUtils.getActivity().runOnUiThread(runnable);
    }

    public static Context getContext() {
        return MainUtils.getActivity();
    }

}
