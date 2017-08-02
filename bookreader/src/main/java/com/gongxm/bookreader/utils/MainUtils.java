package com.gongxm.bookreader.utils;

/**************************************
 * @版本 1.0
 * @作者 gongxm
 * @时间 2016/7/21 11:49
 * @修正
 * @版权所有 gongxm
 * @描述
 ***************************************/

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import com.gongxm.bookreader.activities.MainActivity;
import com.gongxm.bookreader.bean.UserInfo;


public class MainUtils {
    public static Activity getActivity(){
        return MainActivity.instance;
    }

    /**
     * 在主线程运行任务
     * @param runnable
     */
    public static void runOnUiThread(Runnable runnable) {
        getActivity().runOnUiThread(runnable);
    }

    /**
     * 获取用户手机信息
     * @return
     */
    public static UserInfo getUserInfo(){
        TelephonyManager  tm = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        WifiManager wifi = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        String imsi = tm.getSubscriberId();
        String operator = NetUtils.getOperator(tm.getSimOperator());
        String mac=info.getMacAddress();
        String version=android.os.Build.VERSION.RELEASE;
        String model=android.os.Build.MODEL;
        UserInfo userInfo=new UserInfo();
        userInfo.setImsi(imsi);
        userInfo.setModel(model);
        userInfo.setOperator(operator);
        userInfo.setVersion(version);
        userInfo.setMac(mac);
        return userInfo;
    }
}
